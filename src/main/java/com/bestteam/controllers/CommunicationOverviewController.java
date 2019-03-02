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

import com.bestteam.exceptions.CommunicationOverviewNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.CommunicationOverview;
import com.bestteam.repository.CommunicationOverviewRepository;

@RestController
@RequestMapping("/api/communicationOverview")
public class CommunicationOverviewController {

    @Autowired
    private CommunicationOverviewRepository repository;

    @GetMapping
    public Response<List<CommunicationOverview>> getCommunicationOverviewCollection() {
        List<CommunicationOverview> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createCommunicationOverview(@Valid @RequestBody CommunicationOverview communicationOverview) {
        repository.save(communicationOverview);
    }

    @GetMapping("/{communicationOverviewId}")
    public Response<CommunicationOverview> getCommunicationOverview(@PathVariable("communicationOverviewId") Long communicationOverviewId) {
        Optional<CommunicationOverview> communicationOverview = repository.findById(communicationOverviewId);
        if (!communicationOverview.isPresent()) {
            throw new CommunicationOverviewNotFoundException(communicationOverview.toString());
        }
        return new Response<>(communicationOverview.get());
    }
}
