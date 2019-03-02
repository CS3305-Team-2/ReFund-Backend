package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.bestteam.helpers.ActivityType;
import com.bestteam.helpers.TargetGeographicalArea;
import com.bestteam.helpers.ProjectTopic;

@Entity
@Table(name="EducationAndPublicEngagement")
public class EducationAndPublicEngagement {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="project_name")
    private String projectName;

    @NotNull
    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="activity_type")
    private ActivityType activityType;

    @Column(name="activity_type_other")
    private String activityTypeOther;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="project_topic")
    private ProjectTopic projectTopic;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="target_geographical_area")
    private TargetGeographicalArea targetGeographicalArea;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public String getActivityTypeOther() {
		return activityTypeOther;
	}

	public void setActivityTypeOther(String activityTypeOther) {
		this.activityTypeOther = activityTypeOther;
	}

	public ProjectTopic getProjectTopic() {
		return projectTopic;
	}

	public void setProjectTopic(ProjectTopic projectTopic) {
		this.projectTopic = projectTopic;
	}

	public TargetGeographicalArea getTargetGeographicalArea() {
		return targetGeographicalArea;
	}

	public void setTargetGeographicalArea(TargetGeographicalArea targetGeographicalArea) {
		this.targetGeographicalArea = targetGeographicalArea;
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
        " id='" + getId() + "'" +
        ", userId='" + getUserId() + "'" +
        ", projectName='" + getProjectName() + "'" +
        ", startDate='" + getStartDate() + "'" +
        ", endDate='" + getEndDate() + "'" +
        ", activityType='" + getActivityType() + "'" +
        ", activityTypeOther='" + getActivityTypeOther() + "'" +
        ", projectTopic='" + getProjectTopic() + "'" +
        ", targetGeographicalArea='" + getTargetGeographicalArea() + "'" +
        ", primaryAttribution='" + getPrimaryAttribution() + "'" +
        "}";
    }
}
