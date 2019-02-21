package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Grants")
public class TeamMember {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    
}