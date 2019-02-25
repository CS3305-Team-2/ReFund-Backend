package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TeamMember")
public class TeamMember {
    @EmbeddedId
    private TeamMemberIdentity teamMemberIdentity;

    @NotNull
    @Column(name="start_date")  
    private Date startDate;

    @NotNull
    @Column(name="end_date")  
    private Date endDate;

    @NotNull
    @Column(name="role")
    private String role;

    @Column(name="project_id")
    private Long projectId;

    public TeamMember() {}

    public TeamMember(TeamMemberIdentity identity, Date startDate, Date endDate, String role) {
        this.teamMemberIdentity = identity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.role = role;
    }

    public TeamMemberIdentity getTeamMemberIdentity() {
        return teamMemberIdentity;
    }

    public void setTeamMemberIdentity(TeamMemberIdentity teamMemberIdentity) {
        this.teamMemberIdentity = teamMemberIdentity;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "{" +
            " teamMemberIdentity='" + getTeamMemberIdentity() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", role='" + getRole() + "'" +
            ", projectId='" + getProjectId() + "'" +
            "}";
    }    
}