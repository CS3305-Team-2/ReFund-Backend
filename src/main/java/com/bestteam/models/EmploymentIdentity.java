package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class EmploymentIdentity implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long employmentId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public EmploymentIdentity() {}

    public EmploymentIdentity(Long employmentId, Long userId) {
        this.employmentId = employmentId;
        this.userId = userId;
    }

	public Long getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(Long employmentId) {
		this.employmentId = employmentId;
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
            " employmentId='" + getEmploymentId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
