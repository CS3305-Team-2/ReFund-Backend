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
import com.bestteam.models.Awards;
import com.bestteam.repository.AwardsRepository;

@RestController
@RequestMapping("/api/awards")
public class AwardsController {

    @Autowired
    private AwardsRepository repository;

    @GetMapping
    public List<Awards> getAwardsCollection() {
        return (List<Awards>)repository.findAll();
    }

    @PostMapping
    public void createAwards(@Valid @RequestBody Awards awards) {
        repository.save(awards);
    }

    @GetMapping("/{userId}")
    public Response<List<Awards>> getAwards(@PathVariable("userId") Long userId) {
        List<Awards> list = new ArrayList<>();
        repository.findByUserId(userId).forEach(list::add);
        return new Response<>(list);
    }

}
