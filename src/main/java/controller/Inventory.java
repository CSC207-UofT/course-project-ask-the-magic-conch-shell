package controller;

import Book_package.Book;
import Book_package.Book_position_status;

import java.time.LocalDate;
import java.util.ArrayList;


public class Inventory {
    public ArrayList<Book> all_books;

    public void add_book_to_inventory(int book_id, String book_name, String ISBN, LocalDate publishDate, String author,
                        Book_position_status status, LocalDate returnDate){
        all_books.add(new Book(book_id, book_name, ISBN, publishDate, author, status, returnDate));
    }

    public boolean delete_book_from_inventory(int book_id){
        for (Book book: all_books){
            if (book.getBook_id() == book_id){
                all_books.remove(book);
                return true;
            }
        }
        return false;
    }
}
