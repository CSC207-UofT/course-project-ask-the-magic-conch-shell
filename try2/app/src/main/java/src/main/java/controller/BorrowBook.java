package src.main.java.controller;


public class BorrowBook {

    public void search_book(String ISBN){
        /* Return ArrayList<Book>
        An arraylist of book
         */

    }
    public void search_book(int bookID){
        /* Return Book

         */

    }

    public void borrow_book(String ISBN){
        /* Return a hashmap of <key: int bookID, value: BookPositionStatus> which all books in
        the hashmap share the same ISBN

         */

    }

    public void borrow_book(int bookID, String username){
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

    }

    public void extend_return_date(int bookID, int number_of_days, String username){
        /*
        if valid bookID:
            if user exists & credit score qualified to extend -> print("Extended number_of_day days")
            else print("Unable to extend")

         */


    }
}
