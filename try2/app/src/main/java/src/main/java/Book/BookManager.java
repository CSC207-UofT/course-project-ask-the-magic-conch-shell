package src.main.java.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class BookManager {

    public static ArrayList<Book> all_books;

    public BookManager() {
    }

    public static void addBook(Book book) { all_books.add(book);
    }

    public static boolean deleteBook(int bookID) {
        for (Book book : all_books) {
            if (book.getBookID() == bookID) {
                all_books.remove(book);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> searchBook(String book_ISBN) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Book book : all_books) {
            if (Objects.equals(book.getISBN(), book_ISBN)) {
                ids.add(book.getBookID());
            }
        }
        return ids;
    }


    public int checkInventory(String book_ISBN) {
        ArrayList<Integer> book_searched = searchBook(book_ISBN);
        ArrayList<Book> book_unlended = new ArrayList<>();
        for(int id : book_searched){
            for (Book b : all_books){
                if(b.getBookID() == id){
                    if(b.getStatus() == BookPositionStatus.UNLENDED){
                        book_unlended.add(b);
                    }
                }
            }

        }
        return book_unlended.size();
    }


    public LocalDate checkReturnDate(int bookID) {
        LocalDate d = null;
        for (Book book : all_books) {
            if (book.getBookID() == bookID) {
                d = book.getReturnDate();
            }
        }
        return d;
    }

    public void changeReturnDate(int bookID, LocalDate desire_date){
        for (Book book : all_books) {
            if (book.getBookID() == bookID) {
                book.setReturnDate(desire_date);
            }
        }
    }

    public void changBookStatus(int bookID, BookPositionStatus status){
        for (Book book : all_books) {
            if (book.getBookID() == bookID) {
                book.setStatus(status);
            }
        }
    }




}
