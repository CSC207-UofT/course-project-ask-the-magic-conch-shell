package com.bookSystem.controller;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.Book.bookType.Magazine;
import com.bookSystem.entity.Book.bookType.dictionary;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.useCase.IDBUserManager;
import com.bookSystem.useCase.IDBbookManager;
import com.bookSystem.useCase.IUserLoginManager;
import com.bookSystem.useCase.UserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Dictionary;
import java.util.Objects;


@Controller
@RequestMapping("addNewBook")
public class addNewBookController {

    @Autowired
    private IDBUserManager um;

    @Autowired
    private IMongoDBStudentMethods sm;

    @Autowired
    private IMongoDBStaffMethods sam;

    @Autowired
    private IUserLoginManager ulm;

    @Autowired
    private IDBbookManager bm;

    @Autowired
    private IMongoDBBookMethods mbm;

    @GetMapping
    public String loadaddBook() {


        return "addBook";
    }


    @GetMapping("dictionary")
    public String loadDictionary() {


        return "Dictionary";
    }

    /**
     * add new book based on its type into the inventory
     * @param type
     * @param name
     * @param ISBN
     * @param author
     * @param publishDate
     * @param language
     * @param period
     * @param seriesName
     * @param category
     * @param subject
     */

    @PostMapping("dictionary")
    public void addNewDictionary(@RequestParam("type") String type,
                                 @RequestParam("bookName") String name,
                                 @RequestParam("ISBN") String ISBN,
                                 @RequestParam("Author") String author,
                                 @RequestParam("Publish Date") LocalDate publishDate,
                                 @RequestParam("Language") String language,
                                 Model model){
        int randomNum = (int)(Math.random()*100000);
        if (Objects.equals(type, "Dictionary") && mbm.checkBook(String.valueOf(randomNum))){
            Book book = new dictionary(randomNum, name, ISBN, publishDate, author, language, type);
            bm.addBook(book, mbm);
        }

    }

    public int random() {
        int randomNum = (int)(Math.random()*100000);
        return randomNum;
    }



}
