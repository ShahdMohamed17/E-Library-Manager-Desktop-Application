package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Book;
import models.BookManager;

import java.io.IOException;

public class ShopBooksController {

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> statusColumn;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Link table columns to Book class properties
        bookTable.getItems().clear();
        System.out.print("Ana dkahalt wallahy");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadAvailableBooks();
    }

    private void loadAvailableBooks() {
        bookTable.getItems().clear();
        System.out.print("Ana dakhalt hna");
        try {
            bookList = BookManager.loadAvailableBooks();
            // Populate table
            bookTable.setItems(bookList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void goToHome() throws IOException {
        bookTable.getItems().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Stage stage = (Stage) bookTable.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
    @FXML
    private void BorrowBook(){
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            BookManager.borrowBook(selectedBook,HomeController.currentUser);
            bookTable.getItems().clear();
            loadAvailableBooks();
        } else {
            System.out.println("Error ya Shahoda");
        }

    }
}
