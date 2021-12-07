package com.bookSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("studentReturn")
public class studentReturnBookController {
    /**
     ** The controller that give student the information when they want to return books.
     **/


    @GetMapping
    public String loadStudentReturn() {


        return "studentReturnBook";
    }
}
