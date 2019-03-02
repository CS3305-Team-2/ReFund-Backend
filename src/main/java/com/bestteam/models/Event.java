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

import com.bestteam.helpers.EventType;

@Entity
@Table(name="Event")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="event_type")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @NotNull
    @Column(name="role")
    private String role;

    @NotNull
    @Column(name="event_location")
    private String eventLocation;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Long getPrimaryAttribution() {
		return primaryAttribution;
	}

	public void setPrimaryAttribution(Long primaryAttribution) {
		this.primaryAttribution = primaryAttribution;
	}

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", userId='" + getUserId() + "'" +
        ", startDate='" + getStartDate() + "'" +
        ", endDate='" + getEndDate() + "'" +
        ", title='" + getTitle() + "'" +
        ", eventType='" + getEventType() + "'" +
        ", role='" + getRole() + "'" +
        ", eventLocation='" + getEventLocation() + "'" +
        ", primaryAttribution='" + getPrimaryAttribution() + "'" +
        "}";
    }
}
