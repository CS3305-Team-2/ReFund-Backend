package com.bestteam.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.helpers.Response;
import com.bestteam.models.ProjectReport;
import com.bestteam.repository.ProjectReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projectReport")
public class ProjectReportController {
    @Autowired
    private ProjectReportRepository repository;

    //TODO filter
    @GetMapping
    public Response<List<ProjectReport>> getProjectReports() {
        List<ProjectReport> projectReports = new ArrayList<>();
        repository.findAll().forEach(projectReports::add);
        return new Response<>(projectReports);
    }

    @GetMapping("/{projectReportId}")
    public Response<ProjectReport> getProjectReport(@PathVariable("projectReportId") Long projectReportId) {
        return new Response<>(repository.findById(projectReportId).get());
    }
}
