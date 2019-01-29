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

import com.bestteam.exceptions.AwardsNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Awards;
import com.bestteam.repository.AwardsRepository;
import com.bestteam.models.Awards;
import com.bestteam.models.AwardsIdentity;


@RestController
@RequestMapping("/awards")
public class AwardsController {

    @Autowired
    private AwardsRepository repository;

    @GetMapping
    public List<Awards> getAwardsCollection() {
        return (List<Awards>)repository.findAll();
    }

    // TODO more than this lmao
    @PostMapping
    public void createAwards(@Valid @RequestBody Awards awards) {
        repository.save(awards);
    }

    @GetMapping("/{awardsId}")
    public Response<Awards> getAwards(@PathVariable("awardsId") AwardsIdentity awardsId) {
        Optional<Awards> awards = repository.findById(awardsId);
        if (!awards.isPresent()) {
            throw new AwardsNotFoundException(awards.toString());
        }
        return new Response<>(awards.get());
    }

}
