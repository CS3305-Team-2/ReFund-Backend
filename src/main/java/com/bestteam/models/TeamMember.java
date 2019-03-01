package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLInsert;

@Entity
@Table(name="TeamMember")
/* @SQLInsert(sql="INSERT INTO TeamMember (user_id, start_date, end_date, role, project_id) values (?, ?, ?, ?, ?)") */
public class TeamMember {
    /* @EmbeddedId
    private TeamMemberIdentity teamMemberIdentity; */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

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

    public TeamMember(/* TeamMemberIdentity identity,  */Date startDate, Date endDate, String role) {
        /* this.teamMemberIdentity = identity; */
        this.startDate = startDate;
        this.endDate = endDate;
        this.role = role;
    }

    /* public TeamMemberIdentity getTeamMemberIdentity() {
        return teamMemberIdentity;
    }

    public void setTeamMemberIdentity(TeamMemberIdentity teamMemberIdentity) {
        this.teamMemberIdentity = teamMemberIdentity;
    } */

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
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