package com.bookSystem.controller;


import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.useCase.IDBbookManager;
import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("extend")
public class extendReturnDateController {

    @Autowired
    private IUserLoginManager ulm;

    @Autowired
    private IDBbookManager bm;

    @Autowired
    private IMongoDBBookMethods mbm;

    @GetMapping
    public String loadExtend() {


        return "extendReturnDate";
    }




    @PostMapping
    public String extendDate(@RequestParam("bookidToExtend") int book_id, Model model){
        if(ulm.getCurrentStudent().getCreditScore() >=90 ){
            bm.changeReturnDate(book_id, LocalDate.now().plusDays(7), mbm);
            model.addAttribute("message", "Your return date is extended to"+
                    LocalDate.now().plusDays(7));}

        else{
            model.addAttribute("message", "Sorry, your credit score is not high enough to" +
                    "extend return date");

        }

        return "extendReturnDate";




    }

}
