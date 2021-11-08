package Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;

    private String bookName;
    private String ISBN;
    private LocalDate publishDate;
    private String author = null;
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

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publishDate=" + publishDate +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", returnDate=" + returnDate +
                '}';
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


