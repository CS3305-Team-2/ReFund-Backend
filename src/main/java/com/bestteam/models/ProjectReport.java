package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ProjectReport")
public class ProjectReport {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="project_id")
    private Long projectId;

    @NotNull
    @Column(name="plan_deviation")
    private String planDeviation;

    @NotNull
    @Column(name="three_highlights")
    private String threeHighlights;

    @NotNull
    @Column(name="challenges")
    private String challenges;

    @NotNull
    @Column(name="planned_activities")
    private String plannedActivities;

	public ProjectReport() {}

	public ProjectReport(Long id, Long projectId, String planDeviation,
                         String threeHighlights, String challenges,
                         String plannedActivities) {
		this.id = id;
		this.projectId = projectId;
		this.planDeviation = planDeviation;
		this.threeHighlights = threeHighlights;
		this.challenges = challenges;
		this.plannedActivities = plannedActivities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getPlanDeviation() {
		return planDeviation;
	}

	public void setPlanDeviation(String planDeviation) {
		this.planDeviation = planDeviation;
	}

	public String getThreeHighlights() {
		return threeHighlights;
	}

	public void setThreeHighlights(String threeHighlights) {
		this.threeHighlights = threeHighlights;
	}

	public String getChallenges() {
		return challenges;
	}

	public void setChallenges(String challenges) {
		this.challenges = challenges;
	}

	public String getPlannedActivities() {
		return plannedActivities;
	}

	public void setPlannedActivities(String plannedActivities) {
		this.plannedActivities = plannedActivities;
	}

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", projectId='" + getProjectId() + "'" +
        ", planDeviation='" + getPlanDeviation() + "'" +
        ", threeHighlights='" + getThreeHighlights() + "'" +
        ", challenges='" + getChallenges() + "'" +
        ", plannedActivities='" + getPlannedActivities() + "'" +
        "}";
    }
}
