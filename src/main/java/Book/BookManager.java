package Book;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookManager {

    public static ArrayList<Book> all_books;

    public BookManager() {
    }

    public static void addBook(Book book) { all_books.add(book);
    }

    public static boolean deleteBook(int book_id) {
        for (Book book : all_books) {
            if (book.getBook_id() == book_id) {
                all_books.remove(book);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> searchBook(String book_ISBN) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Book book : all_books) {
            if (book.getISBN() == book_ISBN) {
                ids.add(book.getBook_id());
            }
        }
        return ids;
    }

    public int checkInventory(String book_ISBN) {
        ArrayList<Integer> book_searched = searchBook(book_ISBN);
        ArrayList<Book> book_unlended = new ArrayList<>();
        for(int id : book_searched){
            for (Book b : all_books){
                if(b.getBook_id() == id){
                    if(b.getStatus() == Book_position_status.UNLENDED){
                        book_unlended.add(b);
                    }
                }
            }

        }
        return book_unlended.size();
    }


    public LocalDate checkReturnDate(int book_id) {
        LocalDate d = null;
        for (Book book : all_books) {
            if (book.getBook_id() == book_id) {
                d = book.getReturnDate();
            }
        }
        return d;
    }

    public void changeReturnDate(int book_id, LocalDate desire_date){
        for (Book book : all_books) {
            if (book.getBook_id() == book_id) {
                book.setReturnDate(desire_date);
            }
        }
    }

    public void changBookStatus(int book_id, Book_position_status status){
        for (Book book : all_books) {
            if (book.getBook_id() == book_id) {
                book.setStatus(status);
            }
        }
    }




}
