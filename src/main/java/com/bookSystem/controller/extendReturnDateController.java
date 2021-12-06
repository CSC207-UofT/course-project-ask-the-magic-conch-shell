package com.bookSystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("extend")
public class extendReturnDateController {

    @GetMapping
    public String loadExtend() {


        return "extendReturnDate";
    }




    @PostMapping
    public String extendDate(@RequestParam("bookidToExtend") int book_id){
        /* to be implemented*/
        return "extendReturnDate";




    }

}
