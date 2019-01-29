package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class AwardsIdentity implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long awardsId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public AwardsIdentity() {}

    public AwardsIdentity(Long awardsId, Long userId) {
        this.awardsId = awardsId;
        this.userId = userId;
    }

	public Long getAwardsId() {
		return awardsId;
	}

	public void setAwardsId(Long awardsId) {
		this.awardsId = awardsId;
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
            " awardsId='" + getAwardsId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
