package Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class Literature extends Book {
    final private String period;

    public Literature(int book_id, String book_name, String ISBN, LocalDate publishDate, String author, String period) {
        super(book_id, book_name, ISBN, publishDate, author);
        this.period = period;
    }

    public String getPeriod(){ return period; }

}
