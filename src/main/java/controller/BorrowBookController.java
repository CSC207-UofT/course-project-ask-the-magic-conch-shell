package controller;


import Book.Book;
import MongoDBGateway.IMongoDBBookMethods;
import MongoDBGateway.IMongoDBStudentMethods;
import MongoDBGateway.MongoDBBookMethods;
import MongoDBGateway.MongoDBStudentMethods;
import UseCase.*;
import User.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class BorrowBookController {

    public ArrayList<Integer> searchBook_by_ISBN(String ISBN){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByISBN(ISBN, bm);
    }
    public Book searchBook_by_ID(int bookID){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByID(bookID, bm);

    }

    public ArrayList<Integer> searchBook_by_author(String author){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByAuthor(author, bm);
    }

    public ArrayList<Integer> searchBook_by_type(String type){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByType(type, bm);

    }


    public boolean borrowBook(int book_id, UserLoginManager curr_user){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        IMongoDBStudentMethods sm = new MongoDBStudentMethods();
        var b1 = curr_user.BorrowedBookAmount() <= 5;
        if (b1){
            return b.changBookStatus(book_id, BookPositionStatus.LENDED, bm);
        }
        else {return false;}

    }

//    public void borrowBook(int bookID, String username){
//        /*
//        - check if bookID valid
//        if invalid print ("invalid book id")
//        if valid bookID:
//            - check book position status:
//                 - if lend print ("Book is unavailable at the moment")
//                 - if not lend:
//                           - check if user is qualified to borrow book:
//                                1. user exists
//                                - if not registered print ("User not found")
//                                - if exists:
//                                    credit score & number of currently borrowed book:
//                                    - if credit score < 10 print("Credit Score too low")
//                                    - else if check number of book owned & credit score:
//                                        - if not satisfied print("Exceed the book limit")
//                                        - if satisfied print ("Borrowed") & add the book to user's record.
//
//
//         */
//
//    }

    public boolean extendReturnDate(int bookID, int number_of_days, String username){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        IMongoDBStudentMethods sm = new MongoDBStudentMethods();
        IDBUserManager um = new DBUserManager();
        if (um.DBGetCreditScore(username, sm) >= 90){
            LocalDate d = b.checkReturnDate(bookID, bm);
            LocalDate new_return_date = d.plusDays(number_of_days);
            b.changeReturnDate(bookID, new_return_date, bm);
            return true;
        }

        else {return false;}




    }
}
