package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="pi")
    private Long pi;

    @NotNull
    @Column(name="ro_approved")
    private boolean roApproved;

    @NotNull
    @Column(name="sfi_approved")
    private boolean sfiApproved;

    @NotNull
    @Column(name="is_research_center")
    private boolean isResearchCenter;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

    @NotNull
    @Column(name="budget")
    private Long budget;

    public Project() {}

    public Project(Long id, Long pi, boolean roApproved, boolean sfiApproved, boolean isResearchCenter, Long primaryAttribution, Long budget) {
        this.id = id;
        this.pi = pi;
        this.roApproved = roApproved;
        this.sfiApproved = sfiApproved;
        this.isResearchCenter = isResearchCenter;
        this.primaryAttribution = primaryAttribution;
        this.budget = budget;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPi() {
        return this.pi;
    }

    public void setPi(Long pi) {
        this.pi = pi;
    }

    public boolean isRoApproved() {
        return this.roApproved;
    }

    public boolean getRoApproved() {
        return this.roApproved;
    }

    public void setRoApproved(boolean roApproved) {
        this.roApproved = roApproved;
    }

    public boolean isSfiApproved() {
        return this.sfiApproved;
    }

    public boolean getSfiApproved() {
        return this.sfiApproved;
    }

    public void setSfiApproved(boolean sfiApproved) {
        this.sfiApproved = sfiApproved;
    }

    public boolean isIsResearchCenter() {
        return this.isResearchCenter;
    }

    public boolean getIsResearchCenter() {
        return this.isResearchCenter;
    }

    public void setIsResearchCenter(boolean isResearchCenter) {
        this.isResearchCenter = isResearchCenter;
    }

    public Long getPrimaryAttribution() {
        return this.primaryAttribution;
    }

    public void setPrimaryAttribution(Long primaryAttribution) {
        this.primaryAttribution = primaryAttribution;
    }

    public Long getBudget() {
        return this.budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", pi='" + getPi() + "'" +
            ", roApproved='" + isRoApproved() + "'" +
            ", sfiApproved='" + isSfiApproved() + "'" +
            ", isResearchCenter='" + isIsResearchCenter() + "'" +
            ", primaryAttribution='" + getPrimaryAttribution() + "'" +
            ", budget='" + getBudget() + "'" +
            "}";
    }
}