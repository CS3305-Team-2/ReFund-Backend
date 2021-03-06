package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

import com.bestteam.exceptions.WordCountOverLimitException;

@Entity
@Table(name="AnnualReport")
public class AnnualReport {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="project_id")
    private Long projectId;

    @NotNull
    @Column(name="year")
    private Long year;

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

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
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
        if (plannedActivities.split("\\s+").length>200){
            throw new WordCountOverLimitException("Planned Activities", id.toString());
        }
        this.plannedActivities = plannedActivities;
	}

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", projectId='" + getProjectId() + "'" +
        ", year='" + getYear() + "'" +
        ", planDeviation='" + getPlanDeviation() + "'" +
        ", threeHighlights='" + getThreeHighlights() + "'" +
        ", challenges='" + getChallenges() + "'" +
        ", plannedActivities='" + getPlannedActivities() + "'" +
        "}";
    }
}
