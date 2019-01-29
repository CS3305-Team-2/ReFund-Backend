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

import com.bestteam.exceptions.AwardNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.Award;
import com.bestteam.repository.AwardRepository;
import com.bestteam.models.Award;
import com.bestteam.models.AwardIdentity;


@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    private AwardRepository repository;

    @GetMapping
    public List<Award> getAwardCollection() {
        return (List<Award>)repository.findAll();
    }

    // TODO more than this lmao
    @PostMapping
    public void createAward(@Valid @RequestBody Award award) {
        repository.save(award);
    }

    @GetMapping("/{awardId}")
    public Response<Award> getAward(@PathVariable("awardId") AwardIdentity awardId) {
        Optional<Award> award = repository.findById(awardId);
        if (!award.isPresent()) {
            throw new AwardNotFoundException(award.toString());
        }
        return new Response<>(award.get());
    }

}
