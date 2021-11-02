package controller;

import Book.Book;
import Book.BookManager;

import java.time.LocalDate;


public class InventoryController {

    public void addBookToInventory(int bookID, String bookName, String ISBN, LocalDate publishDate, String author){
        //generate a non_repeated bookID.
        Book a = new Book(bookID, bookName, ISBN, publishDate, author);
        BookManager.addBook(a);
    }

    public boolean deleteBookFromInventory(int bookID){
        return BookManager.deleteBook(bookID);

    }
}
