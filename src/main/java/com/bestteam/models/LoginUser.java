package com.bestteam.models;

public class LoginUser {
    private String orcid;
    private String password;

    public LoginUser(String orcid, String password) {
        this.orcid = orcid;
        this.password = password;
    }

    public String getOrcid() {
        return this.orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            " orcid='" + getOrcid() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}