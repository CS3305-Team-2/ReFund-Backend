package com.bestteam.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.bestteam.exceptions.LoginException;
import com.bestteam.helpers.JWTKey;
import com.bestteam.helpers.MailHelper;
import com.bestteam.helpers.LoginUser;
import com.bestteam.helpers.Response;
import com.bestteam.models.User;
import com.bestteam.models.UserType;
import com.bestteam.repository.UserRepository;
import com.mashape.unirest.http.Unirest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;

@RequestMapping("/api/")
@RestController
public class SessionController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private Environment env;

    @PostMapping("/login")
    public Response<User> login(LoginUser loginUser, HttpServletResponse response) {
        Optional<User> user = repository.findByEmail(loginUser.getEmail());
        if(!user.isPresent()) {
            throw new LoginException("user with email not found");
        }

        if(!user.get().checkPassword(loginUser.getPassword())) {
            throw new LoginException("incorrect password");
        }

        response.addHeader("JWT-TOKEN", Jwts.builder()
            .claim("role", user.get().getType().toString())
            .claim("user", user.get().getId())
            .signWith(JWTKey.getKey()).compact());
        return new Response<User>(user.get());
    }

    @GetMapping("/redirect")
    public Response<User> redirectAuth(@RequestParam("code") String code, HttpServletResponse response) throws Exception {
        JSONObject json = Unirest.post("https://orcid.org/oauth/token")
            .header("Accept", "application/json")
            .field("client_id", env.getProperty("client_id"))
            .field("client_secret", env.getProperty("client_secret"))
            .field("grant_type", "authorization_code")
            .field("code", code)
            .field("redirect_uri", "http://refund.noahsc.xyz/")
            .asJson().getBody().getObject();

        String accessToken = json.get("access_token").toString();
        String orcid = json.get("orcid").toString();

        User newUser = null;
        HttpStatus status = HttpStatus.OK;

        if (!repository.existsByOrcid(orcid)) {
            json = Unirest.get("https://pub.orcid.org/v2.0/" + orcid + "/record")
                .header("Accept", "application/vnd.orcid+json")
                .header("Authorization", "Bearer " + accessToken)
                .asJson().getBody().getObject();

            newUser = new User();
            newUser.setOrcid(orcid);
            newUser.setType(new UserType("researcher"));
            newUser.setFirstName(json
                .getJSONObject("person")
                .getJSONObject("name")
                .getJSONObject("given-names")
                .getString("value"));

            newUser.setLastName(json
                .getJSONObject("person")
                .getJSONObject("name")
                .getJSONObject("family-name")
                .getString("value"));
            
            JSONArray emails = json
                .getJSONObject("person")
                .getJSONObject("emails")
                .getJSONArray("email");
            if (emails.length() > 0) {
                newUser.setEmail(emails
                    .getJSONObject(0)
                    .getString("email"));
            } else {
                newUser.setEmail("");
            }

            newUser.setPassword("new-user-password");
            newUser.setJobTitle("Not Specified");
            newUser.setTitle("Not Specified");
            newUser = repository.save(newUser);
            status = HttpStatus.CREATED;

            MailHelper.send(
                newUser.getEmail(), "Sesame Account Created", 
                "Dear " + newUser.getFirstName() + " " + newUser.getLastName() +
                "<br/>Welcome to your Sesame account.<br/><br/>Your account was automatically created when you signed up with your ORCID account " +
                "You will be able to login with your ORCID account by clicking the same button or withy our Sesame details. We highly recommend " +
                "that you change your password when you sign-in. It has been set to new-user-password by default." +
                "<br/>Kind Regards" +
                "<br/>SFI Administration");
        } else {
            newUser = repository.findByOrcid(orcid).get();
        }

        response.addHeader("JWT-TOKEN", Jwts.builder()
            .claim("role", newUser.getType().toString())
            .claim("user", newUser.getId())
            .signWith(JWTKey.getKey()).compact());
        return new Response<>(newUser, status);
    }
}