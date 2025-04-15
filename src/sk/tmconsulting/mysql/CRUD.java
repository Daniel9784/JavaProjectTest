package sk.tmconsulting.mysql;

import java.sql.*;

public class CRUD {

    public static void delete(Connection conn) throws SQLException {
        // the mysql insert statement
        String query = "DELETE FROM book WHERE id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, 1);
        // execute the preparedstatement
        preparedStmt.execute();
    }

    public static void insert(Connection conn) throws SQLException {
// the mysql insert statement
        String query = "INSERT INTO book (name, pages) VALUES (?, ?)";
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString (1, "Hamnet");
        preparedStmt.setInt(2, 450);
        // execute the preparedstatement
        preparedStmt.execute();
    }

    public static void select(Connection conn) throws SQLException {
        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "SELECT * FROM book";
        // create the java statement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        // execute the query, and get a java resultset
        ResultSet rs = preparedStmt.executeQuery(query);
        // iterate through the java resultset
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int pages = rs.getInt("pages");
            // print the results
            System.out.println(id + " " +name + " " + pages);
        }
        preparedStmt.close();
    }

    public static void update(Connection conn) throws SQLException {
        // create the java mysql update preparedstatement
        String query = "UPDATE book SET name = ?, pages = ? WHERE id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1, "Já, NE robot");
        preparedStmt.setInt(2, 123);
        preparedStmt.setInt(3, 2);
        // execute the java preparedstatement
        preparedStmt.executeUpdate();
    }

    public static void main(String[] args) {
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/test_db";
        String username = "root";
        String password = "123456";
        System.out.println("Connecting database...");
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        System.out.println("SELECT all data FROM book");
       try {
           select(conn);
       } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       System.out.println("UPDATE book WITH id = 1");
        try {
            update(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("INSERT new book");
        try {
            insert(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("DELETE book WITH id = 1");
        try {
            delete(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Database connection is going to close");
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
