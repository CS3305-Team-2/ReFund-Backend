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

import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bestteam.exceptions.GrantNotFoundException;
import com.bestteam.models.Grants;
import com.bestteam.helpers.Response;
import com.bestteam.helpers.UploadFileResponse;
import com.bestteam.repository.GrantsRepository;

@RestController
@RequestMapping("/api/grants")
public class GrantsController {

    @Autowired
    private GrantsRepository repository;

    @Autowired
    private FileController fileController;

    @GetMapping
    public List<Grants> getGrantsCollection() {
        return (List<Grants>)repository.findAll();
    }

    @PostMapping
    public Response<Grants> createGrants(@ApiParam("A pdf file only please.") @RequestParam("file") @Valid @NotNull @NotBlank MultipartFile file, @ApiParam("A Grant object") @RequestPart("grant") @Valid Grants grant) {
        try {
            grant.setUrl(""); // setting to empty string because column is NOT NULL
            grant = repository.save(grant);
            UploadFileResponse resp = fileController.uploadFile(file, "grant_" + String.valueOf(grant.getId()) + ".pdf");
            grant.setUrl(resp.getFileName());
        } catch(Exception e) {
            repository.delete(grant);
            throw e;
        }
        return new Response<>(repository.save(grant));
    }

    @RequestMapping(value="/{grantId}/{status}", method={RequestMethod.POST, RequestMethod.PATCH})
    public void updateStatus(@PathVariable("grantId") Long grantId, @PathVariable("status") String status) {
        Optional<Grants> grant = repository.findById(grantId);
        if (!grant.isPresent()) {
            throw new GrantNotFoundException(grantId.toString());
        }

        grant.get().setStatus(status);
        repository.save(grant.get());
    }

    @GetMapping("/{grantId}")
    public Response<Grants> getGrants(@PathVariable("grantId") Long grantId) {
        Optional<Grants> grant = repository.findById(grantId);
        if (!grant.isPresent()) {
            throw new GrantNotFoundException(grantId.toString());
        }
        return new Response<>(grant.get());
    }
}
