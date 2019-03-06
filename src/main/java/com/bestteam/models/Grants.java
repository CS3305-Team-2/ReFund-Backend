package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import java.util.LinkedHashSet;
import java.util.Set;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Grants")
public class Grants {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="description")
    private String description;

    @NotNull
    @Column(name="start_date")
    private LocalDate startDate;

    @NotNull
    @Column(name="end_date")
    private LocalDate endDate;

    @NotNull
    @Column(name="amount")
    private int amount;

    @NotNull
    @Column(name="funding_body")
    private String fundingBody;

    @NotNull
    @Column(name="funding_programme")
    private String fundingProgramme;

    @NotNull
    @Column(name="status")
    private String status;

    @Column(name="url")
    private String url;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="primary_attribution")
    private Set<Proposal> proposal = new LinkedHashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFundingBody() {
        return fundingBody;
    }

    public void setFundingBody(String fundingBody) {
        this.fundingBody = fundingBody;
    }

    public String getFundingProgramme() {
        return fundingProgramme;
    }

    public void setFundingProgramme(String fundingProgramme) {
        this.fundingProgramme = fundingProgramme;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Proposal> getProposal() {
        return proposal;
    }

    public void setProposal(Set<Proposal> proposal) {
        this.proposal = proposal;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", amount='" + getAmount() + "'" +
            ", fundingBody='" + getFundingBody() + "'" +
            ", fundingProgramme='" + getFundingProgramme() + "'" +
            ", status='" + getStatus() + "'" +
            ", url='" + getUrl() + "'" +
            ", proposal='" + getProposal() + "'" +
            "}";
    }
}
