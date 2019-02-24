package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Proposal")
public class Proposal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="status")
    private String status;

    @NotNull
    @Column(name="file_location")
    private String fileLocation;

    @NotNull
    @Column(name="primary_attribution")
    private String primaryAttribution;

    @NotNull
    @Column(name="project_id")
    private String projectId;

	public Proposal() {}

	public Proposal(Long id, String status, String fileLocation, String primaryAttribution, String projectId) {
		this.id = id;
		this.status = status;
		this.fileLocation = fileLocation;
		this.primaryAttribution = primaryAttribution;
		this.projectId = projectId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getPrimaryAttribution() {
		return primaryAttribution;
	}

	public void setPrimaryAttribution(String primaryAttribution) {
		this.primaryAttribution = primaryAttribution;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", status='" + getStatus() + "'" +
            ", fileLocation='" + getFileLocation() + "'" +
            ", primaryAttribution='" + getPrimaryAttribution() + "'" +
            ", projectId='" + getProjectId() + "'" +
            "}";
    }
}
