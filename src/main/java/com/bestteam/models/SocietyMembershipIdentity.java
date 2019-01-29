package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class SocietyMembershipIdentity implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long societyMembershipId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public SocietyMembershipIdentity() {}

    public SocietyMembershipIdentity(Long societyMembershipId, Long userId) {
        this.societyMembershipId = societyMembershipId;
        this.userId = userId;
    }

	public Long getSocietyMembershipId() {
		return societyMembershipId;
	}

	public void setSocietyMembershipId(Long societyMembershipId) {
		this.societyMembershipId = societyMembershipId;
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
            " societyMembershipId='" + getSocietyMembershipId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
