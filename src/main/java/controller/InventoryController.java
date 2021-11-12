package controller;

import Book.Book;
import UseCase.BookManager;

import java.time.LocalDate;


public class InventoryController {

    public void addBookToInventory(int bookID, String bookName, String ISBN, LocalDate publishDate, String author, String type){
        //generate a non_repeated bookID.
        Book a = new Book(bookID, bookName, ISBN, publishDate, author, type);
        BookManager.addBook(a);
    }

    public boolean deleteBookFromInventory(int bookID){
        return BookManager.deleteBook(bookID);

    }
}
