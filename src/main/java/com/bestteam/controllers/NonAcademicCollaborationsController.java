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

import com.bestteam.exceptions.NonAcademicCollaborationsNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.NonAcademicCollaborations;
import com.bestteam.repository.NonAcademicCollaborationsRepository;

@RestController
@RequestMapping("/api/nonAcademicCollaborations")
public class NonAcademicCollaborationsController {

    @Autowired
    private NonAcademicCollaborationsRepository repository;

    @GetMapping
    public Response<List<NonAcademicCollaborations>> getNonAcademicCollaborationsCollection() {
        List<NonAcademicCollaborations> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createNonAcademicCollaborations(@Valid @RequestBody NonAcademicCollaborations nonAcademicCollaborations) {
        repository.save(nonAcademicCollaborations);
    }

    @GetMapping("/{nonAcademicCollaborationsId}")
    public Response<NonAcademicCollaborations> getNonAcademicCollaborations(@PathVariable("nonAcademicCollaborationsId") Long nonAcademicCollaborationsId) {
        Optional<NonAcademicCollaborations> nonAcademicCollaborations = repository.findById(nonAcademicCollaborationsId);
        if (!nonAcademicCollaborations.isPresent()) {
            throw new NonAcademicCollaborationsNotFoundException(nonAcademicCollaborations.toString());
        }
        return new Response<>(nonAcademicCollaborations.get());
    }
}
