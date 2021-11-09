package Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class Dictionary extends Book {

    /* The language that we use English to interpret. */
    final private String language;

    public Dictionary(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String language) {
        super(bookID, bookName, ISBN, publishDate, author);
        this.language = language;
    }

    public String getLanguage(){ return language; }
}
