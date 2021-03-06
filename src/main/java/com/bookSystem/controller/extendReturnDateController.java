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


@Controller
@RequestMapping("extend")
public class extendReturnDateController {

    /**
     * Controller that extend return date of a book for the student.
     */

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


    /**
     * Method that extend return date of a book for the student.
     * @param book_id id of the book
     * @param model for Spring boot
     * @return "extendReturnDate" page
     */
    @PostMapping
    public String extendDate(@RequestParam("bookidToExtend") int book_id, Model model){
        if(ulm.getCurrentStudent().getCreditScore() >=80 ){

            bm.changeReturnDate(book_id, bm.checkReturnDate(book_id, mbm).plusDays(7) , mbm);
            model.addAttribute("message", "Your return date is extended to"+
                    bm.checkReturnDate(book_id, mbm));
        }

        else{
            model.addAttribute("message", "Sorry, your credit score is not high enough to" +
                    "extend return date");

        }

        return "extendReturnDate";




    }

}
