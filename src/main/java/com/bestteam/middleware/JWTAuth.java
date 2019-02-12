package com.bestteam.middleware;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestteam.helpers.Error;
import com.bestteam.helpers.JWTKey;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;

public class JWTAuth extends OncePerRequestFilter {
    private List<String> exludes = Arrays.asList(
        "/api/docs/"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        try {
            Cookie[] cookies = request.getCookies();
            if(cookies == null) cookies = new Cookie[]{};
            boolean found = false;
            for(int i = 0; i < cookies.length && !found; i++) {
                found = cookies[i].getName().matches("JWT-TOKEN");
            }
            
            if(!found || cookies.length == 0) {
                writeError(response, "no JWT token sent");
                return;
            }

            Jwts.parser().setSigningKey(JWTKey.getKey()).parse(cookies[0].getValue());
        } catch(SignatureException e) {
            try {
                writeError(response, "invalid JWT token");
            } catch(IOException ioe) {
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return;
            }
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        } catch(IOException ioe) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return;
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        AntPathMatcher matcher = new AntPathMatcher();
        return exludes.stream().anyMatch(p -> matcher.match(p, request.getServletPath()));
    }

    private void writeError(HttpServletResponse res, String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Error error = new Error(new String[]{message});
        String errorString = mapper.writeValueAsString(error);
        res.setContentLength(errorString.length());
        res.getWriter().write(errorString);
    }
}