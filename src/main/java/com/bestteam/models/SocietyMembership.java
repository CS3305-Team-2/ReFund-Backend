package com.bestteam.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="SocietyMembership")
public class SocietyMembership {
    @EmbeddedId
    private SocietyMembershipIdentity societyMembershipIdentity;

    @NotNull
    @Column(name="start_date")
    private String startDate;

    @NotNull
    @Column(name="end_date")
    private String endDate;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String status;

    public SocietyMembershipIdentity getSocietyMembershipIdentity() {
        return societyMembershipIdentity;
    }

    public void setSocietyMembershipIdentity(SocietyMembershipIdentity societyMembershipIdentity) {
        this.societyMembershipIdentity = societyMembershipIdentity;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
        return "{" +
               ",societyMembershipIdentity='" + getSocietyMembershipIdentity() + "'" +
               ",start_date='" + getStartDate() + "'" +
               ",end_date='" + getEndDate() + "'" +
               ",name='" + getName() + "'" +
               ",type='" + getType() + "'" +
               ",status='" + getStatus() + "'" +
               "}";
    }
}
