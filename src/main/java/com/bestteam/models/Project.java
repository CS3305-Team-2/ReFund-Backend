package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="pi")
    private Long pi;

    @Null
    @Column(name="is_research_center")
    private boolean isResearchCenter;

    @NotNull
    @Column(name="budget")
    private Long budget;

    @Column(name="status")
    private String status;

    @OneToOne
    @JoinColumn(name="proposal_id", nullable=true, referencedColumnName="id")
    private Proposal proposal;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Set<TeamMember> teamMembers = new HashSet<>();

    public Project() {}

    public Project(Long id, Long pi, boolean isResearchCenter, Long budget, String status, Proposal proposal) {
        this.id = id;
        this.pi = pi;
        this.isResearchCenter = isResearchCenter;
        this.budget = budget;
        this.status = status;
        this.proposal = proposal;
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

    public void setIsResearchCenter(boolean isResearchCenter) {
        this.isResearchCenter = isResearchCenter;
    }

    public Long getBudget() {
        return this.budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
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
            " id='" + getId() + "'" +
            ", pi='" + getPi() + "'" +
            ", isResearchCenter='" + isIsResearchCenter() + "'" +
            ", budget='" + getBudget() + "'" +
            ", status='" + getStatus() + "'" +
            ", proposal='" + getProposal() + "'" +
            ", teamMembers='" + getTeamMembers() + "'" +
            "}";
    }
}
