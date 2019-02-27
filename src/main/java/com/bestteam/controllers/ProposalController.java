package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bestteam.exceptions.ProposalNotFoundException;
import com.bestteam.exceptions.ProposalNotDraftException;
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
    public Response<List<Proposal>> getProposals(@RequestParam(value="status", required=false) ProposalStatus status) {
        if (status != null) {
            return new Response<>(repository.findByStatus(status));
        }
        //TODO filter
        List<Proposal> proposals = new ArrayList<>();
        repository.findAll().forEach(proposals::add);
        return new Response<>(proposals);
    }

    @PostMapping("/update")
    public Response<Proposal> updateProposalDraft(
    @RequestParam(name="file", required=false) @Valid @NotNull @NotBlank MultipartFile file,
    @RequestPart("proposal") @Valid Proposal proposal) {
        // sample update
        // curl -X POST -v -F 'file=@build.gradle' -F 'proposal=
        // {"id": 8,
        // "status": "DRAFT",
        // "primaryAttribution": "1",
        // "projectId": 1,
        // "title": "this this this this this thsi tshi",
        // "duration": 123234,
        // "nrpArea": "OTHER",
        // "legalRemitAlignment": "what",
        // "ethicalIssues": "none",
        // "applicantLocationStatement": "somewhere",
        // "coApplicantsList": "lolno",
        // "collaboratorsList": "none",
        // "scientificAbstract": "does stuff",
        // "layAbstract": "LAY ABSTRACT",
        // "declaration": true};type=application/json' http://localhost:8080/api/proposal/update | python -mjson.tool
        Optional<Proposal> prop = repository.findById(proposal.getId());
        if (!prop.isPresent()) {
            throw new ProposalNotFoundException(proposal.getId().toString());
        }
        if (prop.get().getStatus() != ProposalStatus.DRAFT) {
            throw new ProposalNotDraftException(proposal.getId().toString());
        }
        try {
            if (file == null) {
                proposal.setFileLocation(prop.get().getFileLocation());
            } else {
                proposal.setFileLocation(""); // setting to empty string because column is NOT NULL
                proposal = repository.save(proposal);
                UploadFileResponse resp = fileController.uploadFile(file, "proposal_" + String.valueOf(proposal.getId()) + ".pdf");
                proposal.setFileLocation(resp.getFileName());
            }
            proposal = repository.save(proposal);
        } catch(Exception e) {
            throw e;
        }
        return new Response<>(repository.save(proposal));
    }


    @PostMapping
    public Response<Proposal> createProposal(
    @RequestParam(name="file", required=false) @Valid @NotNull @NotBlank MultipartFile file,
    @RequestPart("proposal") @Valid Proposal proposal) {
        try {
            if (file == null) {
                file=new MockMultipartFile("tempFileOnServerBroooooo","temp".getBytes());
            }
            proposal.setFileLocation(""); // setting to empty string because column is NOT NULL
            proposal = repository.save(proposal);
            UploadFileResponse resp;
            if (file.getName().equals("tempFileOnServerBroooooo")) {
                resp = fileController.uploadFile(file, "temp_proposal_" + String.valueOf(proposal.getId()) + ".pdf");
            } else {
                resp = fileController.uploadFile(file, "proposal_" + String.valueOf(proposal.getId()) + ".pdf");
            }
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
            throw new ProposalNotFoundException(proposalId.toString());
        }
        return new Response<>(proposal.get());
    }

    @DeleteMapping("/{proposalId}/delete")
    public Response<String> deleteProposal(@PathVariable("proposalId") Long proposalId) {
        Optional<Proposal> proposal = repository.findById(proposalId);
        if (!proposal.isPresent()) {
            throw new ProposalNotFoundException(proposalId.toString());
        }
        repository.deleteById(proposalId);
        return new Response<>("Proposal ID: " + proposalId.toString() + " deleted");
    }
}
