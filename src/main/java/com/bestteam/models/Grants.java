package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Grants")
public class Grants {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="start_date")
    private String startDate;

    @NotNull
    @Column(name="end_date")
    private String endDate;

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

    public Grants() {}

    public Grants(Long id, String startDate, String endDate, int amount, String fundingBody, String fundingProgramme, String status) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.fundingBody = fundingBody;
        this.fundingProgramme = fundingProgramme;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", amount='" + getAmount() + "'" +
            ", fundingBody='" + getFundingBody() + "'" +
            ", fundingProgramme='" + getFundingProgramme() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }


}
