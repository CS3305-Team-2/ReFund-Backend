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

import com.bestteam.exceptions.EmploymentNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Employment;
import com.bestteam.repository.EmploymentRepository;
import com.bestteam.models.EmploymentIdentity;

@RestController
@RequestMapping("/api/employment")
public class EmploymentController {

    @Autowired
    private EmploymentRepository repository;

    @GetMapping
    public List<Employment> getEmploymentCollection() {
        return (List<Employment>)repository.findAll();
    }

    // TODO more than this lmao
    @PostMapping
    public void createEmployment(@Valid @RequestBody Employment employment) {
        repository.save(employment);
    }

    @GetMapping("/{employmentId}")
    public Response<Employment> getEmployment(@PathVariable("employmentId") EmploymentIdentity employmentId) {
        Optional<Employment> employment = repository.findById(employmentId);
        if (!employment.isPresent()) {
            throw new EmploymentNotFoundException(employment.toString());
        }
        return new Response<>(employment.get());
    }
}