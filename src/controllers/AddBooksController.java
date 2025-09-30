package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import models.Book;
import models.BookManager;

import java.io.IOException;

public class AddBooksController {

    @FXML
    private TextField bookTitle;

    @FXML
    private TextField bookAuthor;

    @FXML
    private Label errorLabel;



    @FXML
    private void goToHome() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Stage stage = (Stage) bookTitle.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    private void addBook(){
        Book book = new Book(bookTitle.getText(), bookAuthor.getText());
        boolean success=BookManager.addBook(book);
        if(success){
            bookTitle.clear();
            bookAuthor.clear();
            errorLabel.setText("Book added successfully!");
        }
        else {
            errorLabel.setText("Book could not be added, please try another book!");
        }
    }
}

