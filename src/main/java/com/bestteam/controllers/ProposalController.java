package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bestteam.exceptions.GrantNotFoundException;
import com.bestteam.models.Proposal;
import com.bestteam.helpers.Response;
import com.bestteam.helpers.UploadFileResponse;
import com.bestteam.helpers.ProposalStatus;
import com.bestteam.repository.ProposalRepository;

@RestController
@RequestMapping("/api/proposal")
public class ProposalController {

    @Autowired
    private ProposalRepository repository;

    @Autowired
    private FileController fileController;

    @GetMapping
    public Response<List<Proposal>> getProposals(@RequestParam(value="status") ProposalStatus status) {
        if (status != null) {
            return new Response<>(repository.findByStatus(status));
        }
        //TODO filter
        List<Proposal> proposals = new ArrayList<>();
        repository.findAll().forEach(proposals::add);
        return new Response<>(proposals);
    }

    @PostMapping
    public Response<Proposal> createProposal(
    @RequestParam("file") @Valid @NotNull @NotBlank MultipartFile file,
    @RequestPart("proposal") @Valid Proposal proposal) {
        try {
            proposal.setFileLocation(""); // setting to empty string because column is NOT NULL
            proposal = repository.save(proposal);
            UploadFileResponse resp = fileController.uploadFile(file, "proposal_" + String.valueOf(proposal.getId()) + ".pdf");
            proposal.setFileLocation(resp.getFileName());
        } catch(Exception e) {
            repository.delete(proposal);
            throw e;
        }
        return new Response<>(repository.save(proposal));
    }

    @GetMapping("/{proposalId}")
    public Response<Proposal> getProposal(@PathVariable("proposalId") Long proposalId) {
        Optional<Proposal> proposal = repository.findById(proposalId);
        if (!proposal.isPresent()) {
            throw new GrantNotFoundException(proposalId.toString());
        }
        return new Response<>(proposal.get());
    }
}
