package com.application.MongoDBGateway;

import com.application.UseCase.BookPositionStatus;


import java.time.LocalDate;
import java.util.ArrayList;


public interface IMongoDBBookMethods {
    void update(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String dynamic);


    /**
     **The overloaded update() method provides a way for people to update the book the same as that in the package subclasses in which one don't need to specify the type.
     **/
    void update(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String seriesname, String category);

    void update(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerstatus);

    String getName(String bookID);

    String getISBN(String bookID);

    ArrayList<Integer> searchByISBN(String ISBN);

    ArrayList<Integer> searchByAuthor(String author);

    ArrayList<Integer> searchByType(String type);

    LocalDate getPublishDate(String bookID);

    String getAuthor(String bookID);

    BookPositionStatus getStatus(String bookID);

    LocalDate getReturnDate(String bookID);

    String getType(String bookID);

    String getLanguage(String bookID);

    String getSubject(String bookID);

    String getSeriesName(String bookID);

    String getCategory(String bookID);

    String getPeriod(String bookID);

    Comparable<Boolean> getPeerstatus(String bookID);

    void addBook(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String type);


    void deleteDBBook(String bookID);

    boolean checkBook(String bookID);
}
