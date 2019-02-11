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

import com.bestteam.exceptions.ImpactNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Impact;
import com.bestteam.repository.ImpactRepository;

@RestController
@RequestMapping("/api/impacts")
public class ImpactController {

    @Autowired
    private ImpactRepository repository;

    @GetMapping
    public List<Impact> getImpactCollection() {
        return (List<Impact>)repository.findAll();
    }

    @GetMapping("/{impactId}")
    public Response<Impact> getImpact(@PathVariable("impactId") Long impactId) {
        Optional<Impact> impact = repository.findById(impactId);
        if (!impact.isPresent()) {
            throw new ImpactNotFoundException(impactId.toString());
        }
        return new Response<>(impact.get());
    }
}
