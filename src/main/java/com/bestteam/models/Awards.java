package com.bestteam.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Awards")
public class Awards {
    @EmbeddedId
    private AwardsIdentity awardsIdentity;

    @NotNull
    private int year;

    @NotNull
    @Column(name="awarding_body")
    private String awardingBody;

    @NotNull
    private String details;

    public Awards() {}

    public Awards(AwardsIdentity awardsIdentity, int year, String awardingBody, String details) {
        this.awardsIdentity = awardsIdentity;
        this.year = year;
        this.awardingBody = awardingBody;
        this.details = details;
    }

    public AwardsIdentity getAwardsIdentity() {
        return awardsIdentity;
    }

    public void setAwardsIdentity(AwardsIdentity awardsIdentity) {
        this.awardsIdentity = awardsIdentity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAwardingBody() {
        return awardingBody;
    }

    public void setAwardingBody(String awardingBody) {
        this.awardingBody = awardingBody;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
	public String toString() {
        return "{" +
               ",awardsIdentity='" + getAwardsIdentity() + "'" +
               ",year='" + getYear() + "'" +
               ",awardingBody='" + getAwardingBody() + "'" +
               ",details='" + getDetails() + "'" +
               "}";
    }

}
