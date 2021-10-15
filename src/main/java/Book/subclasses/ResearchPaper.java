package Book.subclasses;

import Book.Book;

import java.time.LocalDate;

public class ResearchPaper extends Book {
    final private String subject;
    final private String language;
    final private boolean peer_review_status;

    public ResearchPaper(int book_id, String book_name, String ISBN, LocalDate publishDate, String author,
                         String subject, String language, boolean peer_review_status) {
        super(book_id, book_name, ISBN, publishDate, author);
        this.subject = subject;
        this.language = language;
        this.peer_review_status = peer_review_status;
    }

    public String getSubject(){ return subject; }

    public String getLanguage(){ return language; }

    public boolean get_peer_review_status(){ return peer_review_status; }

}