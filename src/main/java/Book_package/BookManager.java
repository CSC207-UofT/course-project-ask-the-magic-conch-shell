package Book_package;

import Book_package.Book;
import Book_package.Book_position_status;

import java.util.ArrayList;
import java.util.Date;

public class BookManager {
    public ArrayList<Book> all_books;

    public void BookManager(){
        this.all_books = all_books;
    }

    public void addBook(int book_id, String book_name, String ISBN, Date publishDate, String author, Book_position_status status, Date returnDate){
        all_books.add(new Book(book_id, book_name, ISBN, publishDate, author, status, returnDate));
    }

    public boolean deleteBook(int book_id){
        for (Book book: all_books){
            if (book.getBook_id() == book_id){
                all_books.remove(book);
                return true;
            }
        }
        return false;
    }

    public int searchBook(String book_ISBN){
        for (Book book: all_books){
            if (book.getISBN() == book_ISBN){
                return book.getBook_id();
            }
        }
        return -1;
    }


}
