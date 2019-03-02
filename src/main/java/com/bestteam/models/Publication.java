package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import javax.validation.constraints.NotNull;

import com.bestteam.helpers.PublicationType;
import com.bestteam.helpers.PublicationStatus;

@Entity
@Table(name="Publication")
public class Publication {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private PublicationType type;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="journal_name")
    private String journalName;

    @NotNull
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private PublicationStatus status;

    @NotNull
    @Column(name="doi")
    private String doi;

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

	public PublicationType getType() {
		return type;
	}

	public void setType(PublicationType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public PublicationStatus getStatus() {
		return status;
	}

	public void setStatus(PublicationStatus status) {
		this.status = status;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
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
        ", type='" + getType() + "'" +
        ", title='" + getTitle() + "'" +
        ", journalName='" + getJournalName() + "'" +
        ", status='" + getStatus() + "'" +
        ", doi='" + getDoi() + "'" +
        ", primaryAttribution='" + getPrimaryAttribution() + "'" +
        "}";
    }
}
