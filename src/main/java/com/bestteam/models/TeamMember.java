package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TeamMember")
public class TeamMember {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="start_date")  
    private Date startDate;

    @Column(name="end_date")  
    private Date endDate;

    @NotNull
    @Column(name="role")
    private String role;

    @Column(name="project_id")
    private Long projectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
            //" teamMemberIdentity='" + getTeamMemberIdentity() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", role='" + getRole() + "'" +
            ", projectId='" + getProjectId() + "'" +
            "}";
    }    
}