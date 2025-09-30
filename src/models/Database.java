package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // MySQL connection URL: "jdbc:mysql://<host>:<port>/<database_name>"
    private static final String URL = "jdbc:mysql://localhost:3306/library_system";

    // MySQL login username (default in XAMPP is usually "root")
    private static final String USER = "root";

    // MySQL login password (blank by default in XAMPP)
    private static final String PASSWORD = "";

    /**
     * This method returns a Connection object that connects Java to your MySQL database.
     * It uses the URL, USER, and PASSWORD to establish that connection.
     */
    public static Connection getConnection() throws SQLException {
        // Connect to the database and return the connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
