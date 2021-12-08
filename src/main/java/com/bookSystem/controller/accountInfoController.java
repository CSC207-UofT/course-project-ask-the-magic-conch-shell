package com.bookSystem.controller;
import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.User.User;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.useCase.IDBbookManager;
import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
@RequestMapping("info")
public class accountInfoController {

    /**
     * Controller class for student account info slide bar.
     */

    @Autowired
    private IUserLoginManager ulm;

    @Autowired
    private IDBbookManager bm;

    @Autowired
    private IMongoDBBookMethods mbm;


    @GetMapping
    public String loadInfo() {


        return "studentInfo";
    }

    @PostMapping
    public String displayInfo(Model model){

        model.addAttribute("username", ulm.getCurrentStudent().getUsername());
        model.addAttribute("credit", ulm.getCurrentStudent().getCreditScore());
        ArrayList<Integer> lst = ulm.getCurrentStudent().getCurrentBorrowingRecords();
        ArrayList<Book> lst2 = new ArrayList<>();

        for (Integer bookID : lst) {
            lst2.add(bm.searchBookByID(bookID, mbm));
        }

        model.addAttribute("record", lst2);


        return "studentInfo";
    }
}

