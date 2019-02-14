package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class PresentationIdentity implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long presentationId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public PresentationIdentity() {}

    public PresentationIdentity(Long presentationId, Long userId) {
        this.presentationId = presentationId;
        this.userId = userId;
    }

	public Long getPresentationId() {
		return presentationId;
	}

	public void setPresentationId(Long presentationId) {
		this.presentationId = presentationId;
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
            " presentationId='" + getPresentationId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
