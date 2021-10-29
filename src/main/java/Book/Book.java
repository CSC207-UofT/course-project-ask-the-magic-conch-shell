package Book;

import java.time.LocalDate;



public class Book {

    private final int bookID;
    private final String bookName;
    private final String ISBN;
    private final LocalDate publishDate;
    private final String author;
    public BookPositionStatus status;
    public LocalDate returnDate;

    public Book(int bookID, String bookName, String ISBN, LocalDate publishDate, String author) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.author = author;
        this.status = BookPositionStatus.UNLENDED;
        this.returnDate = null;
    }


    public int getbookID(){
        return bookID;
    }

    public String getbookName(){
        return bookName;
    }

    public String getISBN(){
        return ISBN;
    }

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

