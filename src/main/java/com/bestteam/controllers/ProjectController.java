package com.bestteam.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.helpers.Response;
import com.bestteam.models.Project;
import com.bestteam.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectRepository repository;

    @GetMapping
    public Response<List<Project>> getProjects(@RequestParam(value="sfi", required=false) Boolean sfiApproved, @RequestParam(value="ro", required=false) Boolean roApproved) {
        if (sfiApproved != null && roApproved != null) {
            return new Response<>(repository.findBySfiApprovedAndRoApproved(sfiApproved, roApproved));
        } else if (sfiApproved == null && roApproved != null) {
            return new Response<>(repository.findByRoApproved(roApproved));
        } else if (roApproved == null && sfiApproved != null) {
            return new Response<>(repository.findBySfiApproved(sfiApproved));
        }
        List<Project> projects = new ArrayList<>();
        repository.findAll().forEach(projects::add);
        return new Response<>(projects);
    }

    @GetMapping("/{projectId")
    public Response<Project> getProject(@PathVariable("projectId") Long projectId) {
        return new Response<>(repository.findById(projectId).get());
    }
}