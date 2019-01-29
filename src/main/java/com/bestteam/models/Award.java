package com.bestteam.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;


@Entity
@Table(name="Award")
public class Award {
    @EmbeddedId
    private AwardIdentity awardIdentity;

    @NotNull
    private int year;

    @NotNull
    @Column(name="awarding_body")
    private String awardingBody;

    @NotNull
    private String details;

    public AwardIdentity getAwardIdentity() {
        return awardIdentity;
    }

    public void setAwardIdentity(AwardIdentity awardIdentity) {
        this.awardIdentity = awardIdentity;
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

    public Award() {
        super();
    }

    public Award(AwardIdentity awardIdentity, int year, String awardingBody, String details) {
        super();
        this.awardIdentity = awardIdentity;
        this.year = year;
        this.awardingBody = awardingBody;
        this.details = details;
    }

    @Override
	public String toString() {
        return "{" +
               ",awardIdentity='" + getAwardIdentity() + "'" +
               ",year='" + getYear() + "'" +
               ",awardingBody='" + getAwardingBody() + "'" +
               ",details='" + getDetails() + "'" +
               "}";
    }

}
