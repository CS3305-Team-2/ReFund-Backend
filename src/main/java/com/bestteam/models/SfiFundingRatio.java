package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.bestteam.helpers.TimePercent;

@Entity
@Table(name="SfiFundingRatio")
public class SfiFundingRatio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="year")
    private Long year;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="annual_time_percent")
    private TimePercent annualTimePercent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public TimePercent getAnnualTimePercent() {
		return annualTimePercent;
	}

	public void setAnnualTimePercent(TimePercent annualTimePercent) {
		this.annualTimePercent = annualTimePercent;
	}

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", userId='" + getUserId() + "'" +
        ", year='" + getYear() + "'" +
        ", annualTimePercent='" + getAnnualTimePercent() + "'" +
        "}";
    }
}
