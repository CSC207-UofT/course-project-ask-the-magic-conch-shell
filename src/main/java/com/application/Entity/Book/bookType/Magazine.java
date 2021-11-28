package com.application.Entity.Book.bookType;

import com.application.Entity.Book.Book;

import java.time.LocalDate;

public class Magazine extends Book {

    final private String seriesName; // Namely, the sub-name of the magazine that focus on a more specific topic.
    final private String magazineCategory;


    public Magazine(int bookID, String bookName, String ISBN, LocalDate publishDate, String author,
                    String series_name, String category, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.seriesName = series_name;
        this.magazineCategory = category;
    }

    public String getSeriesName(){ return this.seriesName; }

    public String getCategory(){ return this.magazineCategory; }
}
