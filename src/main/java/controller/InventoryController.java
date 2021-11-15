package controller;

import Book.Book;
import MongoDBGateway.IMongoDBBookMethods;
import MongoDBGateway.MongoDBBookMethods;
import UseCase.DBbookManager;
import UseCase.IDBbookManager;

import java.time.LocalDate;


public class InventoryController {

    public void addBookToInventory(int bookID, String bookName, String ISBN, LocalDate publishDate,
                                   String author, String type){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        Book book = new Book(bookID, bookName, ISBN, publishDate, author, type);
        b.addBook(book, bm);

    }


    public void deleteBookFromInventory(int bookID) {
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        b.deleteBook(bookID, bm);


    }}
