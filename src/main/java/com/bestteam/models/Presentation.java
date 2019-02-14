package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;

import javax.validation.constraints.NotNull;

import com.bestteam.models.PresentationIdentity;

@Entity
@Table(name="Presentations")
public class Presentation {

    @EmbeddedId
    private PresentationIdentity presentationIdentity;

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

        public Presentation(PresentationIdentity presentationIdentity, Long year, String title, String organisingBody, String location, Long primaryAttribution, String eventType) {
            super();
            this.presentationIdentity = presentationIdentity;
            this.year = year;
            this.title = title;
            this.organisingBody = organisingBody;
            this.location = location;
            this.primaryAttribution = primaryAttribution;
            this.eventType = eventType;
        }

        public PresentationIdentity getPresentationIdentity() {
            return presentationIdentity;
        }

        public void setPresentationIdentity(PresentationIdentity presentationIdentity) {
            this.presentationIdentity = presentationIdentity;
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
        " presentationIdentity='" + getPresentationIdentity() + "'" +
        ", year='" + getYear() + "'" +
        ", title='" + getTitle() + "'" +
        ", organising_body='" + getOrganisingBody() + "'" +
        ", location='" + getLocation() + "'" +
        ", primary_attribution='" + getPrimaryAttribution() + "'" +
        ", event_type='" + getEventType() + "'" +
        "}";
    }
}
