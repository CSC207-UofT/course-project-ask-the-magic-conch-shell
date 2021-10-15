package Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class Dictionary extends Book {
    final private String language;

    public Dictionary(int book_id, String book_name, String ISBN, LocalDate publishDate, String author, String language) {
        super(book_id, book_name, ISBN, publishDate, author);
        this.language = language;
    }

    public String getLanguage(){ return language; }
}
