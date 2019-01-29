package com.bestteam.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SocietyMembership")
public class SocietyMembership {
    @EmbeddedId
    private SocietyMembershipIdentity societyMembershipIdentity;

    @NotNull
    private String institution;

    @NotNull
    private String location;

    @NotNull
    private int years;

    public SocietyMembership() {}

    public SocietyMembership(SocietyMembershipIdentity societyMembershipIdentity , String institution, String location, int years) {
        super();
        this.societyMembershipIdentity = societyMembershipIdentity;
        this.institution = institution;
        this.location = location;
        this.years = years;
    }

    public SocietyMembershipIdentity getSocietyMembershipIdentity() {
		return societyMembershipIdentity;
	}

	public void setSocietyMembershipIdentity(SocietyMembershipIdentity societyMembershipIdentity) {
		this.societyMembershipIdentity = societyMembershipIdentity;
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
               ",societyMembershipIdentity='" + getSocietyMembershipIdentity() + "'" +
               ",institution='" + getInstitution() + "'" +
               ",location='" + getLocation() + "'" +
               ",years='" + getYears() + "'" +
               "}";
    }
}
