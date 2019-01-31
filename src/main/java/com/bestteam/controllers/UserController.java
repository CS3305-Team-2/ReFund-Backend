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

import com.bestteam.exceptions.UserNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.User;
import com.bestteam.models.Awards;
import com.bestteam.models.Education;
import com.bestteam.repository.UserRepository;
import com.bestteam.repository.EducationRepository;
import com.bestteam.repository.AwardsRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private AwardsRepository awardsRepository;

    @GetMapping
    public List<User> getUserCollection() {
        return (List<User>)repository.findAll();
    }

    // TODO more than this lmao
    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        repository.save(user);
    }

    @GetMapping("/{userId}")
    public Response<User> getUser(@PathVariable("userId") Long userId) {
        Optional<User> user = repository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId.toString());
        }
        return new Response<>(user.get());
    }

    @GetMapping("/{userId}/educations")
    public Response<List<Education>> getUserEducations(@PathVariable("userId") Long userId) {
        List<Education> list = new ArrayList<>();
        educationRepository.findByEducationIdentityUserId(userId).forEach(list::add);
        return new Response<>(list);
    }

    @GetMapping("/{userId}/awards")
    public Response<List<Awards>> getUserAwards(@PathVariable("userId") Long userId) {
        List<Awards> list = new ArrayList<>();
        awardsRepository.findByAwardsIdentityUserId(userId).forEach(list::add);
        return new Response<>(list);
    }
}
