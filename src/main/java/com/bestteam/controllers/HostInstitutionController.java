package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.bestteam.helpers.Response;
import com.bestteam.models.HostInstitution;
import com.bestteam.repository.HostInstitutionRepository;

@RestController
@RequestMapping("/api/hostInstitution")
public class HostInstitutionController {

    @Autowired
    private HostInstitutionRepository repository;

    @GetMapping
    public Response<List<HostInstitution>> getHostInstitutions() {
        return new Response<>((List<HostInstitution>)repository.findAll());
    }

    @GetMapping("/{hostInstitutionId}")
    public Response<HostInstitution> getHostInstitution(@PathVariable("hostInstitutionId") Long hostInstitutionId) {
        return new Response<>(repository.findById(hostInstitutionId).get());
    }
}
