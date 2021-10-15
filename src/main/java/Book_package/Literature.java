package Book_package;

import java.time.LocalDate;

public class Literature extends Book {
    final private String period;

    public Literature(int book_id, String book_name, String ISBN, LocalDate publishDate, String author,
                    Book_position_status status, LocalDate returnDate, String period) {
        super(book_id, book_name, ISBN, publishDate, author, status, returnDate);
        this.period =period;
    }

    public String getPeriod(){ return period; }

}