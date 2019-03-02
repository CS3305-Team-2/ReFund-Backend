package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import com.bestteam.exceptions.EducationAndPublicEngagementNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.EducationAndPublicEngagement;
import com.bestteam.repository.EducationAndPublicEngagementRepository;

@RestController
@RequestMapping("/api/educationAndPublicEngagement")
public class EducationAndPublicEngagementController {

    @Autowired
    private EducationAndPublicEngagementRepository repository;

    @GetMapping
    public Response<List<EducationAndPublicEngagement>> getEducationAndPublicEngagementCollection() {
        List<EducationAndPublicEngagement> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createEducationAndPublicEngagement(@Valid @RequestBody EducationAndPublicEngagement educationAndPublicEngagement) {
        repository.save(educationAndPublicEngagement);
    }

    @GetMapping("/{educationAndPublicEngagementId}")
    public Response<EducationAndPublicEngagement> getEducationAndPublicEngagement(@PathVariable("educationAndPublicEngagementId") Long educationAndPublicEngagementId) {
        Optional<EducationAndPublicEngagement> educationAndPublicEngagement = repository.findById(educationAndPublicEngagementId);
        if (!educationAndPublicEngagement.isPresent()) {
            throw new EducationAndPublicEngagementNotFoundException(educationAndPublicEngagement.toString());
        }
        return new Response<>(educationAndPublicEngagement.get());
    }
}
