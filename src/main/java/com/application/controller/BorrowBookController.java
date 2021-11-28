package com.application.controller;


import com.application.Entity.Book.Book;
import com.application.MongoDBGateway.IMongoDBBookMethods;
import com.application.MongoDBGateway.IMongoDBStudentMethods;
import com.application.MongoDBGateway.MongoDBBookMethods;
import com.application.MongoDBGateway.MongoDBStudentMethods;
import com.application.UseCase.*;


import java.time.LocalDate;
import java.util.ArrayList;


public class BorrowBookController {

    /**
     *
     * @param ISBN ISBN requested for searching
     * @return a list of book ids that has this specific ISBN
     */
    public ArrayList<Integer> searchBook_by_ISBN(String ISBN){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByISBN(ISBN, bm);
    }

    /**
     *
     * @param bookID book id requested for searching
     * @return a book with this unique book id
     */
    public Book searchBook_by_ID(int bookID){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByID(bookID, bm);

    }

    /**
     *
     * @param author author requested for searching
     * @return a list of book ids written by this author
     */
    public ArrayList<Integer> searchBook_by_author(String author){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByAuthor(author, bm);
    }

    /**
     *
     * @param type book type requested for searching
     * @return a list of book ids of this book type
     */
    public ArrayList<Integer> searchBook_by_type(String type){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByType(type, bm);

    }

    /**
     *
     * @param book_id id of the book wish to be borrowed
     * @param curr_user the current logged-in user
     * @return return true is the book is successfully borrowed, false otherwise
     */
    public boolean borrowBook(int book_id, UserLoginManager curr_user){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        IMongoDBStudentMethods sm = new MongoDBStudentMethods();
        boolean b1 = curr_user.BorrowedBookAmount() <= 5;
        if (b1){
            return b.changBookStatus(book_id, BookPositionStatus.LENDED, bm);
        }
        else {return false;}

    }

//    public void borrowBook(int bookID, String username){
//
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
//
//
//    }

    /**
     *
     * @param bookID id of the book that student wish to extend return deadline for
     * @param number_of_days the number of days the student wish to extend the return date
     * @param username username of the student
     * @return true is the book return date is extended, false if the student does not meet the criteria to extend
     * return deadline
     */
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
