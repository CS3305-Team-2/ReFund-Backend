package com.bestteam.controllers;

import java.util.Optional;

import com.bestteam.exceptions.LoginException;
import com.bestteam.helpers.JWTKey;
import com.bestteam.models.LoginUser;
import com.bestteam.models.User;
import com.bestteam.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> login(LoginUser loginUser) {
        Optional<User> user = repository.findByOrcid(loginUser.getOrcid());
        if(!user.isPresent()) {
            throw new LoginException("username not found");
        }

        if(!user.get().checkPassword(loginUser.getPassword())) {
            throw new LoginException("incorrect password");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("JWT-TOKEN", Jwts.builder().claim("role", user.get().getType().toString()).signWith(JWTKey.getKey()).compact());
        return ResponseEntity.ok().headers(headers).build();
    }
}