package com.bookSystem.controller;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.Student;

import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.useCase.IDBbookManager;
import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
@RequestMapping("info")
public class accountInfoController {

    /**
     * Controller class that shows student's account information.
     */


    @Autowired
    private IUserLoginManager ulm;

    @Autowired
    private IDBbookManager bm;

    @Autowired
    private IMongoDBBookMethods mbm;


    /**
     * Show student's account info on the slide bar
     * @param model for Spring boot
     * @return "studentInfo" page
     */
    @GetMapping
    public String loadInfo(Model model){
        Student s = ulm.getCurrentStudent();
        String username = s.getUsername();

        int credit = s.getCreditScore();

        model.addAttribute("username", username);
        model.addAttribute("credit", credit);
        ArrayList<Integer> lst = s.getCurrentBorrowingRecords();
        ArrayList<Book> lst2 = new ArrayList<>();

        for (Integer bookID : lst) {
            lst2.add(bm.searchBookByID(bookID, mbm));
        }
        model.addAttribute("record", lst2);
        return "studentInfo";
    }


    }


