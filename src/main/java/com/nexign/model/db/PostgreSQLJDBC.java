package com.nexign.model.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLJDBC {

    //  Database credentials
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String USER = "AppUser";
    private static final String PASS = "1111";

    public static void main(String[] argv) {

        System.err.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            return;
        }

        System.err.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.err.println("Connection Failed");
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.err.println("Failed to make connection to database");
        }
    }
}