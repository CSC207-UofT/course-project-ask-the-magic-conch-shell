package controller;

import Book.Book;
import Book.BookManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class InventoryController {

    @PostMapping("/api/book")
    public void addBookToInventory(int bookID, String bookName, String ISBN, LocalDate publishDate, String author){
        //generate a non_repeated bookID.
        Book a = new Book(bookID, bookName, ISBN, publishDate, author);
        BookManager.addBook(a);
    }
    @DeleteMapping("/api/book")
    public boolean deleteBookFromInventory(int bookID){
        return BookManager.deleteBook(bookID);

    }
}
