package controller;

import Entity.Book.Book;
import MongoDBGateway.IMongoDBBookMethods;
import MongoDBGateway.MongoDBBookMethods;
import UseCase.DBbookManager;
import UseCase.IDBbookManager;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class InventoryController {

    /** the parameters are the basic book information needed for the book constructor, create a new book and add to the
     * database
     * @param bookID id of the book
     * @param bookName name of the book
     * @param ISBN ISBN of the book
     * @param publishDate published date of the book
     * @param author author or the editor of the book
     * @param type the book type
     */
    public void addBookToInventory(int bookID, String bookName, String ISBN, LocalDate publishDate,
                                   String author, String type){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        Book book = new Book(bookID, bookName, ISBN, publishDate, author, type);
        b.addBook(book, bm);

    }

    /**
     * when the book is damaged, the book will be removed from our database
     * @param bookID the id of the book wish to be deleted
     */

    public void deleteBookFromInventory(int bookID) {
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        b.deleteBook(bookID, bm);


    }}
