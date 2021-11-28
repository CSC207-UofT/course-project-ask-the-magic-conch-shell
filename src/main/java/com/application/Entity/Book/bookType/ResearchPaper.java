package com.application.Entity.Book.bookType;

import com.application.Entity.Book.Book;

import java.time.LocalDate;

public class ResearchPaper extends Book {

    final private String subject;
    final private String language; //The language in which the paper was written.
    final private boolean peer_review_status;

    public ResearchPaper(int bookID, String bookName, String ISBN, LocalDate publishDate, String author,
                         String subject, String language, boolean peer_review_status, String type) {
        super(bookID, bookName, ISBN, publishDate, author, type);
        this.subject = subject;
        this.language = language;
        this.peer_review_status = peer_review_status;
    }

    public String getSubject(){ return this.subject; }

    public String getLanguage(){ return this.language; }

    public boolean getPeerReviewStatus(){ return this.peer_review_status; }

}
