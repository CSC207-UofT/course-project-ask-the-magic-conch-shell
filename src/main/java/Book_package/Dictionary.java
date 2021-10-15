package Book_package;

import java.time.LocalDate;

public class Dictionary extends Book{
    final private String language;

    public Dictionary(int book_id, String book_name, String ISBN, LocalDate publishDate, String author,
                    Book_position_status status, LocalDate returnDate, String language) {
        super(book_id, book_name, ISBN, publishDate, author, status, returnDate);
        this.language = language;
    }

    public String getLanguage(){ return language; }
}
