package Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class Textbook extends Book {
    final private String subject;

    public Textbook(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String subject) {
        super(bookID, bookName, ISBN, publishDate, author);
        this.subject = subject;
    }

    public String getSubject(){ return subject; }
}
