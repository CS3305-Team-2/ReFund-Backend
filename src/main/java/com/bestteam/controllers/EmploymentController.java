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

// import com.bestteam.exceptions.UserNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Employment;
import com.bestteam.repository.EmploymentRepository;

@RestController
@RequestMapping("/employment")
public class EmploymentController {

    @Autowired
    private EmploymentRepository repository;

    @GetMapping
    public List<Employment> getEmploymentCollection() {
        return (List<Employment>)repository.findAll();
    }

    // TODO more than this lmao
    @PostMapping
    public void createEmployment(@Valid @RequestBody Employment employment) {
        repository.save(employment);
    }
    //
    // @GetMapping("/{userId}")
    // public Response<User> getUser(@PathVariable("userId") Long userId) {
    //     Optional<User> user = repository.findById(userId);
    //     if (!user.isPresent()) {
    //         throw new UserNotFoundException(userId.toString());
    //     }
    //     return new Response<>(user.get());
    // }

}
