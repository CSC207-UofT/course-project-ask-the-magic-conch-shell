package Book;

import java.time.LocalDate;



public class Book {

    private final int book_id;
    private final String book_name;
    private final String ISBN;
    private final LocalDate publishDate;
    private final String author;
    public Book_position_status status;
    public LocalDate returnDate;

    public Book(int book_id, String book_name, String ISBN, LocalDate publishDate, String author) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.author = author;
        this.status = Book_position_status.UNLENDED;
        this.returnDate = null;
    }


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

