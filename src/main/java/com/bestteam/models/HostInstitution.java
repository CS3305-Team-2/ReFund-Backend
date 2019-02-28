package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="HostInstitution")
public class HostInstitution {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="address_1")
    private String address1;

    @Column(name="address_2")
    private String address2;

    @Column(name="post_code")
    private String postCode;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="telephone")
    private String telephone;

	public HostInstitution() {}

	public HostInstitution(Long id, String name, String address1,
                           String address2, String postCode,
                           String email, String telephone) {
		this.id = id;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.postCode = postCode;
		this.email = email;
		this.telephone = telephone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
