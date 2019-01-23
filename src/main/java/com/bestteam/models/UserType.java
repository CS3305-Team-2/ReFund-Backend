package com.bestteam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserType")
public class UserType {
    @Id
    @Column(name="type")
    private String type;
}