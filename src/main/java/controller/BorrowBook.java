package controller;
import java.util.ArrayList;
import Book_package.Book;

import java.util.Objects;


public class BorrowBook {
    public ArrayList<Book_package.Book> all_books;

    public Book search_book(int book_id){
        for (Book book: all_books){
            if (book.getBook_id() == book_id){
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> search_book(String ISBN) {
        ArrayList<Book> info = new ArrayList<>();
        for (Book book : all_books) {
            if (book.getISBN() == ISBN) {
                info.add(book);
                return info;
            }
        }
        return null;
    }

    public boolean borrow_book(int book_id){
        /**
         * if the student is in the system
         * if the book is available
         * if the student has enough credit to borrow:
         ---------------
         < 10 return false
         >= 80 && currently own < 5 books
         >= 50 && currently own < 4 books
         >= 10 && currently own 0
         */



    }


    public boolean extend_return_date(int book_id, int number_of_days){
        /**
         check student's credit score
         >= 50 return false
         */

    }
}
