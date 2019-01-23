package com.bestteam.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserType")
public class UserType {
    @Id
    @Column(name="type")
    private String type;

    public UserType() {}

    public UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}