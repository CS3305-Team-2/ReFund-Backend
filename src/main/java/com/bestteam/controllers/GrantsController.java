package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public Response<Grants> createGrants(@RequestParam("file") @Valid @NotNull @NotBlank MultipartFile file, @RequestPart("grant") @Valid Grants grant) {
        try {
            grant.setUrl(""); // setting to empty string because column is NOT NULL
            grant = repository.save(grant);
            UploadFileResponse resp = fileController.uploadFile(file, "grant_" + String.valueOf(grant.getId()) + ".pdf");
            grant.setUrl(resp.getFileName());
        } catch(Exception e) {
            repository.delete(grant);
        }
        return new Response<>(repository.save(grant));
        //return new Response<>(data);
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
