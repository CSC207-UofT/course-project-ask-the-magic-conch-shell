package com.bookSystem.controller;

import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.useCase.BookPositionStatus;
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
import java.util.ArrayList;

@Controller
@RequestMapping("staffReturnBook")

public class returnBookController {

    /**
     * Controller that allows staff to return books for the student.
     */

        @Autowired
        private IDBUserManager um;

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
     * Change the book status to unlended if the book condition is GOOD, delete the book if it is determined as DAMAGED
     * @param bookID id of the book wish to be returned
     * @param userName username
     * @param bookCondition book's condition
     */
    @PostMapping("")
    public String returnBook(@RequestParam("input") int bookID,
                             @RequestParam("book_condition") String bookCondition,
                             @RequestParam("username") String userName,
                             Model model){
        if (bookCondition.equals("good")){
            if (bm.checkReturnDate(bookID, mb).equals(LocalDate.now())
                    || bm.checkReturnDate(bookID, mb).isAfter(LocalDate.now())){
                if (um.DBGetCreditScore(userName, sum) <= 97){
                    um.modifyDBCreditScore(userName, 3, sum);
                    bm.changeBookStatus(bookID, BookPositionStatus.UNLENDED, mb);
                    int a = 0;
                    ArrayList<Integer> newBR = um.DBGetBorrowingRecord(userName, sum);
                    while (a < newBR.size()){
                        if (newBR.get(a) == bookID){
                            newBR.remove(a);
                        }
                        a += 1;
                    }
                    um.studentDBModifyBorrowRecord(userName, newBR, sum);
                    model.addAttribute("message", "Return successfully");
                    return "staffReturnBook";
                }
                else if (um.DBGetCreditScore(userName, sum) > 97){
                    um.modifyDBCreditScore(userName, 100-um.DBGetCreditScore(userName, sum), sum);
                    bm.changeBookStatus(bookID, BookPositionStatus.UNLENDED, mb);
                    int a = 0;
                    ArrayList<Integer> newBR = um.DBGetBorrowingRecord(userName, sum);
                    while (a < newBR.size()){
                        if (newBR.get(a) == bookID){
                            newBR.remove(a);
                        }
                        a += 1;
                    }
                    um.studentDBModifyBorrowRecord(userName, newBR, sum);
                    model.addAttribute("message", "Return successfully");
                    return "staffReturnBook";
                }

                else if( bm.checkReturnDate(bookID, mb).isBefore(LocalDate.now())){
                    if (um.DBGetCreditScore(userName, sum) >= 5){
                        um.modifyDBCreditScore(userName, -5, sum);
                        bm.changeBookStatus(bookID, BookPositionStatus.UNLENDED, mb);
                        int a = 0;
                        ArrayList<Integer> newBR = um.DBGetBorrowingRecord(userName, sum);
                        while (a < newBR.size()){
                            if (newBR.get(a) == bookID){
                                newBR.remove(a);
                            }
                            a += 1;
                        }
                        um.studentDBModifyBorrowRecord(userName, newBR, sum);
                        model.addAttribute("message", "Return successfully");
                        return "staffReturnBook";
                    }
                    else if (um.DBGetCreditScore(userName, sum) < 5){
                        um.modifyDBCreditScore(userName, um.DBGetCreditScore(userName, sum), sum);
                        bm.changeBookStatus(bookID, BookPositionStatus.UNLENDED, mb);
                        int a = 0;
                        ArrayList<Integer> newBR = um.DBGetBorrowingRecord(userName, sum);
                        while (a < newBR.size()){
                            if (newBR.get(a) == bookID){
                                newBR.remove(a);
                            }
                            a += 1;
                        }
                        um.studentDBModifyBorrowRecord(userName, newBR, sum);
                        model.addAttribute("message", "Return successfully");
                        return "staffReturnBook";
                    }
                }

            }
            }

        else if(bookCondition.equals("damaged")){
            bm.deleteBook(bookID, mb);
            model.addAttribute("message", "The book has been removed from the inventory");
            return "staffReturnBook";
        }
        return "staffReturnBook";
    }

}
