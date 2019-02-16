package com.company.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url = "jdbc:mysql://localhost:3306/epam";
    private static String user = "root";
    private static String password = "root";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            initializeConnection();
        }
        return connection;
    }

    private static void initializeConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
