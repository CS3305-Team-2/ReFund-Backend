package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bestteam.exceptions.UserNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.User;
import com.bestteam.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping
    public List<User> getUserCollection() {
        return (List<User>)repository.findAll();
    }
    
    // TODO more than this lmao
    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        repository.save(user);
    }

    @GetMapping("/{userId}")
    public Response<User> getUser(@PathVariable("userId") Long userId) {
        Optional<User> user = repository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId.toString());
        }
        return new Response<>(user.get());
    }
}