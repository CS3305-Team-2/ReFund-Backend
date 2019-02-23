package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.bestteam.helpers.Response;
import com.bestteam.models.Impact;
import com.bestteam.repository.ImpactRepository;

@RestController
@RequestMapping("/api/impacts")
public class ImpactController {

    @Autowired
    private ImpactRepository repository;

    @GetMapping("/{userId}")
    public Response<List<Impact>> getImpactsForUser(@PathVariable("userId") Long userId) {
        List<Impact> list = new ArrayList<>();
        repository.findByImpactIdentityUserId(userId).forEach(list::add);
        return new Response<>(list);
    }
    @PostMapping
    public void createImpact(@Valid @RequestBody Impact impact) {
        repository.save(impact);
    }
}
