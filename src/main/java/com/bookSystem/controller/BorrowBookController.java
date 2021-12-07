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


import java.util.ArrayList;

@Controller
@RequestMapping("studentBorrowBook")
public class BorrowBookController {

    /**
     * BorrowBook controller that allows students to add the book they want to borrow into a shopping cart and borrow
     * all of them at once.
     */

    @Autowired
    private IDBbookManager bookManager;

    @Autowired
    private IMongoDBBookMethods bookMethods;


    @Autowired
    private IUserLoginManager ulm;

    @GetMapping
    public String loadBorrow() {


        return "studentBorrowBook";
    }

    /**
     * Method that takes a bookID and place the corresponding book in to the shopping cart.
     * @param bookid book's id
     * @param model for Spring boot
     * @return "studentBorrowBook" page
     */
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

    /**
     * Method that borrows all the books in to the shopping cart for student and gives them the result that which
     * books are borrowed successfully and which are not shown on the webpage.
     * @param model for Spring boot
     * @return "studentBorrowBook" page
     */
    @PostMapping("/borrowAll")
    public String borrowAll(Model model){
        ArrayList<Book> books = ulm.getBookList();
        ArrayList<Boolean> status = ulm.placeOrders();
        ArrayList<String> strlst = new ArrayList<>();
        int i = 0;
        for (Boolean bool : status){
            String str;
            if (bool){
                str = "The book with id " + books.get(i).getBookID() + " has been successfully borrowed!";
            }else{
                str = "The book with id " + books.get(i).getBookID() + " can not be borrowed.";
            }
            strlst.add(str);
            i += 1;
        }

    model.addAttribute("messageList", strlst);
    return "studentBorrowBook";}



}
