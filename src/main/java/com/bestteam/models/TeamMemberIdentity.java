package com.bestteam.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Embeddable
public class TeamMemberIdentity implements Serializable {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    public TeamMemberIdentity() {}

    public TeamMemberIdentity(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
}