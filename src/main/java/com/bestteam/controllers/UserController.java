package com.bestteam.controllers;

import org.dmfs.httpessentials.client.HttpRequestExecutor;
import org.dmfs.httpessentials.httpurlconnection.HttpUrlConnectionExecutor;
import org.dmfs.oauth2.client.BasicOAuth2AuthorizationProvider;
import org.dmfs.oauth2.client.BasicOAuth2Client;
import org.dmfs.oauth2.client.BasicOAuth2ClientCredentials;
import org.dmfs.oauth2.client.OAuth2AccessToken;
import org.dmfs.oauth2.client.OAuth2AuthorizationProvider;
import org.dmfs.oauth2.client.OAuth2Client;
import org.dmfs.oauth2.client.OAuth2ClientCredentials;
import org.dmfs.oauth2.client.grants.ClientCredentialsGrant;
import org.dmfs.oauth2.client.grants.TokenRefreshGrant;
import org.dmfs.oauth2.client.scope.BasicScope;
import org.dmfs.rfc3986.encoding.Precoded;
import org.dmfs.rfc3986.uris.LazyUri;
import org.dmfs.rfc5545.DateTime;
import org.dmfs.rfc5545.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.bestteam.exceptions.BadSearchException;
import com.bestteam.exceptions.UserNotFoundException;
import com.bestteam.helpers.Response;
import com.bestteam.models.User;
import com.bestteam.models.Awards;
import com.bestteam.models.Employment;
import com.bestteam.models.Education;
import com.bestteam.models.SocietyMembership;
import com.bestteam.repository.UserRepository;
import com.google.common.collect.Sets;
import com.mashape.unirest.http.Unirest;
import com.bestteam.repository.SocietyMembershipRepository;
import com.bestteam.repository.EducationRepository;
import com.bestteam.repository.AwardsRepository;
import com.bestteam.repository.EmploymentRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private AwardsRepository awardsRepository;

    @Autowired
    private EmploymentRepository employmentRepository;

    @Autowired
    private SocietyMembershipRepository societyMembershipRepository;

    @Autowired
    private Environment env;

    private HttpRequestExecutor executor = null;
    private OAuth2AuthorizationProvider provider = null;
    private OAuth2ClientCredentials credentials = null;
    private OAuth2Client client = null;
    private OAuth2AccessToken token = null;

    private Set<String> searchTerms = Sets.newHashSet("given-names", "family-name", "other-names", "credit-name", "email");

    @GetMapping
    public List<User> getUserCollection() {
        return (List<User>)repository.findAll();
    }

    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        if(repository.existsByOrcid(user.getOrcid())) {
        }
        repository.save(user);
    }

    private void init() {
        executor = new HttpUrlConnectionExecutor();
        provider = new BasicOAuth2AuthorizationProvider(URI.create("https://pub.orcid.org/oauth/auth"), URI.create("https://pub.orcid.org/oauth/token"), new Duration(1, 0, 631138518));
        credentials = new BasicOAuth2ClientCredentials(env.getProperty("client_id"), env.getProperty("client_secret"));
        client = new BasicOAuth2Client(provider, credentials, new LazyUri(new Precoded("http://localhost")));
    }

    @GetMapping("/search")
    public Response<String> getOrcid(@RequestParam("field") String field, @RequestParam("value") String value) throws Exception {
        if(!searchTerms.contains(field)) {
            throw new BadSearchException(field + " not valid search term");
        }

        if(executor == null) init();

        if(token == null) {
            token = new ClientCredentialsGrant(client, new BasicScope("/read-public")).accessToken(executor);
        } else if(token.expirationDate().before(DateTime.now())) {
            token = new TokenRefreshGrant(client, token).accessToken(executor);
        }
        
        return new Response<String>(Unirest.get("https://pub.orcid.org/v2.1/search?q=" + field + ":" + value)
            .header("Authorization", "Bearer " + token.accessToken())
            .header("Accept", "application/json")
            .queryString("q", "family-name:Santschi")
            .asJson().getBody().getObject().toString());
    }

    @GetMapping("/{userId}")
    public Response<User> getUser(@PathVariable("userId") Long userId) {
        Optional<User> user = repository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId.toString());
        }
        return new Response<>(user.get());
    }

    @GetMapping("/{userId}/educations")
    public Response<List<Education>> getUserEducations(@PathVariable("userId") Long userId) {
        return new Response<>(educationRepository.findByEducationIdentityUserId(userId));
    }

    @GetMapping("/{userId}/awards")
    public Response<List<Awards>> getUserAwards(@PathVariable("userId") Long userId) {
        return new Response<>(awardsRepository.findByAwardsIdentityUserId(userId));
    }

    @GetMapping("/{userId}/employments")
    public Response<List<Employment>> getUserEmployments(@PathVariable("userId") Long userId) {
        return new Response<>(employmentRepository.findByEmploymentIdentityUserId(userId));
    }
    @GetMapping("/{userId}/societymemberships")
    public Response<List<SocietyMembership>> getUserSocietyMemberships(@PathVariable("userId") Long userId) {
        return new Response<>(societyMembershipRepository.findBySocietyMembershipIdentityUserId(userId));
    }
}
