package com.bookSystem.entity.Book.bookType;

import com.bookSystem.entity.Book.Book;

import java.time.LocalDate;

public class textbook extends Book {

    final private String subject;

    public textbook(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String subject, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.subject = subject;
    }

    public String getSubject(){ return this.subject; }
}
