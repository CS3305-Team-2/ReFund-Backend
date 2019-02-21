package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;

import javax.validation.constraints.NotNull;

import com.bestteam.models.InnovationIdentity;

@Entity
@Table(name="Innovation")
public class Innovation {

    @EmbeddedId
    private InnovationIdentity innovationIdentity;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="type")
    private String type;

    @NotNull
    @Column(name="year")
    private Long year;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

    public Innovation() {}

    public Innovation(InnovationIdentity innovationIdentity, String title, String type, Long year, Long primaryAttribution) {
        this.innovationIdentity = innovationIdentity;
        this.title = title;
        this.type = type;
        this.year = year;
        this.primaryAttribution = primaryAttribution;
    }

    public InnovationIdentity getInnovationIdentity() {
        return innovationIdentity;
    }

    public void setInnovationIdentity(InnovationIdentity innovationIdentity) {
        this.innovationIdentity = innovationIdentity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getPrimaryAttribution() {
        return primaryAttribution;
    }

    public void setPrimaryAttribution(Long primaryAttribution) {
        this.primaryAttribution = primaryAttribution;
    }

    @Override
    public String toString() {
        return "{" +
        " innovationIdentity='" + getInnovationIdentity() + "'" +
        ", title='" + getTitle() + "'" +
        ", type='" + getType() + "'" +
        ", year='" + getYear() + "'" +
        ", primary_attribution='" + getPrimaryAttribution() + "'" +
        "}";
    }
}
