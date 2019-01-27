package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class EducationEmbeddedKey implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long educationId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public EducationEmbeddedKey() {}

    public EducationEmbeddedKey(Long educationId, Long userId) {
        this.educationId = educationId;
        this.userId = userId;
    }

	public Long getEducationId() {
		return educationId;
	}

	public void setEducationId(Long educationId) {
		this.educationId = educationId;
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
            " educationId='" + getEducationId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}