package com.bestteam.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.bestteam.exceptions.NoJWTFound;
import com.bestteam.exceptions.ProjectNotFoundException;
import com.bestteam.helpers.JWTKey;
import com.bestteam.helpers.MailHelper;
import com.bestteam.helpers.Response;
import com.bestteam.models.Project;
import com.bestteam.models.TeamMember;
import com.bestteam.models.User;
import com.bestteam.repository.ProjectRepository;
import com.bestteam.repository.TeamMemberRepository;
import com.google.common.collect.Sets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectRepository repository;

    @Autowired
    private TeamMemberRepository teamMemberRepo;

    @GetMapping
    @ApiOperation(value="/api/project", notes="Returns the list of projects where user is the Principal Instigator", authorizations={
        @Authorization(value="user ID from JWT token")
    })
    public Response<List<Project>> getProjects(HttpServletRequest request) {
        String token = request.getHeader("JWT-TOKEN");
        if(token == null) {
            throw new NoJWTFound();
        }
        Integer userId = (Integer)JWTKey.getClaim(token, "user");
        return new Response<>(repository.findAllProjectsForPI(Long.valueOf(userId)));
    }

    @GetMapping("/associatedTo/{userId}")
    public Response<List<Project>> getAssociatedProjects(@PathVariable("userId") Long userId) {
        return new Response<>(repository.findAllAssociatedProjects(userId));
    }

    @RequestMapping(value="/addTeamMember", method={RequestMethod.POST, RequestMethod.PATCH})
    public Response<Project> addTeamMember(@Valid @RequestBody TeamMember teamMember) throws IOException {
        Optional<Project> project = repository.findById(teamMember.getProjectId());
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(teamMember.getProjectId());
        }
        teamMemberRepo.save(teamMember);
        project.get().getTeamMembers().add(teamMember);

        User user = teamMemberRepo.getUserFromTeamMemberId(repository.getPITeamMemberIdFromProjectId(project.get().getId()));

        MailHelper.send(
            user.getEmail(), "Team Member added to Project", 
            "A user has been added as a team member to your project");

        return new Response<>(project.get());
    }

    @RequestMapping(value="/{projectId}/status/{status}", method={RequestMethod.POST, RequestMethod.PATCH})
    public void setProjectStatus(@PathVariable("projectId") Long projectId, @PathVariable("status") String status) {
        Optional<Project> project = repository.findById(projectId);
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(projectId);
        }
        project.get().setStatus(status);
        repository.save(project.get());
    }

    @RequestMapping(value="/{projectId}/markAsRc", method={RequestMethod.POST, RequestMethod.PATCH})
    public void markAsResearchCenter(@PathVariable("projectId") Long projectId) {
        Optional<Project> project = repository.findById(projectId);
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(projectId);
        }
        project.get().setIsResearchCenter(true);
        repository.save(project.get());
    }

    @RequestMapping(value="/{projectId}/markAsNotRc", method={RequestMethod.POST, RequestMethod.PATCH})
    public void markAsNotResearchCenter(@PathVariable("projectId") Long projectId) {
        Optional<Project> project = repository.findById(projectId);
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(projectId);
        }
        project.get().setIsResearchCenter(false);
        repository.save(project.get());
    }

    @PostMapping
    public Response<Project> createProject(HttpServletRequest request, @Valid @RequestBody Project project) {
        project.setIsResearchCenter(false);
        
        Set<TeamMember> teamMembers = project.getTeamMembers();
        project.setTeamMembers(null);
        Project newProject = repository.save(project);
        for(TeamMember teamMember: teamMembers) {
            User user = teamMemberRepo.getUserFromTeamMemberId(teamMember.getUserId());
            teamMember.setName(user.getFirstName() + " " + user.getLastName());
            teamMember.setProjectId(newProject.getId());
        }
        Iterable<TeamMember> newTeamMembers = teamMemberRepo.saveAll(() -> teamMembers.iterator());
        project.setTeamMembers(Sets.newHashSet(newTeamMembers));
        return new Response<>(newProject);
    }

    @GetMapping("/{projectId}")
    public Response<Project> getProject(@PathVariable("projectId") Long projectId) {
        Optional<Project> project = repository.findById(projectId);
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(projectId);
        }
        return new Response<>(project.get());
    }
}
