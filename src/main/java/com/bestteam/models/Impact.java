package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;

import javax.validation.constraints.NotNull;

import com.bestteam.models.ImpactIdentity;

@Entity
@Table(name="Impact")
public class Impact {

    @EmbeddedId
    private ImpactIdentity impactIdentity;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="category")
    private String category;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

	public Impact() {}

	 public Impact(ImpactIdentity impactIdentity, String title, String category, Long primaryAttribution) {
		this.impactIdentity = impactIdentity;
		this.title = title;
		this.category = category;
		this.primaryAttribution = primaryAttribution;
	}

	public ImpactIdentity getImpactIdentity() {
		return impactIdentity;
	}

	public void setId(ImpactIdentity impactIdentity) {
		this.impactIdentity = impactIdentity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
        " impactIdentity='" + getImpactIdentity() + "'" +
        ", title='" + getTitle() + "'" +
        ", category='" + getCategory() + "'" +
        ", primary_attribution='" + getPrimaryAttribution() + "'" +
        "}";
    }
}
