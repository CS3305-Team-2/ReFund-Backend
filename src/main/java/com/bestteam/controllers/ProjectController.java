package com.bestteam.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.models.Project;
import com.bestteam.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectRepository repository;

    @GetMapping
    public List<Project> getProjects(@RequestParam(value="sfi", required=false) Boolean sfiApproved, @RequestParam(value="ro", required=false) Boolean roApproved) {
        if (sfiApproved != null && roApproved != null) {
            return repository.findBySfiApprovedAndRoApproved(sfiApproved, roApproved);
        } else if (sfiApproved == null && roApproved != null) {
            return repository.findByRoApproved(roApproved);
        } else if (roApproved == null && sfiApproved != null) {
            return repository.findBySfiApproved(sfiApproved);
        }
        List<Project> projects = new ArrayList<>();
        repository.findAll().forEach(projects::add);
        return projects;
    }
}