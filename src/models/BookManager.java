package models;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class BookManager {

    private static ObservableList<Book> bookList = FXCollections.observableArrayList();
    public static ObservableList<Book> loadAvailableBooks() {
        try (Connection conn = Database.getConnection()) {
            Statement stmt = conn.createStatement();

            String sql = "SELECT title, author, id FROM books WHERE is_borrowed = '0'";
            ResultSet rs = stmt.executeQuery(sql);

            // Add each book to the list
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int ID = rs.getInt("id");

                Book book = new AvailableBook(ID, title, author);
                System.out.println(book);
                bookList.add(book);
            }
            conn.close();
            return bookList;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.print("I am herereererererere 23");
            return bookList;
        } catch (SQLException e) {
            System.out.print("I am herererererere"+ e);
            e.printStackTrace();
            return bookList;
        }
    }

    public static ObservableList<Book> loadAllBooks(User currentUser) {
        try (Connection conn = Database.getConnection()) {
            Statement stmt = conn.createStatement();

            String sql = "SELECT title, author, id, is_borrowed, borrower_id FROM books";
            ResultSet rs = stmt.executeQuery(sql);

            // Add each book to the list
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int ID = rs.getInt("id");
                boolean status = rs.getBoolean("is_borrowed");
                int borrower_id=rs.getInt("borrower_id");

                Book book ;
                if(status && borrower_id==currentUser.getID())
                    book = new BorrowedBook(ID, title, author,"you", "Borrowed by YOU!");
                else if (status)
                    book = new BorrowedBook(ID, title, author);
                else
                    book = new AvailableBook(ID, title, author);
                System.out.println(book);
                bookList.add(book);
            }
            conn.close();
            return bookList;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.print("I am herereererererere 23");
            return bookList;
        } catch (SQLException e) {
            System.out.print("I am herererererere"+ e);
            e.printStackTrace();
            return bookList;
        }
    }
    public static ObservableList<Book> loadMyBooks() {
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT title, author, id FROM books WHERE is_borrowed = '1' AND borrower_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, HomeController.currentUser.getID());
            ResultSet rs = pstmt.executeQuery();
            // Add each book to the list
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int ID = rs.getInt("id");

                Book book = new BorrowedBook(ID, title, author, "you", "Borrowed by YOU!");
                System.out.println(book);
                bookList.add(book);
            }
            conn.close();
            return bookList;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.print("I am herereererererere 23");
            return bookList;
        } catch (SQLException e) {
            System.out.print("I am herererererere"+ e);
            e.printStackTrace();
            return bookList;
        }
    }
    public static void borrowBook(Book book, User user) {

        try (Connection conn = Database.getConnection()) {

            String sql = "UPDATE books SET is_borrowed = ?, borrower_id = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, user.getID());
            pstmt.setInt(3, book.getID());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Failed to borrow book. Book not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // or log it
        }
    }

    public static void returnBook(Book book, User user) {

        try (Connection conn = Database.getConnection()) {

            String sql = "UPDATE books SET is_borrowed = ?, borrower_id = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, user.getID());
            pstmt.setInt(3, book.getID());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Failed to borrow book. Book not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // or log it
        }
    }

    public static boolean addBook(Book book) {

        try (Connection conn = Database.getConnection()) {

            String sql = "INSERT INTO books (id, title, author, is_borrowed) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Book.get_ans_add_booksCnt());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setBoolean(4, false);
            pstmt.executeUpdate();
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

}
