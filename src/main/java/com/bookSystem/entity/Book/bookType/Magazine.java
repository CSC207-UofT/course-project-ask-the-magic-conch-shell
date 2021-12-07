package com.bookSystem.entity.Book.bookType;

import com.bookSystem.entity.Book.Book;

import java.time.LocalDate;

public class magazine extends Book {

    final private String seriesName; // Namely, the sub-name of the magazine that focus on a more specific topic.
    final private String magazineCategory;


    public magazine(int bookID, String bookName, String ISBN, LocalDate publishDate, String author,
                    String series_name, String category, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.seriesName = series_name;
        this.magazineCategory = category;
    }

    public String getSeriesName(){ return this.seriesName; }

    public String getCategory(){ return this.magazineCategory; }
}
