package com.bestteam.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.bestteam.helpers.JWTKey;
import com.bestteam.helpers.Response;
import com.bestteam.models.Project;
import com.bestteam.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    @ApiOperation(value="/api/project", notes="Returns the list of projects where user is the Principal Instigator", authorizations={
        @Authorization(value="user ID from JWT token")
    })
    public Response<List<Project>> getProjects(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        
        Integer userId = (Integer)Jwts.parser().setSigningKey(JWTKey.getKey()).parseClaimsJws(cookies[0].getValue()).getBody().get("user");
        return new Response<>(repository.getProjectByPi(Long.valueOf(userId)));
    }

    @PostMapping
    public Response<Project> createProject(@Valid @RequestBody Project project) {
        return new Response<>(repository.save(project));
    }

    @GetMapping("/{projectId}")
    public Response<Project> getProject(@PathVariable("projectId") Long projectId) {
        return new Response<>(repository.findById(projectId).get());
    }
}
