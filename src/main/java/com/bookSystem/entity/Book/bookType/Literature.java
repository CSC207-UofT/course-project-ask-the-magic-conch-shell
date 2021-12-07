package com.bookSystem.entity.Book.bookType;

import com.bookSystem.entity.Book.Book;

import java.time.LocalDate;

public class literature extends Book {

    /*
     * The period (historical background) in which a given literature was written provides great
     * information for readers to refer.
     */
    final private String period;

    public literature(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String period, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.period = period;
    }

    public String getPeriod(){ return this.period; }

}
