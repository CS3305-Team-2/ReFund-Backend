package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.models.Education;
import com.bestteam.repository.EducationRepository;

@RestController
public class EducationController {

    @Autowired
    private EducationRepository repository;

    @GetMapping("/education")
    public List<Education> getTypes() {
        List<Education> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}
