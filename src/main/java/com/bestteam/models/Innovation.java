package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Innovation")
public class Innovation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long innovationId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="type")
    private String type;

    @NotNull
    @Column(name="year")
    private Long year;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

    public Long getInnovationId() {
        return innovationId;
    }

    public void setInnovationId(Long innovationId) {
        this.innovationId = innovationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
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
            " innovationId='" + getInnovationId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", title='" + getTitle() + "'" +
            ", type='" + getType() + "'" +
            ", year='" + getYear() + "'" +
            ", primaryAttribution='" + getPrimaryAttribution() + "'" +
            "}";
    }
}
