package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import models.User;

import java.io.IOException;

public class HomeController {

    public static User currentUser = new User();
    @FXML
    private Label homelabel;

    @FXML
    private void goToAvailableBooks() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/all_books.fxml"));
        Stage stage = (Stage) homelabel.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    private void LogOut() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Stage stage = (Stage) homelabel.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    private void goToShop() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/shop_books.fxml"));
        Stage stage = (Stage) homelabel.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    private void goToMyBooks() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/my_books.fxml"));
        Stage stage = (Stage) homelabel.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    private void goToAddBooks() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/add_books.fxml"));
        Stage stage = (Stage) homelabel.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}

