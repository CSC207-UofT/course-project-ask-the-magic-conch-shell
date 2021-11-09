package Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class Magazine extends Book {
    final private String series_name;
    final private String magazineCategory;


    public Magazine(int bookID, String bookName, String ISBN, LocalDate publishDate, String author,
                    String series_name, String category) {
        super(bookID, bookName, ISBN, publishDate, author);
        this.series_name = series_name;
        this.magazineCategory = category;
    }

    public String getSeries_name(){ return series_name; }

    public String getCategory(){ return magazineCategory; }
}
