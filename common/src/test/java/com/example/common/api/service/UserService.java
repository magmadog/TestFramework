package com.example.common.api.service;

import com.example.common.api.model.User;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private static final ArrayList<User> users = new ArrayList<>();

    static {
        Yaml yaml = new Yaml();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("users.yml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Map<String, String>> data = yaml.load(inputStream);
        for (Map<String, String> user : data){
            users.add(new User(user.get("login"), user.get("password")));
        }
    }

    public static User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
