package org.example.zeroproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionWrapper {
    private static Connection conn;
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                try {
                    conn = DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/zeroproject",
                            "postgres",
                            "postgres"
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
