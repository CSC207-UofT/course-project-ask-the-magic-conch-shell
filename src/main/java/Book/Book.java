package Book;

import UseCase.BookPositionStatus;

import java.time.LocalDate;



public class Book {

    private final int bookID;
    private final String bookName;
    private final String ISBN;
    private final LocalDate publishDate;
    private final String author;
    public BookPositionStatus status;
    public LocalDate returnDate;
    public String type;

    public Book(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String type) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.author = author;
        this.status = BookPositionStatus.UNLENDED;
        this.returnDate = null;
        this.type = type;
    }

    public int getBookID(){
        return bookID;
    }

    public String getBookName(){
        return bookName;
    }

    public String getISBN(){return ISBN;}

    public LocalDate getPublishDate(){
        return publishDate;
    }

    public String getAuthor(){
        return author;
    }

    public BookPositionStatus getStatus(){
        return status;
    }

    public void setStatus(BookPositionStatus status) {
        this.status = status;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

