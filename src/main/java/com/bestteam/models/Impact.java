package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Impact")
public class Impact {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long impactId;

    @NotNull
    @Column(name="primary_beneficiary")
    private Long userId;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="category")
    private String category;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

    public Long getImpactId() {
        return impactId;
    }

    public void setImpactId(Long impactId) {
        this.impactId = impactId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
            " impactId='" + getImpactId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", title='" + getTitle() + "'" +
            ", category='" + getCategory() + "'" +
            ", primaryAttribution='" + getPrimaryAttribution() + "'" +
            "}";
    }    
}
