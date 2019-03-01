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
import com.bestteam.models.Presentation;
import com.bestteam.repository.PresentationRepository;

@RestController
@RequestMapping("/api/presentations")
public class PresentationController {

    @Autowired
    private PresentationRepository repository;

    @GetMapping("/{userId}")
    public Response<List<Presentation>> getPresentationsForUser(@PathVariable("userId") Long userId) {
        List<Presentation> list = new ArrayList<>();
        repository.findByUserId(userId).forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createPresentation(@Valid @RequestBody Presentation presentation) {
        repository.save(presentation);
    }
}
