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

import com.bestteam.exceptions.SocietyMembershipNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.SocietyMembership;
import com.bestteam.repository.SocietyMembershipRepository;

@RestController
@RequestMapping("/api/societyMembership")
public class SocietyMembershipController {

    @Autowired
    private SocietyMembershipRepository repository;

    @GetMapping
    public List<SocietyMembership> getSocietyMembershipCollection() {
        return (List<SocietyMembership>)repository.findAll();
    }

    @PostMapping
    public void createSocietyMembership(@Valid @RequestBody SocietyMembership societyMembership) {
        repository.save(societyMembership);
    }

    @GetMapping("/{societyMembershipId}")
    public Response<SocietyMembership> getSocietyMembership(@PathVariable("societyMembershipId") Long societyMembershipId) {
        Optional<SocietyMembership> societyMembership = repository.findById(societyMembershipId);
        if (!societyMembership.isPresent()) {
            throw new SocietyMembershipNotFoundException(societyMembership.toString());
        }
        return new Response<>(societyMembership.get());
    }
}
