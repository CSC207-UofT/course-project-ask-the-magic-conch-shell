package Book_package;
import Book_package.Book_position_status;
import Book_package.Book_item_status;

import java.time.LocalDate;


public class Book {
    public Book(int book_id, String book_name, String ISBN, LocalDate publishDate, String author, Book_item_status bookStatus, Book_position_status status, LocalDate returnDate) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.author = author;
        this.status = status;
        this.bookStatus = bookStatus;
        this.returnDate = returnDate;
    }
    private final int book_id;
    private final String book_name;
    private final String ISBN;
    private final LocalDate publishDate;
    private final String author;
    public Book_position_status status;
    public Book_item_status bookStatus;

    private LocalDate returnDate;

    public int getBook_id(){
        return book_id;
    }

    public String getBook_name(){
        return book_name;
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

    public Book_position_status getStatus(){
        return status;
    }

    public void setStatus(Book_position_status status) {
        this.status = status;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

