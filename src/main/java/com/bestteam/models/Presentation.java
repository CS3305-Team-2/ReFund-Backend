package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import javax.validation.constraints.NotNull;

import com.bestteam.helpers.PresentationType;

@Entity
@Table(name="Presentations")
public class Presentation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long presentationId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="year")
    private Long year;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="organising_body")
    private String organisingBody;

    @NotNull
    @Column(name="location")
    private String location;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

    @NotNull
    @Column(name="event_type")
    @Enumerated(EnumType.STRING)
    private PresentationType eventType;

    public Presentation() {}

    public Presentation(Long presentationId, Long userId, Long year,
                        String title, String organisingBody, String location,
                        Long primaryAttribution, PresentationType eventType) {
        this.presentationId = presentationId;
        this.userId = userId;
        this.year = year;
        this.title = title;
        this.organisingBody = organisingBody;
        this.location = location;
        this.primaryAttribution = primaryAttribution;
        this.eventType = eventType;
    }

    public Long getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(Long presentationId) {
        this.presentationId = presentationId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrganisingBody() {
        return organisingBody;
    }

    public void setOrganisingBody(String organisingBody) {
        this.organisingBody = organisingBody;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getPrimaryAttribution() {
        return primaryAttribution;
    }

    public void setPrimaryAttribution(Long primaryAttribution) {
        this.primaryAttribution = primaryAttribution;
    }

    public PresentationType getEventType() {
        return eventType;
    }

    public void setEventType(PresentationType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "{" +
            " presentationId='" + getPresentationId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", year='" + getYear() + "'" +
            ", title='" + getTitle() + "'" +
            ", organisingBody='" + getOrganisingBody() + "'" +
            ", location='" + getLocation() + "'" +
            ", primaryAttribution='" + getPrimaryAttribution() + "'" +
            ", eventType='" + getEventType() + "'" +
            "}";
    }
}
