package controller;

import Book.BookCondition;
import MongoDBGateway.IMongoDBBookMethods;
import MongoDBGateway.IMongoDBStudentMethods;
import MongoDBGateway.MongoDBBookMethods;
import MongoDBGateway.MongoDBStudentMethods;
import UseCase.*;

public class ReturnBookController {



    public void returnBook(int bookID, BookCondition BookCondition){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        if (BookCondition == Book.BookCondition.GOOD){
            b.changBookStatus(bookID, BookPositionStatus.UNLENDED, bm);

        }
        else if (BookCondition == Book.BookCondition.DAMAGE){
            b.deleteBook(bookID, bm);
        }

    }}
