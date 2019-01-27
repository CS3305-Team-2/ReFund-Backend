package com.bestteam.models;

import com.bestteam.models.EducationEmbeddedKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Education")
public class Education {
    @EmbeddedId
    private EducationEmbeddedKey key;

    @MapsId("id")
    @ManyToOne
    private User user;

    @NotNull
    private String degree;
    @NotNull
    private String field;
    @NotNull
    private String institution;
    @NotNull
    private String location;
    private int year;

	public EducationEmbeddedKey getKey() {
		return key;
	}

	public void setKey(EducationEmbeddedKey key) {
		this.key = key;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Education [key=" + key + ", degree=" + degree + ", field=" + field + ", institution=" + institution + ", location=" + location + ", year=" + year + "]";
	}
}
