package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="AnnualReport")
public class AnnualReport {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

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

	public AnnualReport() {}

	public AnnualReport(Long id, Long userId, Long year,
                         String planDeviation, String threeHighlights,
                         String challenges, String plannedActivities) {
		this.id = id;
		this.userId = userId;
        this.year = year;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		this.plannedActivities = plannedActivities;
	}

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", userId='" + getUserId() + "'" +
        ", year='" + getYear() + "'" +
        ", planDeviation='" + getPlanDeviation() + "'" +
        ", threeHighlights='" + getThreeHighlights() + "'" +
        ", challenges='" + getChallenges() + "'" +
        ", plannedActivities='" + getPlannedActivities() + "'" +
        "}";
    }
}
