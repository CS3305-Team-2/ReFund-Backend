package com.bestteam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Awards")
public class Awards {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long awardsId;

    @NotNull
    @Column(name="user_id")
    private Long userId;

    @NotNull
    private int year;

    @NotNull
    @Column(name="awarding_body")
    private String awardingBody;

    @NotNull
    private String details;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAwardingBody() {
        return awardingBody;
    }

    public void setAwardingBody(String awardingBody) {
        this.awardingBody = awardingBody;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "{" +
            " awardsId='" + getAwardsId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", year='" + getYear() + "'" +
            ", awardingBody='" + getAwardingBody() + "'" +
            ", details='" + getDetails() + "'" +
            "}";
    }
}
