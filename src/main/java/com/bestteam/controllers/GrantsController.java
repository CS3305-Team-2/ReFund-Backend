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

import com.bestteam.exceptions.GrantsNotFoundException;
import com.bestteam.models.Grants;
import com.bestteam.helpers.Response;
import com.bestteam.repository.GrantsRepository;

@RestController
@RequestMapping("/api/grants")
public class GrantsController {

    @Autowired
    private GrantsRepository repository;

    @GetMapping
    public List<Grants> getGrantsCollection() {
        return (List<Grants>)repository.findAll();
    }

    // TODO more than this lmao
    @PostMapping
    public void createGrants(@Valid @RequestBody Grants grant) {
        repository.save(grant);
    }

    @GetMapping("/{grantId}")
    public Response<Grants> getGrants(@PathVariable("grantId") Long grantId) {
        Optional<Grants> grant = repository.findById(grantId);
        if (!grant.isPresent()) {
            throw new GrantsNotFoundException(grantId.toString());
        }
        return new Response<>(grant.get());
    }

}
