package com.bookSystem.controller;


import com.bookSystem.entity.Book.Book;
import com.bookSystem.mongoDBGateway.*;
import com.bookSystem.useCase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("studentBorrowBook")
public class BorrowBookController {

    @Autowired
    private IDBUserManager um;

    @Autowired
    private IDBbookManager bookManager;

    @Autowired
    private IMongoDBBookMethods bookMethods;

    @Autowired
    private IMongoDBStudentMethods sm;

    @Autowired
    private IMongoDBStaffMethods sam;

    @Autowired
    private IUserLoginManager ulm;

    @GetMapping
    public String loadBorrow() {


        return "studentBorrowBook";
    }

    @PostMapping("")
    public String addBooktoCart(@RequestParam("bookId") String bookid, Model model){

        if (bookMethods.checkBook(bookid)){
            Book book = bookManager.searchBookByID(Integer.parseInt(bookid), bookMethods);
            Order order = new Order(book, ulm.getCurrentStudent());
            ulm.addToCart(order);
            ulm.addToBookList(book);
            ArrayList<Book> bookList = ulm.getBookList();
            model.addAttribute("cart", bookList);
            model.addAttribute("message", "The book has been added to your cart!");
        }else{
            model.addAttribute("message", "The book does not exist!");

        }

        return "studentBorrowBook";
    }


    @PostMapping("/borrowAll")
    public String borrowAll(Model model){
        ArrayList<Book> books = ulm.getBookList();
        ArrayList<Boolean> status = ulm.placeOrders();
        ArrayList<String> strlst = new ArrayList<>();
        int i = 0;
        for (Boolean bool : status){
            String str;
            if (bool){
                str = "The book" + books.get(i).getBookID() + "has been successfully borrowed!";
            }else{
                str = "The book" + books.get(i).getBookID() + "can not be borrowed.";
            }
            strlst.add(str);
            i += 1;
        }

    model.addAttribute("message", strlst);
    return "studentBorrowBook";}






    /**
     *
     * @param ISBN ISBN requested for searching
     * @return a list of book ids that has this specific ISBN
     */
    public ArrayList<Integer> searchBook_by_ISBN(String ISBN){
        DBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByISBN(ISBN, bm);
    }

    /**
     *
     * @param bookID book id requested for searching
     * @return a book with this unique book id
     */
    public Book searchBook_by_ID(int bookID){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByID(bookID, bm);

    }

    /**
     *
     * @param author author requested for searching
     * @return a list of book ids written by this author
     */
    public ArrayList<Integer> searchBook_by_author(String author){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByAuthor(author, bm);
    }

    /**
     *
     * @param type book type requested for searching
     * @return a list of book ids of this book type
     */
    public ArrayList<Integer> searchBook_by_type(String type){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        return b.searchBookByType(type, bm);

    }

    /**
     *
     * @param book_id id of the book wish to be borrowed
     * @param curr_user the current logged-in user
     * @return return true is the book is successfully borrowed, false otherwise
     */
    public boolean borrowBook(int book_id, UserLoginManager curr_user){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        IMongoDBStudentMethods sm = new MongoDBStudentMethods();
        var b1 = curr_user.borrowedBookAmount() <= 5;
        if (b1){
            return b.changeBookStatus(book_id, BookPositionStatus.LENDED, bm);
        }
        else {return false;}

    }

//    public void borrowBook(int bookID, String username){
//
//        - check if bookID valid
//        if invalid print ("invalid book id")
//        if valid bookID:
//            - check book position status:
//                 - if lend print ("Book is unavailable at the moment")
//                 - if not lend:
//                           - check if user is qualified to borrow book:
//                                1. user exists
//                                - if not registered print ("User not found")
//                                - if exists:
//                                    credit score & number of currently borrowed book:
//                                    - if credit score < 10 print("Credit Score too low")
//                                    - else if check number of book owned & credit score:
//                                        - if not satisfied print("Exceed the book limit")
//                                        - if satisfied print ("Borrowed") & add the book to user's record.
//
//
//
//
//    }

    /**
     *
     * @param bookID id of the book that student wish to extend return deadline for
     * @param number_of_days the number of days the student wish to extend the return date
     * @param username username of the student
     * @return true is the book return date is extended, false if the student does not meet the criteria to extend
     * return deadline
     */
    public boolean extendReturnDate(int bookID, int number_of_days, String username){
        IDBbookManager b = new DBbookManager();
        IMongoDBBookMethods bm = new MongoDBBookMethods();
        IMongoDBStudentMethods sm = new MongoDBStudentMethods();
        IDBUserManager um = new DBUserManager();
        if (um.DBGetCreditScore(username, sm) >= 90){
            LocalDate d = b.checkReturnDate(bookID, bm);
            LocalDate new_return_date = d.plusDays(number_of_days);
            b.changeReturnDate(bookID, new_return_date, bm);
            return true;
        }

        else {return false;}




    }
}
