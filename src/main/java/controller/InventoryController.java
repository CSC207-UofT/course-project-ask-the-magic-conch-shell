package controller;

import Book.Book;
import Book.BookManager;
import Book.Book_position_status;

import java.time.LocalDate;


public class InventoryController {

    public void add_book_to_inventory(int book_id, String book_name, String ISBN, LocalDate publishDate, String author){
        //generate a non_repeated book_id.
        Book a = new Book(book_id, book_name, ISBN, publishDate, author);
        BookManager.addBook(a);
    }

    public boolean delete_book_from_inventory(int book_id){
        return BookManager.deleteBook(book_id);

    }
}
