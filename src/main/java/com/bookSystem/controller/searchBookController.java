package com.bookSystem.controller;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.useCase.IDBUserManager;
import com.bookSystem.useCase.IDBbookManager;
import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("searchBook")

public class searchBookController {

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
    public String loadSearch() {


        return "searchBook";
    }

    @PostMapping("")
    public String searchBook(@RequestParam ("books") String option, @RequestParam ("input") String input, Model model){
        ArrayList<Book> results = new ArrayList<>();
        if (Objects.equals(option, "Book ID")){
            if (bookMethods.checkBook(input)){
                Book book = bookManager.searchBookByID(Integer.parseInt(input),bookMethods);
                results.add(book);
            }

        }else if (Objects.equals(option, "ISBN")){
            ArrayList<Integer> bookIDs;
            bookIDs = bookManager.searchBookByISBN(input,bookMethods);
            for (Integer id : bookIDs){
                results.add(bookManager.searchBookByID(id, bookMethods));
            }
        }else if (Objects.equals(option, "Author")){
            ArrayList<Integer> bookIDs;
            bookIDs = bookManager.searchBookByAuthor(input,bookMethods);
            for (Integer id : bookIDs){
                results.add(bookManager.searchBookByID(id, bookMethods));
            }

        }else{
            ArrayList<Integer> bookIDs;
            bookIDs = bookManager.searchBookByType(input,bookMethods);
            for (Integer id : bookIDs){
                results.add(bookManager.searchBookByID(id, bookMethods));
            }

        }
        model.addAttribute("results", results);
        return "searchBook";

    }


}
