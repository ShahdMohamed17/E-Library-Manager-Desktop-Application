package models;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private String status; // available, borrowed, etc.
    public static int booksCnt=2;

    public Book(int bookID, String title, String author, String status) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.status = status;
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and Setters (Encapsulation)
    public String getTitle() {
        return title;
    }

    public int getID() {return bookID;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int get_ans_add_booksCnt(){
        booksCnt=booksCnt+1;
        return booksCnt;
    }

    // Polymorphic method
    public String getInfo() {
        return title + " by " + author;
    }
}

