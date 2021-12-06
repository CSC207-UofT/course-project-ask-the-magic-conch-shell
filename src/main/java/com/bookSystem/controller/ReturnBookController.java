package com.bookSystem.controller;

import com.bookSystem.entity.Book.BookCondition;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.mongoDBGateway.MongoDBBookMethods;
import com.bookSystem.useCase.BookPositionStatus;
import com.bookSystem.useCase.DBbookManager;
import com.bookSystem.useCase.IDBUserManager;
import com.bookSystem.useCase.IDBbookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReturnBookController {
    @Controller
    @RequestMapping("staffReturnBook")
    public class returnBookController {

        @Autowired
        private IDBUserManager um;

        @Autowired
        private IMongoDBStaffMethods sam;

        @Autowired
        private IMongoDBStudentMethods sum;

        @Autowired
        private  IDBbookManager bm;

        @Autowired
        private IMongoDBBookMethods mb;

        @GetMapping
        public String loadReturnBook() {

            return "staffReturnBook";
        }


    /**
     * change the book status to unlended if the book condition is GOOD, delete the book if it is determined as DAMAGED
     * @param bookID id of the book wish to be returned
     * @param userName username
     */
    @PostMapping("")
    public String returnBook(@RequestParam("input") int bookID,
                             BookCondition bookCondition,
                             @RequestParam("username") String userName,
                             Model model){
        if (bookCondition == com.bookSystem.entity.Book.BookCondition.GOOD
                && bm.checkReturnDate(bookID, mb).equals(LocalDate.now()) || bm.checkReturnDate(bookID, mb).isBefore(LocalDate.now())){
            bm.changeBookStatus(bookID, BookPositionStatus.UNLENDED, mb);
            if (um.DBGetCreditScore(userName, sum) <= 97){
                um.modifyDBCreditScore(userName, 3, sum);
            }
            else if (um.DBGetCreditScore(userName, sum) > 97){
                um.modifyDBCreditScore(userName, 100-um.DBGetCreditScore(userName, sum), sum);
            }
            model.addAttribute("message", "Return successfully");
            return "staffReturnBook";
        }
        else if (bookCondition == com.bookSystem.entity.Book.BookCondition.DAMAGE
                || bm.checkReturnDate(bookID, mb).isAfter(LocalDate.now())){
            bm.deleteBook(bookID, mb);
            model.addAttribute("message", "The book has been removed from the inventory");
            return "staffReturnBook";
        }
        return "staffReturnBook";
    }
    }
}
