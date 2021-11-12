package Book;

import UseCase.BookPositionStatus;

import java.time.LocalDate;

/**
 * A book with all information including id, name, ISBN, publish date, author, status, return date and type(category).
 */

public class Book {
    /**
     * book id
     */
    private final int bookID;
    /**
     * book name
     */
    private final String bookName;
    /**
     * book ISBN
     */
    private final String ISBN;
    /**
     * book publish date
     */
    private final LocalDate publishDate;
    /**
     * book author
     */
    private final String author;
    /**
     * book status (either LENDED or UNLENDED)
     */
    public BookPositionStatus status;
    /**
     * return date
     */
    public LocalDate returnDate;
    /**
     * book category
     */
    public String type;

    /**
     *
     * @param bookID the book id
     * @param bookName the book name
     * @param ISBN the book ISBN
     * @param publishDate the book publish date
     * @param author the book author
     * @param type the book category
     */

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


    /**
     * To get the book id
     * @return int that indicate bookID of the corresponding book
     */
    public int getBookID(){
        return bookID;
    }

    /**
     * To get the book name
     * @return Strings that indicate bookName of the corresponding book
     */
    public String getBookName(){
        return bookName;
    }

    /**
     * To get the ISBN
     * @return Strings that indicate ISBN of the corresponding book
     */
    public String getISBN(){return ISBN;}

    /**
     * To get the publishing date of a book
     * @return LocalDate of the publishDate of the corresponding book
     */
    public LocalDate getPublishDate(){
        return publishDate;
    }

    /**
     * To get the book author
     * @return Strings that indicate author of the corresponding book
     */
    public String getAuthor(){
        return author;
    }

    /**
     * To get the position status of a book (either LENDED or UNLENDED)
     * @return Strings that indicate the current status of the corresponding book
     */
    public BookPositionStatus getStatus(){
        return status;
    }

    /**
     * To set up a book position status as the input status
     * @param status book position status
     */
    public void setStatus(BookPositionStatus status) {
        this.status = status;}

    /**
     * To get the return date of a book
     * @return LocalDate of returnDate of the corresponding book
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * To set up return date of a book as the input returnDate
     * @param returnDate the return Date
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}

