package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import models.User;
import models.UserManager;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLogin() throws IOException {
        User user = null;
        user = UserManager.login(usernameField.getText(), passwordField.getText());
        if (user != null) {
            // Store user info in session (you can create a SessionManager for this)
            HomeController.currentUser = user;
            errorLabel.setText("Login successful!");
            System.out.println("Step 1");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            System.out.println("Step 2");
            Stage stage = (Stage) usernameField.getScene().getWindow();
            System.out.println("Step 3");
            stage.setScene(new Scene(loader.load()));
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    @FXML
    private void goToRegister() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}

