package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class AwardIdentity implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long awardId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public AwardIdentity() {}

    public AwardIdentity(Long awardId, Long userId) {
        this.awardId = awardId;
        this.userId = userId;
    }

	public Long getAwardId() {
		return awardId;
	}

	public void setAwardId(Long awardId) {
		this.awardId = awardId;
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
            " awardId='" + getAwardId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
