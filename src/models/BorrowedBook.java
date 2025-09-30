package models;

public class BorrowedBook extends Book {
    private String borrowedBy;

    public BorrowedBook(int bookID, String title, String author, String borrowedBy) {
        super(bookID, title, author, "Borrowed :(");
        this.borrowedBy = borrowedBy;
    }

    public BorrowedBook(int bookID, String title, String author, String borrowedBy, String statu) {
        super(bookID, title, author, statu);
        this.borrowedBy = borrowedBy;
    }

    public BorrowedBook(int bookID, String title, String author) {
        super(bookID, title, author, "Borrowed :(");
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    @Override
    public String getInfo() {
        return "Borrowed by " + borrowedBy + ": " + super.getInfo();
    }
}
