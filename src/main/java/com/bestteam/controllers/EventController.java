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

import com.bestteam.exceptions.EventNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Event;
import com.bestteam.repository.EventRepository;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventRepository repository;

    @GetMapping
    public Response<List<Event>> getEventCollection() {
        List<Event> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return new Response<>(list);
    }

    @PostMapping
    public void createEvent(@Valid @RequestBody Event event) {
        repository.save(event);
    }

    @GetMapping("/{eventId}")
    public Response<Event> getEvent(@PathVariable("eventId") Long eventId) {
        Optional<Event> event = repository.findById(eventId);
        if (!event.isPresent()) {
            throw new EventNotFoundException(event.toString());
        }
        return new Response<>(event.get());
    }
}
