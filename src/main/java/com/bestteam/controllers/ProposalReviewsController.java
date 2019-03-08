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

import com.bestteam.exceptions.ProposalReviewsNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.ProposalReviews;
import com.bestteam.repository.ProposalReviewsRepository;

@RestController
@RequestMapping("/api/proposalReviews")
public class ProposalReviewsController {

    @Autowired
    private ProposalReviewsRepository repository;

    @GetMapping
    public List<ProposalReviews> getProposalReviewsCollection() {
        return (List<ProposalReviews>)repository.findAll();
    }

    @PostMapping
    public void createProposalReviews(@Valid @RequestBody ProposalReviews proposalReviews) {
        repository.save(proposalReviews);
    }

    @GetMapping("/{proposalReviewsId}")
    public Response<ProposalReviews> getProposalReviews(@PathVariable("proposalReviewsId") Long proposalReviewsId) {
        Optional<ProposalReviews> proposalReviews = repository.findById(proposalReviewsId);
        if (!proposalReviews.isPresent()) {
            throw new ProposalReviewsNotFoundException(proposalReviewsId.toString());
        }
        return new Response<>(proposalReviews.get());
    }
}
