package Entity.Book.bookType;

import Entity.Book.Book;

import java.time.LocalDate;

public class Dictionary extends Book {

    /* The language that we use English to interpret/translate. */
    final private String language;

    public Dictionary(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String language, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.language = language;
    }

    public String getLanguage(){ return this.language; }
}
