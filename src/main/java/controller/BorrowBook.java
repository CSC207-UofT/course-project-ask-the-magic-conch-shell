package controller;


import Book.Book;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class BorrowBook {

    @GetMapping("/api/book")
    public ArrayList<Book> searchBook(String ISBN){
        /* Return ArrayList<Book>
        An arraylist of book

         */
        //TODO


    }

    @GetMapping("/api/book")
    public ArrayList<Book> searchBook(int bookID){
        /* Return Book

         */
        //TODO
    }

    public void borrowBook(String ISBN){
        /* Return a hashmap of <key: int bookID, value: BookPositionStatus> which all books in
        the hashmap share the same ISBN
    //还要吗， 跟第一个method
一样         */

    }

    @ResponseBody
    public String borrowBook(int bookID, String username){
        /*
        - check if bookID valid
        if invalid print ("invalid book id")
        if valid bookID:
            - check book position status:
                 - if lend print ("Book is unavailable at the moment")
                 - if not lend:
                           - check if user is qualified to borrow book:
                                1. user exists
                                - if not registered print ("User not found")
                                - if exists:
                                    credit score & number of currently borrowed book:
                                    - if credit score < 10 print("Credit Score too low")
                                    - else if check number of book owned & credit score:
                                        - if not satisfied print("Exceed the book limit")
                                        - if satisfied print ("Borrowed") & add the book to user's record.


         */
        //TODO
    }

    @ResponseBody
    public void extendReturnDate(int bookID, int number_of_days, String username){
        /*
        if valid bookID:
            if user exists & credit score qualified to extend -> print("Extended number_of_day days")
            else print("Unable to extend")

         */


    }
}
