package com.bookSystem.useCase;

import com.bookSystem.entity.Book.Book;

import com.bookSystem.entity.Book.bookType.*;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

@Component
public class DBbookManager implements IDBbookManager {

    /**
     * Manage all Book in the MongoDB database. Responsible for adding, deleting, searching book,
     * checking all attributes of all types of books and changing return date and book status.
     */

    public DBbookManager() {
    }

    /**
     * Adds a Book to the overall database of Books
     * @param book a book entity
     * @param bm inject a mongodb book method interface and get methods from it
     * @return true if the book does not exist and successfully added, false otherwise
     */

    @Override
    public boolean addBook(Book book, IMongoDBBookMethods bm) {
        String bookID = Integer.toString(book.getBookID());
        if (!bm.checkBook(bookID)){
        String name = book.getBookName();
        String ISBN = book.getISBN();
        String author = book.getAuthor();
        String status = BookPositionStatus.toString(book.getStatus());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String publishDate = dtf.format(book.getPublishDate());
        String returnDate;
        if (book.getReturnDate() != null){
            returnDate = dtf.format(book.getReturnDate());
        }else {
            returnDate = "null";
        }
        String type = book.getType();
        bm.addBook(bookID, name, ISBN, publishDate, author, status, returnDate, type);
        if (Objects.equals(type, "Magazine")){
            String cat = ((Magazine) book).getCategory();
            String ser = ((Magazine) book).getSeriesName();
            bm.updateMagazine(bookID,name,ISBN,publishDate,author,status,returnDate,ser,cat);
        }
/*        if (Objects.equals(type, "Dictionary")){
            String lan = ((dictionary) book).getLanguage();
                bm.updateDictionary(bookID,name,ISBN,publishDate,author,status,returnDate,lan);
            }*/
        if (Objects.equals(type, "Literature")){
            String per = ((Literature) book).getPeriod();
                bm.updateLiterature(bookID,name,ISBN,publishDate,author,status,returnDate,per);
            }
        if (Objects.equals(type, "Textbook")){
            String sub = ((Textbook) book).getSubject();
                bm.updateTextbook(bookID,name,ISBN,publishDate,author,status,returnDate,sub);
            }
        if (Objects.equals(type, "ResearchPaper")){
                String lan = ((ResearchPaper) book).getLanguage();
                boolean sta = ((ResearchPaper) book).getPeerReviewStatus();
                String stastring = Boolean.toString(sta);
                String sub = ((ResearchPaper) book).getSubject();
                bm.updateRearchPaper(bookID,name,ISBN,publishDate,author,status,returnDate,lan,sub, stastring);
            }
        return true;
    }else{
        return false;}
    }


    /**
     * Delete a book from the overall database of books.
     *
     * @param bookID id of the book
     * @param bm     inject a mongodb book method interface and get methods from it
     * @return whether the user has been successfully deleted, false otherwise
     */
    @Override
    public boolean deleteBook(int bookID, IMongoDBBookMethods bm) {
        String bookIDstring = Integer.toString(bookID);
        if (bm.checkBook(bookIDstring)) {
            bm.deleteDBBook(bookIDstring);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Search a book by its ISBN
     * @param bookID a book's ID
     * @param bm inject a mongodb book method interface and get methods from it
     * @return the book that has the input bookID
     */

    @Override
    public Book searchBookByID(int bookID, IMongoDBBookMethods bm) {
        String bookIDstring = Integer.toString(bookID);
        Book book = null;
        if (bm.checkBook(bookIDstring)){
            String name = bm.getName(bookIDstring);
            String author = bm.getAuthor(bookIDstring);
            String isbn = bm.getISBN(bookIDstring);
            LocalDate pd = bm.getPublishDate(bookIDstring);
            String type = bm.getType(bookIDstring);
            BookPositionStatus status = bm.getStatus(bookIDstring);
            LocalDate rd = bm.getReturnDate(bookIDstring);
            book = new Book(bookID, name, isbn, pd, author, type);
            book.setReturnDate(rd);
            book.setStatus(status);

        }

        return book;
    }

    /**
     * Search a book by its ISBN
     * @param ISBN a book's ISBN
     * @param bm inject a mongodb book method interface and get methods from it
     * @return a list of book ids that has the same ISBN as the input book ISBN
     */
    @Override
    public ArrayList<Integer> searchBookByISBN(String ISBN, IMongoDBBookMethods bm) {


        return bm.searchByISBN(ISBN);
    }


    /**
     * Search a book by its author
     * @param author a book's author
     * @param bm inject a mongodb book method interface and get methods from it
     * @return a list of book ids that has the same author as the input book author
     */
    @Override
    public ArrayList<Integer> searchBookByAuthor(String author, IMongoDBBookMethods bm) {

        return bm.searchByAuthor(author);
    }

    /**
     * Search a book by its type
     * @param type a book's type
     * @param bm inject a mongodb book method interface and get methods from it
     * @return a list of book ids that has the same type as the input book type
     */
    @Override
    public ArrayList<Integer> searchBookByType(String type, IMongoDBBookMethods bm) {

        return bm.searchByType(type);
    }

    /**
     * To check status of book in the database with id bookID
     * @param bookID book ID
     * @param bm inject a mongodb book method interface and get methods from it
     * @return status of a book with ID bookID, null if the book is not in the database
     */

    @Override
    public BookPositionStatus checkBookStatus(int bookID, IMongoDBBookMethods bm) {
        String bookIDstring = Integer.toString(bookID);
        if (bm.checkBook(bookIDstring)){
            return bm.getStatus(bookIDstring);}
        else {return null;}
    }


    /**
     * To check return date of book in the database with id bookID
     * @param bookID book ID
     * @param bm inject a mongodb book method interface and get methods from it
     * @return LocalDate of the return date of a book with ID bookID, null if the book is not in the database
     */

    @Override
    public LocalDate checkReturnDate(int bookID, IMongoDBBookMethods bm) {
        String bookIDstring = Integer.toString(bookID);
        if (bm.checkBook(bookIDstring)){
            return bm.getReturnDate(bookIDstring);}
        else {return null;}
    }

    /**
     * To modify the return date of book with id bookID to desireDate
     * @param bookID book ID
     * @param desireDate new return date
     * @param bm inject a mongodb book method interface and get methods from it
     * @return true if the return date is successfully changed, false otherwise
     */

    @Override
    public boolean changeReturnDate(int bookID, LocalDate desireDate, IMongoDBBookMethods bm){
        String bookIDstring = Integer.toString(bookID);
        if (bm.checkBook(bookIDstring)){
            String name = bm.getName(bookIDstring);
            String ISBN = bm.getISBN(bookIDstring);
            String author = bm.getAuthor(bookIDstring);
            String status = BookPositionStatus.toString(bm.getStatus(bookIDstring));
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String publishDate = dtf.format(bm.getPublishDate(bookIDstring));
            String newReturnDate = dtf.format(desireDate);

            String type = bm.getType(bookIDstring);
            if (Objects.equals(type, "Magazine")){
                String ser = bm.getSeriesName(bookIDstring);
                String cat = bm.getCategory(bookIDstring);
                bm.updateMagazine(bookIDstring,name,ISBN,publishDate,author,status,newReturnDate,ser,cat);
            }
            if (Objects.equals(type, "Dictionary")){
                String lan = bm.getLanguage(bookIDstring);
                bm.updateDictionary(bookIDstring,name,ISBN,publishDate,author,status,newReturnDate,lan);
            }
            if (Objects.equals(type, "Literature")){
                String per = bm.getPeriod(bookIDstring);
                bm.updateLiterature(bookIDstring,name,ISBN,publishDate,author,status,newReturnDate,per);
            }
            if (Objects.equals(type, "Textbook")){
                String sub = bm.getSubject(bookIDstring);
                bm.updateTextbook(bookIDstring,name,ISBN,publishDate,author,status,newReturnDate,sub);
            }
            if (Objects.equals(type, "ResearchPaper")){
                String lan = bm.getLanguage(bookIDstring);
                boolean sta = (boolean) bm.getPeerstatus(bookIDstring);
                String stastring = Boolean.toString(sta);
                String sub = bm.getSubject(bookIDstring);
                bm.updateRearchPaper(bookIDstring,name,ISBN,publishDate,author,status,newReturnDate,lan,sub,stastring);
            }
            return true;


        }

        return false;
    }

    /**
     * To change the status of a book with id bookID to a new status
     * @param bookID book ID
     * @param status book Status
     * @param bm inject a mongodb book method interface and get methods from it
     * @return true if the status is successfully changed, false otherwise
     */

    @Override
    public boolean changeBookStatus(int bookID, BookPositionStatus status, IMongoDBBookMethods bm){
        String bookIDstring = Integer.toString(bookID);
        if (bm.checkBook(bookIDstring)){
            String name = bm.getName(bookIDstring);
            String ISBN = bm.getISBN(bookIDstring);
            String author = bm.getAuthor(bookIDstring);
            String newStatus = BookPositionStatus.toString(status);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String publishDate = dtf.format(bm.getPublishDate(bookIDstring));
            String returnDate;
            if (newStatus.equals("lended")) {
                returnDate = dtf.format(LocalDate.now().plusDays(30));
            }else{
                returnDate = "null";
            }
            String type = bm.getType(bookIDstring);
            if (Objects.equals(type, "Magazine")){
                String ser = bm.getSeriesName(bookIDstring);
                String cat = bm.getCategory(bookIDstring);
                bm.updateMagazine(bookIDstring,name,ISBN,publishDate,author,newStatus,returnDate,ser,cat);
            }
            if (Objects.equals(type, "Dictionary")){
                String lan = bm.getLanguage(bookIDstring);
                bm.updateDictionary(bookIDstring,name,ISBN,publishDate,author,newStatus,returnDate,lan);
            }
            if (Objects.equals(type, "Literature")){
                String per = bm.getPeriod(bookIDstring);
                bm.updateLiterature(bookIDstring,name,ISBN,publishDate,author,newStatus,returnDate,per);
            }
            if (Objects.equals(type, "Textbook")){
                String sub = bm.getSubject(bookIDstring);
                bm.updateTextbook(bookIDstring,name,ISBN,publishDate,author,newStatus,returnDate,sub);
            }
            if (Objects.equals(type, "ResearchPaper")){
                String lan = bm.getLanguage(bookIDstring);
                boolean sta = (boolean) bm.getPeerstatus(bookIDstring);
                String stastring = Boolean.toString(sta);
                String sub = bm.getSubject(bookIDstring);
                bm.updateRearchPaper(bookIDstring,name,ISBN,publishDate,author,newStatus,returnDate,lan,sub,stastring);
            }
            return true;
    }
        return false;
    }


//    @Override
//    public void addOrder(Book book, IMongoDBBookMethods bm){
//        String bookIDString = Integer.toString(book.getBookID());
//        if (bm.checkBook(bookIDString)){
//            if (checkBookStatus(book.getBookID(), bm).equals(BookPositionStatus.UNLENDED)) {
//                changeBookStatus(book.getBookID(), BookPositionStatus.LENDED, bm);
//            }
//        }
//    }
//
//    @Override
//    public void deleteOrder(Book book, IMongoDBBookMethods bm){
//        String bookIDString = Integer.toString(book.getBookID());
//        if (bm.checkBook(bookIDString)){
//            if (checkBookStatus(book.getBookID(), bm).equals(BookPositionStatus.LENDED)) {
//                changeBookStatus(book.getBookID(), BookPositionStatus.UNLENDED, bm);
//            }
//        }
//    }



}
