package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.models.HostInstitution;
import com.bestteam.repository.HostInstitutionRepository;

@RestController
@RequestMapping("/api/hostInstitution")
public class HostInstitutionController {

    @Autowired
    private HostInstitutionRepository repository;

    @GetMapping
    public List<HostInstitution> getHostInstitution() {
        return (List<HostInstitution>)repository.findAll();
    }
}
