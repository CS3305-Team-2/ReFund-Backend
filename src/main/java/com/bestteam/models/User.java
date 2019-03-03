package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import at.favre.lib.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(name="email")
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name="pass")
    private String password;

    @NotNull
    @Column(name="job_title")
    private String jobTitle;

    @NotNull
    @Column(name="title")
    private String title;

    @Column(name="suffix")
    private String suffix;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="phone_country_code")
    private String phoneCountryCode;

    @Column(name="orcid")
    private String orcid;

    /* @NotNull */
    @ManyToOne
    @JoinColumn(name="host_institution_id")
    private HostInstitution hostInstitution;

    @ManyToOne
    @JoinColumn(name="type")
    private UserType type;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Education> educations = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Employment> employments = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<SocietyMembership> societyMemberships = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Awards> awards = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="primary_beneficiary")
    private Set<Impact> impact = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Innovation> innovation = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Presentation> presentation = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<NonAcademicCollaborations> nonAcademicCollaborations = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<AcademicCollaborations> academicCollaborations = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Publication> publication = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Event> event = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<CommunicationOverview> communicationOverview = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<SfiFundingRatio> sfiFundingRatio = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<EducationAndPublicEngagement> educationAndPublicEngagement = new LinkedHashSet<>();

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<TeamMember> members = new LinkedHashSet<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void hashPassword() {
        this.password = BCrypt.withDefaults().hashToString(10, password.toCharArray());
    }

    public boolean checkPassword(String password) {
        return BCrypt.verifyer().verify(password.toCharArray(), this.password.toCharArray()).verified;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public HostInstitution getHostInstitution() {
        return hostInstitution;
    }

    public void setHostInstitution(HostInstitution hostInstitution) {
        this.hostInstitution = hostInstitution;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Education> getEducations() {
        return this.educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Employment> getEmployments() {
        return this.employments;
    }

    public void setEmployments(Set<Employment> employments) {
        this.employments  = employments;
    }

    public Set<SocietyMembership> getSocietyMemberships() {
        return this.societyMemberships;
    }

    public void setSocietyMemberships(Set<SocietyMembership> societyMemberships) {
        this.societyMemberships = societyMemberships;
    }

    public Set<Awards> getAwards() {
        return this.awards;
    }

    public void setAwards(Set<Awards> awards) {
        this.awards = awards;
    }

    public Set<Impact> getImpact() {
        return this.impact;
    }

    public void setImpact(Set<Impact> impact) {
        this.impact = impact;
    }

    public Set<Innovation> getInnovation() {
        return this.innovation;
    }

    public void setInnovation(Set<Innovation> innovation) {
        this.innovation = innovation;
    }

    public Set<Presentation> getPresentation() {
        return this.presentation;
    }

    public void setPresentation(Set<Presentation> presentation) {
        this.presentation = presentation;
    }

    public Set<Publication> getPublication() {
        return this.publication;
    }

    public void setPublication(Set<Publication> publication) {
        this.publication = publication;
    }


    public Set<NonAcademicCollaborations> getNonAcademicCollaborations() {
        return this.nonAcademicCollaborations;
    }

    public void setNonAcademicCollaborations(Set<NonAcademicCollaborations> nonAcademicCollaborations) {
        this.nonAcademicCollaborations = nonAcademicCollaborations;
    }

    public Set<AcademicCollaborations> getAcademicCollaborations() {
        return this.academicCollaborations;
    }

    public void setAcademicCollaborations(Set<AcademicCollaborations> academicCollaborations) {
        this.academicCollaborations = academicCollaborations;
    }

    public Set<TeamMember> getMembers() {
        return members;
    }

    public void setMembers(Set<TeamMember> members) {
        this.members = members;
    }

    public void setEvent(Set<Event> event) {
        this.event = event;
    }

    public Set<CommunicationOverview> getCommunicationOverview() {
        return communicationOverview;
    }

    public void setCommunicationOverview(Set<CommunicationOverview> communicationOverview) {
        this.communicationOverview = communicationOverview;
    }

    public Set<SfiFundingRatio> getSfiFundingRatio() {
        return sfiFundingRatio;
    }

    public void setSfiFundingRatio(Set<SfiFundingRatio> sfiFundingRatio) {
        this.sfiFundingRatio = sfiFundingRatio;
    }

    public Set<EducationAndPublicEngagement> getEducationAndPublicEngagement() {
        return educationAndPublicEngagement;
    }

    public void setEducationAndPublicEngagement(Set<EducationAndPublicEngagement> educationAndPublicEngagement) {
        this.educationAndPublicEngagement = educationAndPublicEngagement;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", jobTitle='" + getJobTitle() + "'" +
            ", title='" + getTitle() + "'" +
            ", suffix='" + getSuffix() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", phoneCountryCode='" + getPhoneCountryCode() + "'" +
            ", orcid='" + getOrcid() + "'" +
            ", hostInstitution='" + getHostInstitution() + "'" +
            ", type='" + getType() + "'" +
            ", educations='" + getEducations() + "'" +
            ", employments='" + getEmployments() + "'" +
            ", societyMemberships='" + getSocietyMemberships() + "'" +
            ", awards='" + getAwards() + "'" +
            ", impact='" + getImpact() + "'" +
            ", innovation='" + getInnovation() + "'" +
            ", presentation='" + getPresentation() + "'" +
            ", publication='" + getPublication() + "'" +
            ", academicCollaborations='" + getAcademicCollaborations() + "'" +
            ", nonAcademicCollaborations='" + getNonAcademicCollaborations() + "'" +
            ", members='" + getMembers() + "'" +
            "}";
    }
}
