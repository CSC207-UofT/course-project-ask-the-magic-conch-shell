package controller;

import Book_package.Book;
import Book_package.BookManager;
import Book_package.Book_position_status;

import java.time.LocalDate;
import java.util.ArrayList;


public class Inventory {

    public void add_book_to_inventory(int book_id, String book_name, String ISBN, LocalDate publishDate, String author,
                        Book_position_status status, LocalDate returnDate){

        Book a = new Book(book_id, book_name, ISBN, publishDate, author, status, returnDate);
        BookManager.addBook(a);
    }

    public boolean delete_book_from_inventory(int book_id){
        for (Book book: BookManager.all_books){
            if (book.getBook_id() == book_id){
                all_books.remove(book);
                return true;
            }
        }
        return false;
    }
}
