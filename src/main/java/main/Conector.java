package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "tim";
    private final String PASSWORD = "pass";

    private Connection connection;

    public Conector() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
