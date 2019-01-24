package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bestteam.helpers.Response;
import com.bestteam.models.User;
import com.bestteam.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping("/users")
    public List<User> getUserCollection() {
        List<User> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
    
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        System.out.println(user);
    }

    @GetMapping("/users/{userId}")
    public Response<User> getUser(@PathVariable("userId") Long userId) {
        Optional<User> user = repository.findById(userId);
        if (!user.isPresent()) {
            return new Response<>(HttpStatus.NOT_FOUND);
        }
        return new Response<>(user.get());
    }

}