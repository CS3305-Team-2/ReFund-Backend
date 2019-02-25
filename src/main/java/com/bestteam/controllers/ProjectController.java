package com.bestteam.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.bestteam.exceptions.ProjectNotFoundException;
import com.bestteam.helpers.JWTKey;
import com.bestteam.helpers.Response;
import com.bestteam.models.Project;
import com.bestteam.models.TeamMember;
import com.bestteam.repository.ProjectRepository;
import com.bestteam.repository.TeamMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
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
        Cookie[] cookies = request.getCookies();
        Integer userId = (Integer)Jwts.parser().setSigningKey(JWTKey.getKey()).parseClaimsJws(cookies[0].getValue()).getBody().get("user");
        return new Response<>(repository.getProjectByPi(Long.valueOf(userId)));
    }

    @GetMapping("/associatedTo/{userId}")
    public Response<List<Project>> getAssociatedProjects(@PathVariable("userId") Long userId) {
        return new Response<>(repository.findAllAssociatedProjects(userId));
    }

    @PatchMapping("/addTeamMember")
    public Response<Project> addTeamMember(@Valid @RequestBody TeamMember teamMember) {
        Optional<Project> project = repository.findById(teamMember.getProjectId());
        if (!project.isPresent()) {
            throw new ProjectNotFoundException(teamMember.getProjectId());
        }
        teamMemberRepo.save(teamMember);
        project.get().getTeamMembers().add(teamMember);
        return new Response<>(project.get());
    }

    @PostMapping
    public Response<Project> createProject(@Valid @RequestBody Project project) {
        return new Response<>(repository.save(project));
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
