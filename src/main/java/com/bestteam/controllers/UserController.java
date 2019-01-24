package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.models.User;
import com.bestteam.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping("/user")
    public List<User> getTypes() {
        List<User> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}