package models;

public class AvailableBook extends Book {
    public AvailableBook(int bookID, String title, String author) {
        super(bookID, title, author, "available");
    }

    @Override
    public String getInfo() {
        return "Available: " + super.getInfo();
    }
}
