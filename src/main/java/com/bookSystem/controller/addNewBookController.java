package com.bookSystem.controller;

import com.bookSystem.entity.Book.Book;
import com.bookSystem.entity.Book.bookType.*;
import com.bookSystem.mongoDBGateway.IMongoDBBookMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.useCase.IDBUserManager;
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
import java.util.Objects;


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

    /**
     * add new book based on its type into the inventory
     * @param type book's type
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param language book's language
     */

    @PostMapping("/dictionary")
    public void addNewDictionary(@RequestParam("Type") String type,
                                 @RequestParam("bookName") String name,
                                 @RequestParam("ISBN") String ISBN,
                                 @RequestParam("Author") String author,
                                 @RequestParam("Publish Date") LocalDate publishDate,
                                 @RequestParam("Language") String language,
                                 Model model){
        int randomNum = (int)(Math.random()*100000);
        while (!mbm.checkBook(String.valueOf(randomNum))){
            if (Objects.equals(type, "Dictionary")){
                Book book = new dictionary(randomNum, name, ISBN, publishDate, author, language, type);
                bm.addBook(book, mbm);
            }
            }
    }

    /**
     * add new magazine based on its type into the inventory
     * @param type book's type
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param seriesName book's seriesName
     * @param category book's category
     */
    @PostMapping("/magazine")
    public void addNewMagazine(@RequestParam("bookName") String name,
                               @RequestParam("ISBN") String ISBN,
                               @RequestParam("Publish Date") LocalDate publishDate,
                               @RequestParam("Author") String author,
                               @RequestParam("seriesName") String seriesName,
                               @RequestParam("Category") String category,
                               @RequestParam("Type") String type){
        int randomNum = (int)(Math.random()*100000);
        while (!mbm.checkBook(String.valueOf(randomNum))){
            if (Objects.equals(type, "Magazine")){
                Book book = new magazine(randomNum, name, ISBN, publishDate, author, seriesName, category, type);
                bm.addBook(book, mbm);
            }
        }

    }

    /**
     * add new literature based on its type into the inventory
     * @param type book's type
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param period book's period
     */
    @PostMapping("/literature")
    public void addNewLiterature(@RequestParam("bookName") String name,
                               @RequestParam("ISBN") String ISBN,
                               @RequestParam("Publish Date") LocalDate publishDate,
                               @RequestParam("Author") String author,
                               @RequestParam("Period") String period,
                               @RequestParam("Type") String type){
        int randomNum = (int)(Math.random()*100000);
        while (!mbm.checkBook(String.valueOf(randomNum))){
            if (Objects.equals(type, "Literature")){
                Book book = new literature(randomNum, name, ISBN, publishDate, author, period, type);
                bm.addBook(book, mbm);
            }
        }

    }

    /**
     * add new researchPaper based on its type into the inventory
     * @param type book's type
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param subject book's subject
     * @param peer_review_status book's peer_review_status
     */
    @PostMapping("/researchPaper")
    public void addNewResearchPaper(@RequestParam("bookName") String name,
                               @RequestParam("ISBN") String ISBN,
                               @RequestParam("Publish Date") LocalDate publishDate,
                               @RequestParam("Author") String author,
                               @RequestParam("Subject") String subject,
                               @RequestParam("Language") String language,
                               @RequestParam("peer_review_status") boolean peer_review_status,
                               @RequestParam("Type") String type){
        int randomNum = (int)(Math.random()*100000);
        while (!mbm.checkBook(String.valueOf(randomNum))){
            if (Objects.equals(type, "ResearchPaper")){
                Book book = new researchPaper(randomNum, name, ISBN, publishDate, author, subject, language, peer_review_status, type);
                bm.addBook(book, mbm);
            }
        }

    }

    /**
     * add new textbook based on its type into the inventory
     * @param type book's type
     * @param name book's name
     * @param ISBN book's ISBN
     * @param author book's author
     * @param publishDate book's publishDate
     * @param subject book's subject
     */
    @PostMapping("textbook")
    public void addNewTextbook(@RequestParam("bookName") String name,
                                    @RequestParam("ISBN") String ISBN,
                                    @RequestParam("Publish Date") LocalDate publishDate,
                                    @RequestParam("Author") String author,
                                    @RequestParam("Subject") String subject,
                                    @RequestParam("Type") String type){
        int randomNum = (int)(Math.random()*100000);
        while (!mbm.checkBook(String.valueOf(randomNum))){
            if (Objects.equals(type, "Textbook")){
                Book book = new textbook(randomNum, name, ISBN, publishDate, author, subject, type);
                bm.addBook(book, mbm);
            }
        }

    }
    }


