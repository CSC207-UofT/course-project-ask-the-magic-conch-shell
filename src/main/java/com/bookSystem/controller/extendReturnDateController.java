package com.bookSystem.controller;


import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("extend")
public class extendReturnDateController {

    @Autowired
    private IUserLoginManager ulm;

    @GetMapping
    public String loadExtend() {


        return "extendReturnDate";
    }




    @PostMapping
    public String extendDate(@RequestParam("bookidToExtend") int book_id){
        if(ulm.getCurrentStudent().getCreditScore() >=90 ){


        }

        return "extendReturnDate";




    }

}
