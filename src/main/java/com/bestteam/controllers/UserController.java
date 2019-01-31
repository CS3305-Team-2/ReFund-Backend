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

import com.bestteam.exceptions.UserNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.User;
import com.bestteam.models.Awards;
import com.bestteam.models.Employment;
import com.bestteam.models.Education;
import com.bestteam.models.SocietyMembership;
import com.bestteam.repository.UserRepository;
import com.bestteam.repository.SocietyMembershipRepository;
import com.bestteam.repository.EducationRepository;
import com.bestteam.repository.AwardsRepository;
import com.bestteam.repository.EmploymentRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private AwardsRepository awardsRepository;

    @Autowired
    private EmploymentRepository employmentRepository;

    @Autowired
    private SocietyMembershipRepository societyMembershipRepository;

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
        return new Response<>(educationRepository.findByEducationIdentityUserId(userId));
    }

    @GetMapping("/{userId}/awards")
    public Response<List<Awards>> getUserAwards(@PathVariable("userId") Long userId) {
        return new Response<>(awardsRepository.findByAwardsIdentityUserId(userId));
    }

    @GetMapping("/{userId}/employments")
    public Response<List<Employment>> getUserEmployments(@PathVariable("userId") Long userId) {
        return new Response<>(employmentRepository.findByEmploymentIdentityUserId(userId));
    }
    @GetMapping("/{userId}/societymemberships")
    public Response<List<SocietyMembership>> getUserSocietyMemberships(@PathVariable("userId") Long userId) {
        return new Response<>(societyMembershipRepository.findBySocietyMembershipIdentityUserId(userId));
    }
}
