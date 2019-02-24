package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;

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
    @Column(name="is_research_center")
    private boolean isResearchCenter;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

    @NotNull
    @Column(name="budget")
    private Long budget;

    //private Set<

    public Project() {}

    public Project(Long id, Long pi, boolean isResearchCenter, Long primaryAttribution, Long budget) {
        this.id = id;
        this.pi = pi;
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
            ", isResearchCenter='" + isIsResearchCenter() + "'" +
            ", primaryAttribution='" + getPrimaryAttribution() + "'" +
            ", budget='" + getBudget() + "'" +
            "}";
    }
}
