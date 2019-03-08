package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.helpers.Response;
import com.bestteam.models.HostInstitution;
import com.bestteam.models.Project;
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

    @GetMapping("/{hostInstitutionId}/projects")
    public Response<List<Project>> getHostInstitutionProjects(@PathVariable("hostInstitutionId") Long hostInstitutionId) {
        ArrayList<Project> projects = new ArrayList<>();
        for(Object[] i: repository.getProjectsByHostInstitution(hostInstitutionId)) {
            projects.add(new Project());
            for(Object j: i) {
                if(j instanceof Integer) {
                    projects.get(projects.size() - 1).setId(Long.valueOf((Integer)j));
                } else if(j instanceof String) {
                    projects.get(projects.size() - 1).setName((String)j);
                }
            }
        }
        return new Response<>(projects);
    }
}
