package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="CommunicationOverview")
public class CommunicationOverview {
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
    @Column(name="number_of_public_lectures")
    private Long numberOfPublicLectures;

    @NotNull
    @Column(name="number_of_visits")
    private Long numberOfVisits;

    @NotNull
    @Column(name="number_of_media_interactions")
    private Long numberOfMediaInteractions;

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

	public Long getNumberOfPublicLectures() {
		return numberOfPublicLectures;
	}

	public void setNumberOfPublicLectures(Long numberOfPublicLectures) {
		this.numberOfPublicLectures = numberOfPublicLectures;
	}

	public Long getNumberOfVisits() {
		return numberOfVisits;
	}

	public void setNumberOfVisits(Long numberOfVisits) {
		this.numberOfVisits = numberOfVisits;
	}

	public Long getNumberOfMediaInteractions() {
		return numberOfMediaInteractions;
	}

	public void setNumberOfMediaInteractions(Long numberOfMediaInteractions) {
		this.numberOfMediaInteractions = numberOfMediaInteractions;
	}

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", userId='" + getUserId() + "'" +
        ", year='" + getYear() + "'" +
        ", numberOfPublicLectures='" + getNumberOfPublicLectures() + "'" +
        ", numberOfVisits='" + getNumberOfVisits() + "'" +
        ", numberOfMediaInteractions='" + getNumberOfMediaInteractions() + "'" +
        "}";
    }
}
