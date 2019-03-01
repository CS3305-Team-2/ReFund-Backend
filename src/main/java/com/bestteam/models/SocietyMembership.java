package com.bestteam.models;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SocietyMembership")
public class SocietyMembership {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable=false, updatable=false, nullable=false)
    private Long societyMembershipId;

    @NotNull
    @Column(name="user_id")
    private Long userId;
    @NotNull
    @Column(name="start_date")
    private String startDate;

    @NotNull
    @Column(name="end_date")
    private String endDate;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String status;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
            " societyMembershipId='" + getSocietyMembershipId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
