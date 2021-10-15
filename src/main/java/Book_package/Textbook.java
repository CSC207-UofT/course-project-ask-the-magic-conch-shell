package Book_package;

import java.time.LocalDate;

public class Textbook extends Book{
    final private String subject;

    public Textbook(int book_id, String book_name, String ISBN, LocalDate publishDate, String author,
                    Book_position_status status, LocalDate returnDate, String subject) {
        super(book_id, book_name, ISBN, publishDate, author, status, returnDate);
        this.subject = subject;
    }

    public String getSubject(){ return subject; }
}
