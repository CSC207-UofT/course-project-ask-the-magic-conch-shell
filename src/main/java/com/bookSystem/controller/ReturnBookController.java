package com.bookSystem.controller;

import com.bookSystem.entity.Book.BookCondition;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.mongoDBGateway.MongoDBBookMethods;
import com.bookSystem.useCase.BookPositionStatus;
import com.bookSystem.useCase.DBbookManager;
import com.bookSystem.useCase.IDBbookManager;

public class ReturnBookController {


    /**
     * change the book status to unlended if the book condition is GOOD, delete the book if it is determined as DAMAGED
     * @param bookID id of the book wish to be returned
     * @param BookCondition the physical condition of the book when it is returned
     */
    public void returnBook(int bookID, BookCondition BookCondition){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        if (BookCondition == com.bookSystem.entity.Book.BookCondition.GOOD){
            b.changeBookStatus(bookID, BookPositionStatus.UNLENDED, bm);

        }
        else if (BookCondition == com.bookSystem.entity.Book.BookCondition.DAMAGE){
            b.deleteBook(bookID, bm);
        }

    }}
