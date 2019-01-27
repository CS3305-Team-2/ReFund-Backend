package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;


@Embeddable
public class EducationEmbeddedKey implements Serializable {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",insertable=false, updatable=false)
    @NotNull
    private Long educationId;

    @Column(name="user_id")
    @NotNull
    private Long userId;


    public EducationEmbeddedKey() {
    }

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
		return "EducationEmbeddedKey [educationId=" + educationId + ", userID=" + userId + "]";
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationEmbeddedKey)) return false;
        EducationEmbeddedKey that = (EducationEmbeddedKey) o;
        return Objects.equals(getEducationId(), that.getEducationId()) &&
               Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEducationId(), getUserId());
    }

}
