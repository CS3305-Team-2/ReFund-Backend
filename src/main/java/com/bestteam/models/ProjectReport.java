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
    @Column(name="file_url")
    private String fileUrl;

    public ProjectReport() {}

    public ProjectReport(Long id, Long projectId, String fileUrl) {
        this.id = id;
        this.projectId = projectId;
        this.fileUrl = fileUrl;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", projectId='" + getProjectId() + "'" +
            ", fileUrl='" + getFileUrl() + "'" +
            "}";
    }
}
