package UseCase;

import Book.Book;
import Book.subclasses.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Manager all Book. Responsible for adding, deleting, searching book,
 * checking and changing return date and book status.
 */

public class BookManager {

    public static ArrayList<Book> allBooks;
    public static ArrayList<Magazine> allMagazine;
    public static ArrayList<Literature> allLit;
    public static ArrayList<Dictionary> allDic;
    public static ArrayList<ResearchPaper> allResearch;
    public static ArrayList<Textbook> allTextBook;


    public BookManager() {
    }

    /**
     * Adds an instance of Book to the overall list of Books (allBooks)
     * @param book a book
     */

    public static void addBook(Book book) {allBooks.add(book);
    }

    /**
     * Deletes an instance of Book from the overall list of Books by its book ID
     * @param bookID book ID
     * @return true if the book has been successfully removed, false otherwise
     */

    public static boolean deleteBook(int bookID) {
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                allBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    /**
     * Search a book by its ISBN
     * @param book_ISBN a book's ISBN
     * @return a list of book ids that has the same ISBN as the input book ISBN
     */

    public ArrayList<Integer> searchBook(String book_ISBN) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Book book : allBooks) {
            if (Objects.equals(book.getISBN(), book_ISBN)) {
                ids.add(book.getBookID());
            }
        }
        return ids;
    }

    /**
     * search books by its author. Return a list of books that are written by author_name
     * @param author_name author name
     * @return a hashmap of book names and their corresponding ISBNs
     */

    public HashMap<String, String> searchByAuthor(String author_name) {
        HashMap<String, String> authors = new HashMap<>();
        for (Book book : allBooks) {
            if (Objects.equals(book.getAuthor(), author_name)){
                authors.put(book.getBookName(), book.getISBN());
            }
        }
        return authors;
    }

    /**
     * Search books by their categories (Dictionary, Literature, Magazine, ResearchPaper,
     * Textbook)
     * @param book_type book category
     * @return a hashmap (BookName and its corresponding ISBN) of books that belong
     * to input book_type category.
     */

    public HashMap<String, String> searchByType(String book_type){
        HashMap<String, String> books = new HashMap<>();
        switch(book_type){
            case "Dictionary":
                for (Dictionary dictionary: allDic){
                books.put(dictionary.getBookName(), dictionary.getISBN());}
                break;

            case "Literature":
                for (Literature literature: allLit){
                    books.put(literature.getBookName(), literature.getISBN());}
                    break;

            case "Magazine":
                for (Magazine magazine1: allMagazine){
                    books.put(magazine1.getBookName(), magazine1.getISBN());}
                    break;

            case "ResearchPaper":
                for (ResearchPaper researchPaper: allResearch){
                    books.put(researchPaper.getBookName(), researchPaper.getISBN());}
                    break;

            case "Textbook":
                for (Textbook textbook: allTextBook){
                    books.put(textbook.getBookName(), textbook.getISBN());
                    break;
                }
        }
        return books;
    }

    /**
     * check inventory size by ISBN
     * @param book_ISBN book ISBN
     * @return an integer indicating inventory size of the corresponding ISBN
     */

    public int checkInventory(String book_ISBN) {
        ArrayList<Integer> book_searched = searchBook(book_ISBN);
        ArrayList<Book> book_unlended = new ArrayList<>();
        for(int id : book_searched){
            for (Book b : allBooks){
                if(b.getBookID() == id){
                    if(b.getStatus() == BookPositionStatus.UNLENDED){
                        book_unlended.add(b);
                    }
                }
            }

        }
        return book_unlended.size();
    }

    /**
     * To check return date of book with id bookID
     * @param bookID book ID
     * @return LocalDate of the return date of a book with ID bookID
     */


    public LocalDate checkReturnDate(int bookID) {
        LocalDate d = null;
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                d = book.getReturnDate();
            }
        }
        return d;
    }

    /**
     * To modify the return date of book with id bookID to desire_date
     * @param bookID book ID
     * @param desire_date new return date
     */

    public void changeReturnDate(int bookID, LocalDate desire_date){
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                book.setReturnDate(desire_date);
            }
        }
    }

    /**
     * To change the status of a book with id bookID to a new status
     * @param bookID book ID
     * @param status book Status
     */

    public void changBookStatus(int bookID, BookPositionStatus status){
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                book.setStatus(status);
            }
        }
    }




}
