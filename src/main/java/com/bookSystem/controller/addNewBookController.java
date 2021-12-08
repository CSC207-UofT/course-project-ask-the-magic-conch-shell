package com.bookSystem.controller;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.Book.bookType.*;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.useCase.IDBbookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


@Controller
@RequestMapping("addNewBook")
public class addNewBookController {


    @Autowired
    private IDBbookManager bm;

    @Autowired
    private IMongoDBBookMethods mbm;

    @GetMapping
    public String loadaddBook() {


        return "addBook";
    }


    @GetMapping("/dictionary")
    public String loadDictionary() {


        return "Dictionary";
    }

    @GetMapping("/magazine")
    public String loadMagazine(){
        return "Magazine";
    }

    @GetMapping("/literature")
    public String loadLiterature(){
        return "Literature";
    }

    @GetMapping("/researchPaper")
    public String loadResearchPaper(){
        return "ResearchPaper";
    }

    @GetMapping("/textbook")
    public String loadTextbook(){
        return "Textbook";
    }

    @PostMapping("")
    public String selectType(@RequestParam("books") String type){
        switch (type) {
            case "Dictionary":
                return "Dictionary";
            case "Magazine":
                return "Magazine";
            case "Literature":
                return "Literature";
            case "ResearchPaper":
                return "ResearchPaper";
            case "Textbook":
                return "Textbook";
        }
        return "addBook";
    }

    /**
     * add new book based on its type into the inventory
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param language book's language
     */

    @PostMapping("/dictionary")
    public String addNewDictionary(@RequestParam("bookName") String name,
                                 @RequestParam("ISBN") String ISBN,
                                 @RequestParam("Author") String author,
                                 @RequestParam("PublishDate") String publishDate,
                                 @RequestParam("Language") String language){
        int randomNum = (int)(Math.random()*100000);
        while (mbm.checkBook(String.valueOf(randomNum))){
            randomNum = (int)(Math.random()*100000);
        }
        final LocalDate dt = LocalDate.parse(publishDate);
        Book book = new dictionary(randomNum, name, ISBN, dt, author, language, "dictionary");
        bm.addBook(book, mbm);
        return "Dictionary";
    }

    /**
     * add new magazine based on its type into the inventory
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param seriesName book's seriesName
     * @param category book's category
     */
    @PostMapping("/magazine")
    public String addNewMagazine(@RequestParam("bookName") String name,
                               @RequestParam("ISBN") String ISBN,
                               @RequestParam("PublishDate") String publishDate,
                               @RequestParam("Author") String author,
                               @RequestParam("series_name") String seriesName,
                               @RequestParam("Category") String category){
        int randomNum = (int)(Math.random()*100000);
        while (mbm.checkBook(String.valueOf(randomNum))){
            randomNum = (int)(Math.random()*100000);
        }
        final LocalDate dt = LocalDate.parse(publishDate);
        Book book = new magazine(randomNum, name, ISBN, dt, author, seriesName, category, "magazine");
        bm.addBook(book, mbm);
        return "Magazine";
    }


    /**
     * add new literature based on its type into the inventory
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param period book's period
     */
    @PostMapping("/literature")
    public String addNewLiterature(@RequestParam("bookName") String name,
                                 @RequestParam("ISBN") String ISBN,
                                 @RequestParam("PublishDate") String publishDate,
                                 @RequestParam("Author") String author,
                                 @RequestParam("Period") String period){
        int randomNum = (int)(Math.random()*100000);
        while (mbm.checkBook(String.valueOf(randomNum))){
            randomNum = (int)(Math.random()*100000);
        }
        final LocalDate dt = LocalDate.parse(publishDate);
        Book book = new literature(randomNum, name, ISBN, dt, author, period, "literature");
        bm.addBook(book, mbm);
        return "Literature";
    }


    /**
     * add new researchPaper based on its type into the inventory
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param subject book's subject
     * @param peer_review_status book's peer_review_status
     */
    @PostMapping("/researchPaper")
    public String addNewResearchPaper(@RequestParam("bookName") String name,
                                    @RequestParam("ISBN") String ISBN,
                                    @RequestParam("PublishDate") String publishDate,
                                    @RequestParam("Author") String author,
                                    @RequestParam("Subject") String subject,
                                    @RequestParam("Language") String language,
                                    @RequestParam("peer_review_status") String peer_review_status,
                                      Model model){
        int randomNum = (int) (Math.random() * 100000);
        while (mbm.checkBook(String.valueOf(randomNum))) {
            randomNum = (int) (Math.random() * 100000);
        }
        final LocalDate dt = LocalDate.parse(publishDate);
        if (peer_review_status.equals("True")){
            Book book = new researchPaper(randomNum, name, ISBN, dt, author, subject, language,
                    true, "researchPaper");
            bm.addBook(book, mbm);
            return "ResearchPaper";
        }
        else if (peer_review_status.equals("False")){
            Book book = new researchPaper(randomNum, name, ISBN, dt, author, subject, language,
                    false, "researchPaper");
            bm.addBook(book, mbm);
            return "ResearchPaper";
        }
        else {
            model.addAttribute("message", "Invalid peer_review_status");
            return "ResearchPaper";
        }
    }


    /**
     * add new textbook based on its type into the inventory
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param subject book's subject
     */
    @PostMapping("textbook")
    public String addNewTextbook(@RequestParam("bookName") String name,
                               @RequestParam("ISBN") String ISBN,
                               @RequestParam("PublishDate") String publishDate,
                               @RequestParam("Author") String author,
                               @RequestParam("Subject") String subject){
        int randomNum = (int)(Math.random()*100000);
        while (mbm.checkBook(String.valueOf(randomNum))){
            randomNum = (int)(Math.random()*100000);
        }
        final LocalDate dt = LocalDate.parse(publishDate);
        Book book = new textbook(randomNum, name, ISBN, dt, author, subject, "textbook");
        bm.addBook(book, mbm);
        return "Textbook";
    }

    }


