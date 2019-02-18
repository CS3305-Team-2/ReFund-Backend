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
import com.bestteam.models.Innovation;
import com.bestteam.repository.InnovationRepository;

@RestController
@RequestMapping("/api/innovations")
public class InnovationController {

    @Autowired
    private InnovationRepository repository;

    @GetMapping("/{userId}")
    public Response<List<Innovation>> getInnovationsForUser(@PathVariable("userId") Long userId) {
        List<Innovation> list = new ArrayList<>();
        repository.findByInnovationIdentityUserId(userId).forEach(list::add);
        return new Response<>(list);
    }

    // TODO more than this lmao
    @PostMapping
    public void createInnovation(@Valid @RequestBody Innovation innovation) {
        repository.save(innovation);
    }
}
