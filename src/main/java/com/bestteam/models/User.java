package com.bestteam.models;

import com.bestteam.models.Employment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.persistence.Column;

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

    @ManyToOne
    @JoinColumn(name="type")
    private UserType type;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Employment> employments = new ArrayList<>();


    public User() {}

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
        this.password = BCrypt.withDefaults().hashToString(10, password.toCharArray());
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
            ", type='" + getType() + "'" +
            "}";
    }
}
