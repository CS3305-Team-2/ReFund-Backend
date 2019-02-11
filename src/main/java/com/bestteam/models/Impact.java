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
@Table(name="Impact")
public class Impact {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="category")
    private String category;

    @NotNull
    @Column(name="primary_beneficiary")
    private String primaryBeneficiary;

    @NotNull
    @Column(name="primary_attribution")
    private String primaryAttribution;

	public Impact() {}

	public Impact(Long id, String title, String category, String primaryBeneficiary, String primaryAttribution) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.primaryBeneficiary = primaryBeneficiary;
		this.primaryAttribution = primaryAttribution;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPrimaryBeneficiary() {
		return primaryBeneficiary;
	}

	public void setPrimaryBeneficiary(String primaryBeneficiary) {
		this.primaryBeneficiary = primaryBeneficiary;
	}

	public String getPrimaryAttribution() {
		return primaryAttribution;
	}

	public void setPrimaryAttribution(String primaryAttribution) {
		this.primaryAttribution = primaryAttribution;
	}
    @Override
    public String toString() {
        return "{" +
        " id='" + getId() + "'" +
        ", title='" + getTitle() + "'" +
        ", category='" + getCategory() + "'" +
        ", primary_beneficiary='" + getPrimaryBeneficiary() + "'" +
        ", primary_attribution='" + getPrimaryAttribution() + "'" +
        "}";
    }
}
