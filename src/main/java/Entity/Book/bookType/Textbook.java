package Entity.Book.bookType;

import Entity.Book.Book;

import java.time.LocalDate;

public class Textbook extends Book {

    final private String subject;

    public Textbook(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String subject, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.subject = subject;
    }

    public String getSubject(){ return this.subject; }
}
