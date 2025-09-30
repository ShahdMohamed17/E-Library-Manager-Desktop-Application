package models;

import java.sql.*;

public class UserManager {

    /**
     * Registers a new user in the database.
     * Returns true if successful, false if username already exists or other error.
     */
    public static boolean register(String username, String password) {
        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO users (id, username, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            int cnt = User.get_and_add_id_cnt();
            stmt.setInt(1, cnt); // Set ID to 3 for testing
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.executeUpdate();
            return true;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.print("I am herereererererere 23");
            // Username already exists (if unique constraint is set on username)
            return false;
        } catch (SQLException e) {
            System.out.print("I am herererererere");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Authenticates a user with given username and password.
     * Returns a User object if login is successful, or null if failed.
     */
    public static User login(String username, String password) {
        System.out.print("The code was here one day");
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // You can also retrieve id if needed: rs.getInt("id")
                return new User(rs.getString("username"), rs.getString("password"), rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.print("here is the error: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
