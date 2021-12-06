package com.bookSystem.useCase;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IDBbookManager {
    /**
     * Public interface of DBbookManager.
     */

    boolean deleteBook(int bookID, IMongoDBBookMethods bm);

    boolean addBook(Book book, IMongoDBBookMethods bm);

    Book searchBookByID(int bookID, IMongoDBBookMethods bm);

    ArrayList<Integer> searchBookByISBN(String ISBN, IMongoDBBookMethods bm);

    ArrayList<Integer> searchBookByAuthor(String author, IMongoDBBookMethods bm);

    ArrayList<Integer> searchBookByType(String type, IMongoDBBookMethods bm);

    LocalDate checkReturnDate(int bookID, IMongoDBBookMethods bm);

    boolean changeReturnDate(int bookID, LocalDate desireDate, IMongoDBBookMethods bm);

    boolean changeBookStatus(int bookID, BookPositionStatus status, IMongoDBBookMethods bm);

    BookPositionStatus checkBookStatus(int bookID, IMongoDBBookMethods bm);


}


