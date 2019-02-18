package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class InnovationIdentity implements Serializable {

    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long innovationId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public InnovationIdentity() {}

    public InnovationIdentity(Long innovationId, Long userId) {
        this.innovationId = innovationId;
        this.userId = userId;
    }

	public Long getInnovationId() {
		return innovationId;
	}

	public void setInnovationId(Long innovationId) {
		this.innovationId = innovationId;
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
            " innovationId='" + getInnovationId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}
