package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name="Education")
public class Education {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long educationId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    private String degree;

    @NotNull
    private String field;

    @NotNull
    private String institution;

    @NotNull
    private String location;

    @NotNull
    private int year;

    public Long getEducationId() {
		return educationId;
	}

	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
    }
    
    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "{" +
            " educationId='" + getEducationId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", degree='" + getDegree() + "'" +
            ", field='" + getField() + "'" +
            ", institution='" + getInstitution() + "'" +
            ", location='" + getLocation() + "'" +
            ", year='" + getYear() + "'" +
            "}";
    }
}