package com.bookSystem.entity.Book.bookType;

import com.bookSystem.entity.Book.Book;

import java.time.LocalDate;

public class dictionary extends Book {

    /* The language that we use English to interpret/translate. */
    final private String language;

    public dictionary(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String language, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.language = language;
    }

    public String getLanguage(){ return this.language; }
}
