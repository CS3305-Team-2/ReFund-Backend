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

import com.bestteam.exceptions.SfiFundingRatioNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.SfiFundingRatio;
import com.bestteam.repository.SfiFundingRatioRepository;

@RestController
@RequestMapping("/api/sfiFundingRatio")
public class SfiFundingRatioController {

    @Autowired
    private SfiFundingRatioRepository repository;

    @GetMapping
    public Response<List<SfiFundingRatio>> getSfiFundingRatioCollection() {
        List<SfiFundingRatio> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createSfiFundingRatio(@Valid @RequestBody SfiFundingRatio sfiFundingRatio) {
        repository.save(sfiFundingRatio);
    }

    @GetMapping("/{sfiFundingRatioId}")
    public Response<SfiFundingRatio> getSfiFundingRatio(@PathVariable("sfiFundingRatioId") Long sfiFundingRatioId) {
        Optional<SfiFundingRatio> sfiFundingRatio = repository.findById(sfiFundingRatioId);
        if (!sfiFundingRatio.isPresent()) {
            throw new SfiFundingRatioNotFoundException(sfiFundingRatio.toString());
        }
        return new Response<>(sfiFundingRatio.get());
    }
}
