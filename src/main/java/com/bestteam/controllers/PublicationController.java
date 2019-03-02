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

import com.bestteam.exceptions.PublicationNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Publication;
import com.bestteam.repository.PublicationRepository;

@RestController
@RequestMapping("/api/publication")
public class PublicationController {

    @Autowired
    private PublicationRepository repository;

    @GetMapping
    public Response<List<Publication>> getPublicationCollection() {
        List<Publication> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createPublication(@Valid @RequestBody Publication publication) {
        repository.save(publication);
    }

    @GetMapping("/{publicationId}")
    public Response<Publication> getPublication(@PathVariable("publicationId") Long publicationId) {
        Optional<Publication> publication = repository.findById(publicationId);
        if (!publication.isPresent()) {
            throw new PublicationNotFoundException(publication.toString());
        }
        return new Response<>(publication.get());
    }
}
