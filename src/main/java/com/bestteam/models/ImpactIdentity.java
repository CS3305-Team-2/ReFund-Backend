package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class ImpactIdentity implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long impactId;

    @NotNull
    @Column(name="primary_beneficiary")
    private Long userId;

    public ImpactIdentity() {}

    public ImpactIdentity(Long impactId, Long userId) {
        this.impactId = impactId;
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "{" +
            " impactId='" + getImpactId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
