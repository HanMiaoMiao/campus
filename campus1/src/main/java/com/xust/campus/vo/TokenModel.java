package com.xust.campus.vo;

public class TokenModel {
    private String userNumber;
    private String token;

    public TokenModel(String userNumber, String token) {
        this.userNumber = userNumber;
        this.token = token;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "userNumber='" + userNumber + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
