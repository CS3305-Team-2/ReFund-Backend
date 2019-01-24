package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Embeddable
public class EducationEmbeddedKey implements Serializable {

    @GeneratedValue
    private Long id;

    @Column(name="user_id")
    private Long userId;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "EducationEmbeddedKey [id=" + id + ", userID=" + userId + "]";
	}
}
