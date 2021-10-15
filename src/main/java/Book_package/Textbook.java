package Book_package;

import java.util.Date;

public class Textbook extends Book{
    final private String subject;

    public Textbook(int book_id, String book_name, String ISBN, Date publishDate, String author,
                    Book_position_status status, Date returnDate, String subject) {
        super(book_id, book_name, ISBN, publishDate, author, status, returnDate);
        this.subject = subject;
    }

    public String getSubject(){ return subject; }
}
