package com.example.common.api.auth;

import com.example.common.api.model.User;
import com.example.common.api.service.NetService;
import com.example.common.api.service.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestGetAuthToken {

    @Test
    public void testGetToken() throws IOException {
        String username = "testuser1";
        User user = UserService.getUserByLogin(username);
        Assertions.assertNotEquals(
                null,
                user,
                "Can't get user data from yaml file"
        );

        NetService apiService = new NetService();
        apiService.getToken(user);

        Assertions.assertNotEquals(
                "",
                user.getAuthToken(),
                "Failed to get auth token from postman mock server");
    }
}
