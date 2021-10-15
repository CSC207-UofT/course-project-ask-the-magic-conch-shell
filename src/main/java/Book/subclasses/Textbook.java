package Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class Textbook extends Book {
    final private String subject;

    public Textbook(int book_id, String book_name, String ISBN, LocalDate publishDate, String author, String subject) {
        super(book_id, book_name, ISBN, publishDate, author);
        this.subject = subject;
    }

    public String getSubject(){ return subject; }
}
