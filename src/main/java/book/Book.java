package book;

import java.time.LocalDate;


/**
 * The book with different variables.
 *
 * IMPORTANT: Since there are different types of book such as Dictionary, Magazine etc.
 * We will put these parameters in the interface and use them for different subclasses of book
 */
public class Book {
    /**
     * Information for the book.
     */
    private final int bookId;
    private final String bookName;
    private final String ISBN;
    private final LocalDate publishDate;
    private final String author;
    public BookPositionStatus status;
    public LocalDate returnDate;

    /**
     * A new book with book id, name, ISBN, publish date, author, position status and return date.
     *
     * @param bookId the bookID
     * @param bookName the bookName
     * @param ISBN the ISBN
     * @param publishDate the publishDate
     * @param author the author
     */
    public Book(int bookId, String bookName, String ISBN, LocalDate publishDate, String author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.publishDate = publishDate;
        this.author = author;
        this.status = BookPositionStatus.UNLENDED;
        this.returnDate = null;
    }

    /**
     *
     * @return book's id.
     */
    public int getBookId(){
        return bookId;
    }

    /**
     *
     * @return book's name.
     */
    public String getBookName(){
        return bookName;
    }

    /**
     *
     * @return book's ISBN.
     */
    public String getISBN(){
        return ISBN;
    }

    /**
     *
     * @return book's publish date.
     */
    public LocalDate getPublishDate(){
        return publishDate;
    }

    /**
     *
     * @return the author of book.
     */
    public String getAuthor(){
        return author;
    }

    /**
     *
     * @return the status of book whether lended or unlended.
     */
    public BookPositionStatus getStatus(){
        return status;
    }

    /**
     * Method of set book's status.
     */
    public void setStatus(BookPositionStatus status) {
        this.status = status;
    }

    /**
     *
     * @return the return date of the book.
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Method of set the return date of the book.
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
