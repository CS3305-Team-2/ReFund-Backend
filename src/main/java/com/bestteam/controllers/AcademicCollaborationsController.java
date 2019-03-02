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

import com.bestteam.exceptions.AcademicCollaborationsNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.AcademicCollaborations;
import com.bestteam.repository.AcademicCollaborationsRepository;

@RestController
@RequestMapping("/api/academicCollaborations")
public class AcademicCollaborationsController {

    @Autowired
    private AcademicCollaborationsRepository repository;

    @GetMapping
    public Response<List<AcademicCollaborations>> getAcademicCollaborationsCollection() {
        List<AcademicCollaborations> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createAcademicCollaborations(@Valid @RequestBody AcademicCollaborations academicCollaborations) {
        repository.save(academicCollaborations);
    }

    @GetMapping("/{academicCollaborationsId}")
    public Response<AcademicCollaborations> getAcademicCollaborations(@PathVariable("academicCollaborationsId") Long academicCollaborationsId) {
        Optional<AcademicCollaborations> academicCollaborations = repository.findById(academicCollaborationsId);
        if (!academicCollaborations.isPresent()) {
            throw new AcademicCollaborationsNotFoundException(academicCollaborations.toString());
        }
        return new Response<>(academicCollaborations.get());
    }
}
