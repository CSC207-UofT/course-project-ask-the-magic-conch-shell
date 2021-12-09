package com.bookSystem.mongoDBGateway;

import com.bookSystem.useCase.BookPositionStatus;


import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Interface for methods in MongoDBBookMethods.
 */
public interface IMongoDBBookMethods {



    void updateMagazine(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String seriesname, String category);

    void updateRearchPaper(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerstatus);

    void updateDictionary(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language);

    void updateLiterature(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String period);

    void updateTextbook(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String subject);

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
