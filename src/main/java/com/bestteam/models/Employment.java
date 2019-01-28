package com.bestteam.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Employment")
public class Employment {
    @EmbeddedId
    private EmploymentIdentity employmentIdentity;

    @NotNull
    private String institution;

    @NotNull
    private String location;

    @NotNull
    private int years;

    public Employment() {}

    public Employment(EmploymentIdentity employmentIdentity, String institution, String location, int years) {
        this.employmentIdentity = employmentIdentity;
        this.institution = institution;
        this.location = location;
        this.years = years;
    }

    public EmploymentIdentity getEmploymentIdentity() {
        return this.employmentIdentity;
    }

    public void setEmploymentIdentity(EmploymentIdentity employmentIdentity) {
        this.employmentIdentity = employmentIdentity;
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

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	@Override
	public String toString() {
        return "{" +
               ",id='" + getEmploymentIdentity() + "'" +
               ",institution='" + getInstitution() + "'" +
               ",location='" + getLocation() + "'" +
               ",years='" + getYears() + "'" +
               "}";
    }
}
