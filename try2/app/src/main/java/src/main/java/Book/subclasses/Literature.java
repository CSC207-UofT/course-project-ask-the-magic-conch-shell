package src.main.java.Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class Literature extends Book {
    final private String period;

    public Literature(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String period) {
        super(bookID, bookName, ISBN, publishDate, author);
        this.period = period;
    }

    public String getPeriod(){ return period; }

}
