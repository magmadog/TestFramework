package com.example.common.api.model;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("status")
    public String status;
    @SerializedName("generatedToken")
    public String generatedToken;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return generatedToken;
    }

    public void setToken(String token) {
        this.generatedToken = token;
    }
}
