package com.bestteam.controllers;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.bestteam.exceptions.LoginException;
import com.bestteam.helpers.JWTKey;
import com.bestteam.helpers.Response;
import com.bestteam.models.LoginUser;
import com.bestteam.models.User;
import com.bestteam.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;

@RequestMapping("/api/")
@RestController
public class SessionController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Response<User> login(LoginUser loginUser, HttpServletResponse response) {
        Optional<User> user = repository.findByEmail(loginUser.getEmail());
        if(!user.isPresent()) {
            throw new LoginException("user with email not found");
        }

        if(!user.get().checkPassword(loginUser.getPassword())) {
            throw new LoginException("incorrect password");
        }

        response.addCookie(new Cookie("JWT-TOKEN", Jwts.builder().claim("role", user.get().getType().toString()).signWith(JWTKey.getKey()).compact()));
        return new Response<User>(user.get());
    }
}