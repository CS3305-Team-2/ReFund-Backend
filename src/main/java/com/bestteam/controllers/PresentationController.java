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

import com.bestteam.exceptions.PresentationNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Presentation;
import com.bestteam.repository.PresentationRepository;

@RestController
@RequestMapping("/api/presentations")
public class PresentationController {

    @Autowired
    private PresentationRepository repository;

    @GetMapping
    public List<Presentation> getPresentationCollection() {
        return (List<Presentation>)repository.findAll();
    }

    @GetMapping("/{presentationId}")
    public Response<Presentation> getPresentation(@PathVariable("presentationId") Long presentationId) {
        Optional<Presentation> presentation = repository.findById(presentationId);
        if (!presentation.isPresent()) {
            throw new PresentationNotFoundException(presentationId.toString());
        }
        return new Response<>(presentation.get());
    }
}
