package sk.tmconsulting.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHelloWorld {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test_db"; // library_db is name of your database
        String username = "root"; // username of your database
        String password = "123456"; // password of your database

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}