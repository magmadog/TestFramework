package com.example.common.api.model;

public class User {
    private String login;
    private String password;
    private Token authToken;

    public User(String login, String password, Token authToken){
        this.login = login;
        this.password = password;
        this.authToken = authToken;
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.authToken = new Token();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken.getToken();
    }

    public void setAuthToken(String token) { this.authToken.setToken(token); }
}
