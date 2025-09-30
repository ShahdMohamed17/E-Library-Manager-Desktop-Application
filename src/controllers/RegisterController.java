package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import models.UserManager;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleRegister(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Clear previous error messages
        errorLabel.setText("");

        // Validate input
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter both username and password.");
            return;
        }

        // Attempt registration
        boolean success = UserManager.register(username, password);

        if (success) {
            errorLabel.setStyle("-fx-text-fill: green;");
            clearFields();

            // Optional: Wait briefly and go to login
            new Thread(() -> {
                try {
                    Thread.sleep(3000); // 3 seconds delay
                    javafx.application.Platform.runLater(() -> {
                        try {
                            goToLogin();
                        } catch (IOException e) {
                            e.printStackTrace(); // Or show an alert dialog
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            errorLabel.setText("Registration successful! Redirecting to login...");
        } else {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Username already exists or an error occurred.");
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    @FXML
    private void goToLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}