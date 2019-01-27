package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.util.Objects;
import javax.validation.constraints.NotNull;


@Embeddable
public class EducationEmbeddedKey implements Serializable {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    @NotNull
    private Long id;

    @Column(name="user_id", insertable=false, updatable=false)
    @NotNull
    private Long userId;


    public EducationEmbeddedKey() {
    }

    public EducationEmbeddedKey(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EducationEmbeddedKey)) return false;
        EducationEmbeddedKey that = (EducationEmbeddedKey) o;
        return Objects.equals(getId(), that.getId()) &&
               Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId());
    }

}
