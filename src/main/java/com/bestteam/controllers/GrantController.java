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

import com.bestteam.exceptions.GrantNotFoundException;
import com.bestteam.models.Grant;
import com.bestteam.helpers.Response;
import com.bestteam.repository.GrantRepository;

@RestController
@RequestMapping("/api/grants")
public class GrantController {

    @Autowired
    private GrantRepository repository;

    @GetMapping
    public List<Grant> getGrantCollection() {
        return (List<Grant>)repository.findAll();
    }

    // TODO more than this lmao
    @PostMapping
    public void createGrant(@Valid @RequestBody Grant grant) {
        repository.save(grant);
    }

    @GetMapping("/{grantId}")
    public Response<Grant> getGrant(@PathVariable("grantId") Long grantId) {
        Optional<Grant> grant = repository.findById(grantId);
        if (!grant.isPresent()) {
            throw new GrantNotFoundException(grantId.toString());
        }
        return new Response<>(grant.get());
    }

}
