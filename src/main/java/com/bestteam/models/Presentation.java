package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Presentations")
public class Presentation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

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
    private String eventType;

    public Presentation() {}

    public Presentation(Long id, Long year, String title, String organisingBody, String location, Long primaryAttribution, String eventType) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.organisingBody = organisingBody;
        this.location = location;
        this.primaryAttribution = primaryAttribution;
        this.eventType = eventType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", year='" + getYear() + "'" +
        ", title='" + getTitle() + "'" +
        ", organising_body='" + getOrganisingBody() + "'" +
        ", location='" + getLocation() + "'" +
        ", primary_attribution='" + getPrimaryAttribution() + "'" +
        ", event_type='" + getEventType() + "'" +
        "}";
    }

}
