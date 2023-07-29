package com.api.dtos;

public class BodyRefreshDTO {
    private String RefreshToken;

    private String Email;

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
