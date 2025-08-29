package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "tim";
    private static final String PASSWORD = "pass";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection==null){
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection!=null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection has been closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    }