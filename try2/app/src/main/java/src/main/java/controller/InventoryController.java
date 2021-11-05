package src.main.java.controller;

import Book.Book;
import Book.BookManager;

import java.time.LocalDate;


public class InventoryController {

    public void add_book_to_inventory(int bookID, String bookName, String ISBN, LocalDate publishDate, String author){
        //generate a non_repeated bookID.
        Book a = new Book(bookID, bookName, ISBN, publishDate, author);
        BookManager.addBook(a);
    }

    public boolean delete_book_from_inventory(int bookID){
        return BookManager.deleteBook(bookID);

    }
}
