package com.bestteam.middleware;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestteam.helpers.Error;
import com.bestteam.helpers.JWTKey;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;

public class JWTAuth implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            Cookie[] cookies = req.getCookies();
            if(cookies == null) cookies = new Cookie[]{};
            boolean found = false;
            for(int i = 0; i < cookies.length && !found; i++) {
                found = cookies[i].getName().matches("JWT-TOKEN");
            }
            
            if(!found || cookies.length == 0) {
                writeError(res, "no JWT token sent");
                return;
            }

            Jwts.parser().setSigningKey(JWTKey.getKey()).parse(cookies[0].getValue());
        } catch(SignatureException e) {
            try {
                writeError(res, "invalid JWT token");
            } catch(IOException ioe) {
                res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return;
            }
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
        } catch(IOException ioe) {
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return;
        }
    }

    private void writeError(HttpServletResponse res, String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Error error = new Error(new String[]{message});
        String errorString = mapper.writeValueAsString(error);
        res.setContentLength(errorString.length());
        res.getWriter().write(errorString);
    }

    @Override
    public void destroy() {}
}