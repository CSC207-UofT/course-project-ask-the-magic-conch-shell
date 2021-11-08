package Book;

import Book.subclasses.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class BookManager {

    public static ArrayList<Book> allBooks;
    public static ArrayList<Magazine> allMagazine;
    public static ArrayList<Literature> allLit;
    public static ArrayList<Dictionary> allDic;
    public static ArrayList<ResearchPaper> allResearch;
    public static ArrayList<Textbook> allTextBook;


    public BookManager() {
    }



    public static void addBook(Book book) { allBooks.add(book);
    }

    public static boolean deleteBook(int bookID) {
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                allBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> searchBook(String book_ISBN) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Book book : allBooks) {
            if (Objects.equals(book.getISBN(), book_ISBN)) {
                ids.add(book.getBookID());
            }
        }
        return ids;

    }

    public HashMap<String, String> searchByAuthor(String author_name) {
        HashMap<String, String> authors = new HashMap<>();
        for (Book book : allBooks) {
            if (Objects.equals(book.getAuthor(), author_name)){
                authors.put(book.getBookName(), book.getISBN());
            }
        }
        return authors;
    }


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


    public LocalDate checkReturnDate(int bookID) {
        LocalDate d = null;
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                d = book.getReturnDate();
            }
        }
        return d;
    }

    public void changeReturnDate(int bookID, LocalDate desire_date){
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                book.setReturnDate(desire_date);
            }
        }
    }

    public void changBookStatus(int bookID, BookPositionStatus status){
        for (Book book : allBooks) {
            if (book.getBookID() == bookID) {
                book.setStatus(status);
            }
        }
    }




}
