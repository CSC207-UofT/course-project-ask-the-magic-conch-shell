package controller;

import Book.Book;
import Book.BookManager;
import Book.subclasses.Magazine;

import java.time.LocalDate;


public class InventoryController {

    public void add_book_to_inventory(Book book){
        //generate a non_repeated book_id.

        //BookManager.addBook(book);

    }

    public boolean delete_book_from_inventory(int book_id){
        return BookManager.deleteBook(book_id);

    }
}
