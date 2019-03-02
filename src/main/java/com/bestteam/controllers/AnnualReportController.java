package com.bestteam.controllers;

import java.util.ArrayList;
import java.util.List;

import com.bestteam.helpers.Response;
import com.bestteam.models.AnnualReport;
import com.bestteam.repository.AnnualReportRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/annualReport")
public class AnnualReportController {
    @Autowired
    private AnnualReportRepository repository;

    //TODO filter
    @GetMapping
    public Response<List<AnnualReport>> getAnnualReports() {
        List<AnnualReport> annualReports = new ArrayList<>();
        repository.findAll().forEach(annualReports::add);
        return new Response<>(annualReports);
    }

    @GetMapping("/{annualReportId}")
    public Response<AnnualReport> getAnnualReport(@PathVariable("annualReportId") Long annualReportId) {
        return new Response<>(repository.findById(annualReportId).get());
    }

    @PostMapping
    public void createAnnualReport(@Valid @RequestBody AnnualReport annualReport) {
        repository.save(annualReport);
    }

}
