package com.example.common.db;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection {

    /*
    Проверка подключения к PostgreSQL серверу и выполнение запроса к таблице
    DB: test_db
    Table-projects: project_id(int), name(char*), start_date(date)
    */

    private final String url = "jdbc:postgresql://localhost:5432/test_db";
    private final String user = "postgres";
    private final String password = "";
    private final String sql = "SELECT name FROM projects WHERE project_id = 1";
    private final String expectedProjectName = "Home Credit";

    @Test
    public void testJDBCConnection() {

        String projectName = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                projectName = result.getString("name");
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        Assertions.assertEquals(expectedProjectName, projectName);
    }

    @Test
    public void testJDBIConnection(){
        Jdbi jdbi = Jdbi.create(url, user, password);

        String projectName = "";
        try (Handle handle = jdbi.open()) {
            Query query = handle.createQuery(sql);
            projectName = query.mapTo(String.class).first();
        }catch (Exception e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        Assertions.assertEquals(expectedProjectName, projectName);
    }
}
