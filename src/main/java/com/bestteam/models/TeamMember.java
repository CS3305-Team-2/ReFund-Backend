package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TeamMember")
public class TeamMember {
    @EmbeddedId
    private TeamMemberIdentity identity;

    @NotNull
    @Column(name="start_date")  
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @NotNull
    @Column(name="end_date")  
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @NotNull
    @Column(name="role")
    private String role;

    public TeamMember() {}

    public TeamMember(TeamMemberIdentity identity, Date startDate, Date endDate, String role) {
        this.identity = identity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.role = role;
    }

    public TeamMemberIdentity getIdentity() {
        return this.identity;
    }

    public void setIdentity(TeamMemberIdentity identity) {
        this.identity = identity;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "{" +
            " identity='" + getIdentity() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}