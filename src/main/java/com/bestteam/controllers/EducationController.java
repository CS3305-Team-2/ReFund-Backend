package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.helpers.Response;
import com.bestteam.models.Education;
import com.bestteam.repository.EducationRepository;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationRepository repository;

    @GetMapping("/{userId}")
    public Response<List<Education>> getEducationsForUser(@PathVariable("userId") Long userId) {
        List<Education> list = new ArrayList<>();
        repository.findByEducationIdentityUserId(userId).forEach(list::add);
        return new Response<>(list);
    }
}
