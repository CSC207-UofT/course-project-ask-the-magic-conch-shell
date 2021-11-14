package UseCase;

import Book.Book;
import MongoDBGateway.IMongoDBBookMethods;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IDBbookManager {
    /**
     * Delete a book from the overall database of books.
     *
     * @param bookID id of the book
     * @param bm     inject a mongodb book method interface and get methods from it
     * @return whether the user has been successfully deleted, false otherwise
     */

    boolean deleteBook(int bookID, IMongoDBBookMethods bm);

    boolean addBook(Book book, IMongoDBBookMethods bm);

    Book searchBookByID(int bookID, IMongoDBBookMethods bm);

    ArrayList<Integer> searchBookByISBN(String ISBN, IMongoDBBookMethods bm);

    ArrayList<Integer> searchBookByAuthor(String author, IMongoDBBookMethods bm);

    ArrayList<Integer> searchBookByType(String type, IMongoDBBookMethods bm);

    LocalDate checkReturnDate(int bookID, IMongoDBBookMethods bm);

    boolean changeReturnDate(int bookID, LocalDate desireDate, IMongoDBBookMethods bm);

    boolean changBookStatus(int bookID, BookPositionStatus status, IMongoDBBookMethods bm);
}
