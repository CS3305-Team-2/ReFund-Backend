package com.bestteam.helpers;

public class PasswordChange {
    private String oldPassword;
    private String newPassword;
    
    public PasswordChange(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }
}