package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import com.bestteam.exceptions.ProposalNotFoundException;
import com.bestteam.exceptions.ProposalWithoutFileException;
import com.bestteam.exceptions.ProjectNotFoundException;
import com.bestteam.exceptions.ProposalNotDraftException;
import com.bestteam.models.Project;
import com.bestteam.models.Proposal;
import com.bestteam.models.User;
import com.bestteam.helpers.Response;
import com.bestteam.helpers.UploadFileResponse;
import com.bestteam.helpers.MailHelper;
import com.bestteam.helpers.ProposalStatus;
import com.bestteam.repository.ProjectRepository;
import com.bestteam.repository.ProposalRepository;
import com.bestteam.repository.TeamMemberRepository;

@RestController
@RequestMapping("/api/proposal")
public class ProposalController {

    @Autowired
    private ProposalRepository repository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private FileController fileController;

    @GetMapping
    public Response<List<Proposal>> getProposals(@RequestParam(value="status") ProposalStatus status) {
        return new Response<>(repository.findByStatus(status));
    }

    @RequestMapping(value="/update", method={RequestMethod.POST, RequestMethod.PATCH})
    public Response<Proposal> updateProposalDraft(@RequestParam(name="file", required=false) @Valid MultipartFile file, @RequestPart("proposal") @Valid Proposal proposal) {
        Optional<Proposal> oldProposal = repository.findById(proposal.getId());
        if (!oldProposal.isPresent()) {
            throw new ProposalNotFoundException(proposal.getId());
        }
        if (oldProposal.get().getStatus() != ProposalStatus.DRAFT) {
            throw new ProposalNotDraftException(proposal.getId());
        }
        try {
            System.out.println(file == null);
            if (file == null) {
                proposal.setFileLocation(oldProposal.get().getFileLocation());
            } else {
                System.out.println("replacing file");
                UploadFileResponse resp = fileController.uploadFile(file, "proposal_" + proposal.getId() + ".pdf");
                proposal = repository.save(proposal);
                proposal.setFileLocation(resp.getFileName());
            }
            proposal = repository.save(proposal);
        } catch(Exception e) {
            throw e;
        }
        return new Response<>(repository.save(proposal));
    }

    @PatchMapping("/{proposalId}/submit")
    public void submitProposal(@PathVariable("proposalId") Long proposalId) {
        Optional<Proposal> proposal = repository.findById(proposalId);
        if (!proposal.isPresent()) {
            throw new ProposalNotFoundException(proposalId);
        }

        proposal.get().setStatus(ProposalStatus.RO_SUBMITTED);
        repository.save(proposal.get());
    }

    @RequestMapping(value="/{proposalId}/reject", method={RequestMethod.POST, RequestMethod.PATCH})
    @ApiOperation(
        value="/api/proposal/{proposalId}/reject", 
        notes="If proposal state = RO_SUBMITTED, state becomes DRAFT. If proposal state = RO_APPROVED, state becomes REJECTED")
    public void rejectProposal(@PathVariable("proposalId") Long proposalId) throws IOException {
        Optional<Proposal> proposal = repository.findById(proposalId);
        if (!proposal.isPresent()) {
            throw new ProposalNotFoundException(proposalId);
        }

        if (proposal.get().getStatus() == ProposalStatus.RO_SUBMITTED) {
            proposal.get().setStatus(ProposalStatus.DRAFT);
        } else if (proposal.get().getStatus() == ProposalStatus.RO_APPROVED) {
            proposal.get().setStatus(ProposalStatus.REJECTED);
            Optional<Project> project = projectRepository.findById(proposal.get().getProjectId());
            if (!project.isPresent()) {
                throw new ProjectNotFoundException(proposal.get().getProjectId());
            }

            project.get().setProposal(null);
            projectRepository.save(project.get());
        }
        
        /* Optional<Project> project = projectRepository.findById(proposal.get().getProjectId());
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(proposal.get().getProjectId());
        }

        User user = teamMemberRepository.getUserFromTeamMemberId(projectRepository.getPITeamMemberIdFromProjectId(project.get().getId())); */

        repository.save(proposal.get());

        /* String proposalStateMessage = "";
        if(proposal.get().getStatus() == ProposalStatus.DRAFT) {
            proposalStateMessage = "by your Host Institution. It has been returned to your dashboard as a draft where you may make edits to it.";
        } else {
            proposalStateMessage = "by the SFI.";
        }

        MailHelper.send(
            user.getEmail(), "Proposal Approved", 
            "We regret to inform you that your project proposal '" + proposal.get().getTitle() + "' was rejected " + proposalStateMessage); */
    }

    @RequestMapping(value="/{proposalId}/approve", method={RequestMethod.POST, RequestMethod.PATCH})
    @ApiOperation(
        value="/api/proposal/{proposalId}/approve", 
        notes="If proposal state = RO_SUBMITTED, state becomes RO_APPROVED. If proposal state = RO_APPROVED, state becomes SFI_APPROVED")
    public void approveProposal(@PathVariable("proposalId") Long proposalId) throws IOException {
        Optional<Proposal> proposal = repository.findById(proposalId);
        if (!proposal.isPresent()) {
            throw new ProposalNotFoundException(proposalId);
        }

        if (proposal.get().getStatus() == ProposalStatus.RO_SUBMITTED) {
            proposal.get().setStatus(ProposalStatus.RO_APPROVED);
        } else if (proposal.get().getStatus() == ProposalStatus.RO_APPROVED) {
            proposal.get().setStatus(ProposalStatus.SFI_APPROVED);
        }

        Optional<Project> project = projectRepository.findById(proposal.get().getProjectId());
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(proposal.get().getProjectId());
        }

        /* Long piId = projectRepository.getPITeamMemberIdFromProjectId(project.get().getId());
        System.out.println("Proposal ID: " + proposalId);
        System.out.println("Project ID: " + project.get().getId());
        System.out.println("PI ID: " + piId);
        User user = teamMemberRepository.getUserFromTeamMemberId(piId); */

        repository.save(proposal.get());

        /* MailHelper.send(
            user.getEmail(), "Proposal Approved", 
            "We are delighted to inform you that your project proposal '" + proposal.get().getTitle() + "' was approved."); */
    }

    @PostMapping
    public Response<Proposal> createProposal(@RequestParam(name="file", required=false) @Valid MultipartFile file, @RequestPart("proposal") @Valid Proposal proposal) {
        Optional<Project> project = Optional.empty();
        try {
            if (file == null && proposal.getStatus() != ProposalStatus.DRAFT) {
                throw new ProposalWithoutFileException();
            }
            
            proposal = repository.save(proposal);
            
            if (file != null) {
                UploadFileResponse resp = fileController.uploadFile(file, "proposal_" + proposal.getId() + ".pdf");
                proposal.setFileLocation(resp.getFileName());
            }

            proposal = repository.save(proposal);

            project = projectRepository.findById(proposal.getProjectId());
            if (!project.isPresent()) {
                throw new ProjectNotFoundException(proposal.getProjectId());
            }
            project.get().setProposal(proposal);
            projectRepository.save(project.get());
        } catch(Exception e) {
            repository.delete(proposal);
            if (project.isPresent()) project.get().setProposal(null);
            throw e;
        }
        return new Response<>(proposal);
    }

    @GetMapping("/{proposalId}")
    public Response<Proposal> getProposal(@PathVariable("proposalId") Long proposalId) {
        Optional<Proposal> proposal = repository.findById(proposalId);
        if (!proposal.isPresent()) {
            throw new ProposalNotFoundException(proposalId);
        }
        return new Response<>(proposal.get());
    }

    @RequestMapping(value="/{proposalId}/delete", method={RequestMethod.POST, RequestMethod.DELETE})
    public Response<String> deleteProposal(@PathVariable("proposalId") Long proposalId) throws IOException {
        Optional<Proposal> proposal = repository.findById(proposalId);
        if (!proposal.isPresent()) {
            throw new ProposalNotFoundException(proposalId);
        }
        repository.deleteById(proposalId);

        Optional<Project> project = projectRepository.findById(proposal.get().getProjectId());
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(proposal.get().getProjectId());
        }

        project.get().setProposal(null);
        projectRepository.save(project.get());
        /*User user = teamMemberRepository.getUserFromTeamMemberId(projectRepository.getPITeamMemberIdFromProjectId(project.get().getId()));

        MailHelper.send(
            user.getEmail(), "Proposal Rejection", 
            "We regret to inform you that your project proposal '" + proposal.get().getTitle() + "' was deleted"); */

        fileController.deleteFile(proposal.get().getFileLocation());

        return new Response<>("Proposal ID: " + proposalId.toString() + " deleted");
    }
}
