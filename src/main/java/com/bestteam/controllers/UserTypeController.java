package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.models.UserType;
import com.bestteam.repository.UserTypeRepository;

@RestController
public class UserTypeController {

    @Autowired
    private UserTypeRepository repository;
    
    @GetMapping("/usertypes")
    public List<UserType> getTypes() {
        List<UserType> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}