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

import com.bestteam.helpers.CollaborationGoal;

@Entity
@Table(name="AcademicCollaborations")
public class AcademicCollaborations {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @NotNull
    @Column(name="institution_name")
    private String institutionName;

    @NotNull
    @Column(name="institution_department")
    private String institutionDepartment;

    @NotNull
    @Column(name="location")
    private String location;

    @NotNull
    @Column(name="name_of_collaborator")
    private String nameOfCollaborator;

    @NotNull
    @Column(name="goal_of_collaboration")
    @Enumerated(EnumType.STRING)
    private CollaborationGoal goalOfCollaboration;

    @NotNull
    @Column(name="interaction_frequency")
    private String interactionFrequency;

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

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getInstitutionDepartment() {
		return institutionDepartment;
	}

	public void setInstitutionDepartment(String institutionDepartment) {
		this.institutionDepartment = institutionDepartment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNameOfCollaborator() {
		return nameOfCollaborator;
	}

	public void setNameOfCollaborator(String nameOfCollaborator) {
		this.nameOfCollaborator = nameOfCollaborator;
	}

	public CollaborationGoal getGoalOfCollaboration() {
		return goalOfCollaboration;
	}

	public void setGoalOfCollaboration(CollaborationGoal goalOfCollaboration) {
		this.goalOfCollaboration = goalOfCollaboration;
	}

	public String getInteractionFrequency() {
		return interactionFrequency;
	}

	public void setInteractionFrequency(String interactionFrequency) {
		this.interactionFrequency = interactionFrequency;
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
        ", startDate='" + getStartDate() + "'" +
        ", endDate='" + getEndDate() + "'" +
        ", institutionName='" + getInstitutionName() + "'" +
        ", institutionDepartment='" + getInstitutionDepartment() + "'" +
        ", location='" + getLocation() + "'" +
        ", nameOfCollaborator='" + getNameOfCollaborator() + "'" +
        ", goalOfCollaboration='" + getGoalOfCollaboration() + "'" +
        ", interactionFrequency='" + getInteractionFrequency() + "'" +
        ", primaryAttribution='" + getPrimaryAttribution() + "'" +
        "}";
    }
}
