package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinTable;

@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="pass")
    private String password;

    @Column(name="job_title")
    private String jobTitle;

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

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(name="uesr_to_type",)
    private UserType type;



    public User() {}
}