package com.bookSystem.mongoDBGateway;

import com.bookSystem.useCase.BookPositionStatus;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MongoDBBookMethods implements IMongoDBBookMethods {
    public static HashMap<String, DBObject> dataStored;

    /**
     Connect to the MongoDB cluster and return a DB.
     */
    private static DB getDb() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        return mongoclient.getDB("Book");
    }

    /**
     Add an dbObject into the MongoDB cluster.
     */
    public static void addToOriginal(DBObject dbObject) {
        DB db = getDb();
        db.getCollection("book").insert(dbObject);
    }

    /**
     Delete an dbObject from the MongoDB cluster.
     */
    public static void deleteOriginal(DBObject dbObject) {
        DB db = getDb();
        db.getCollection("book").remove(dbObject);
    }

    /**
     Refresh datastored from MongoDb if it has not being assigned.
     */
    private void checkdatastored() {
        if (MongoDBBookMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
    }


    /**
     Put common attributes of all subclasses into a given DBObject.
     */
    private void putObject(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, DBObject newObject) {
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISBN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
    }

    /**
     It provides a way for people to update the Magazine
     */
    public void updateMagazine(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String seriesname, String category) {
        checkdatastored();
        DBObject delete = MongoDBBookMethods.dataStored.get(bookID);
        DBObject newObject = new BasicDBObject();
        putObject(bookID, name, ISBN, publishDate, author, status, returnDate, newObject);
        newObject.put("Seriesname", seriesname);
        newObject.put("Category", category);
        newObject.put("subclass", "Magazine");
        dataStored.replace(bookID, dataStored.get(bookID), newObject);
        deleteOriginal(delete);
        addToOriginal(newObject);
    }


    /**
     It provides a way for people to update the Research paper
     */
    public void updateRearchPaper(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerstatus) {
        checkdatastored();
        DBObject delete = MongoDBBookMethods.dataStored.get(bookID);
        DBObject newObject = new BasicDBObject();
        putObject(bookID, name, ISBN, publishDate, author, status, returnDate, newObject);
        newObject.put("Language", language);
        newObject.put("Subject", subject);
        newObject.put("PeerStatus", peerstatus);
        newObject.put("subclass", "ResearchPaper");
        MongoDBBookMethods.dataStored.replace(bookID, MongoDBBookMethods.dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);
    }


    /**
     It provides a way for people to update Dictionary
     */
    public void updateDictionary(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language) {
        checkdatastored();
        DBObject delete = MongoDBBookMethods.dataStored.get(bookID);
        DBObject newObject = new BasicDBObject();
        putObject(bookID, name, ISBN, publishDate, author, status, returnDate, newObject);
        newObject.put("Language", language);
        newObject.put("subclass", "Dictionary");
        MongoDBBookMethods.dataStored.replace(bookID, MongoDBBookMethods.dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    /**
     It provides a way for people to update Literature
     */
    public void updateLiterature(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String period) {
        checkdatastored();
        DBObject delete = MongoDBBookMethods.dataStored.get(bookID);
        DBObject newObject = new BasicDBObject();
        putObject(bookID, name, ISBN, publishDate, author, status, returnDate, newObject);
        newObject.put("Period", period);
        newObject.put("subclass", "Literature");
        MongoDBBookMethods.dataStored.replace(bookID, MongoDBBookMethods.dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    /**
     It provides a way for people to update Textbook
     */
    public void updateTextbook(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String subject) {
        checkdatastored();
        DBObject delete = MongoDBBookMethods.dataStored.get(bookID);
        DBObject newObject = new BasicDBObject();
        putObject(bookID, name, ISBN, publishDate, author, status, returnDate, newObject);
        newObject.put("Subject", subject);
        newObject.put("subclass", "Textbook");
        MongoDBBookMethods.dataStored.replace(bookID, MongoDBBookMethods.dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);
    }


    public String getName(String bookID) {
        checkdatastored();
        String date = (String) MongoDBBookMethods.dataStored.get(bookID).get("Pdate");


        return (String) MongoDBBookMethods.dataStored.get(bookID).get("name");
    }

    public String getISBN(String bookID) {
        checkdatastored();

        return (String) MongoDBBookMethods.dataStored.get(bookID).get("ISBN/ISSN");
    }

    public ArrayList<Integer> searchByISBN(String ISBN){
        checkdatastored();
        ArrayList<Integer> ar = new ArrayList<>();
        for (String bookID : MongoDBBookMethods.dataStored.keySet()) {
            if (MongoDBBookMethods.dataStored.get(bookID).get("ISBN/ISSN").equals(ISBN)){
                Integer bid = Integer.parseInt(bookID);
                ar.add(bid);
            }
        }
        return ar;
    }

    public ArrayList<Integer> searchByAuthor(String author){
        checkdatastored();
        ArrayList<Integer> arr = new ArrayList<>();
        for (String bookID : MongoDBBookMethods.dataStored.keySet()) {
            if (MongoDBBookMethods.dataStored.get(bookID).get("Author").equals(author)) {
                Integer bid = Integer.parseInt(bookID);
                arr.add(bid);
            }
        }
        return arr;
    }

    public ArrayList<Integer> searchByType(String type) {
        checkdatastored();
        ArrayList<Integer> arra = new ArrayList<>();
        for (String bookID : MongoDBBookMethods.dataStored.keySet()){
            if (MongoDBBookMethods.dataStored.get(bookID).get("subclass").equals(type)){
                Integer bid = Integer.parseInt(bookID);
                arra.add(bid);
            }
        }
        return arra;
    }

    public LocalDate getPublishDate(String bookID) {
        checkdatastored();
        String date = (String) MongoDBBookMethods.dataStored.get(bookID).get("Pdate");

        //convert String to LocalDate
        return LocalDate.parse(date);
    }

    public String getAuthor(String bookID) {
        checkdatastored();

        return (String) MongoDBBookMethods.dataStored.get(bookID).get("Author");
    }

    public BookPositionStatus getStatus(String bookID) {
        checkdatastored();
        if ((dataStored.get(bookID).get("Status")).equals("unlended")) {
            return BookPositionStatus.UNLENDED;
        }else if ((dataStored.get(bookID).get("Status")).equals("lended")){
            return BookPositionStatus.LENDED;
        }
        return null;
    }

    public LocalDate getReturnDate(String bookID) {
        checkdatastored();
        String date = (String) MongoDBBookMethods.dataStored.get(bookID).get("Rdate");
        if (!Objects.equals(date, "null")) {
            //convert String to LocalDate
            return LocalDate.parse(date);
        }
        return null;
    }

    public String getType(String bookID) {
        checkdatastored();

        return (String) MongoDBBookMethods.dataStored.get(bookID).get("subclass");
    }

    public String getLanguage(String bookID) {
        checkdatastored();
        if (Objects.equals(getType(bookID), "Dictionary")) {
            return (String) MongoDBBookMethods.dataStored.get(bookID).get("Language");
        } else if (Objects.equals(getType(bookID), "ResearchPaper")) {
            return (String) MongoDBBookMethods.dataStored.get(bookID).get("Language");
        } else {
            System.out.println("This is not a dictionary or research paper, so it has no language tag.");
            return null;
        }
    }

    public String getSubject(String bookID) {
        checkdatastored();
        if (Objects.equals(getType(bookID), "Textbook")) {
            return (String) MongoDBBookMethods.dataStored.get(bookID).get("Subject");
        } else if (Objects.equals(getType(bookID), "ResearchPaper")) {
            return (String) MongoDBBookMethods.dataStored.get(bookID).get("Subject");
        } else {
            System.out.println("This is not a textbook or research paper, so it has no subject tag.");
            return null;
        }
    }

    public String getSeriesName(String bookID) {
        checkdatastored();
        if (Objects.equals(getType(bookID), "Magazine")) {
            return (String) MongoDBBookMethods.dataStored.get(bookID).get("Seriesname");
        } else {
            System.out.println("This is not a magazine, so it has no series name tag.");
            return null;
        }
    }

    public String getCategory(String bookID) {
        checkdatastored();
        if (Objects.equals(getType(bookID), "Magazine")) {
            return (String) MongoDBBookMethods.dataStored.get(bookID).get("Category");
        } else {
            System.out.println("This is not a magazine, so it has no category tag.");
            return null;
        }
    }

    public String getPeriod(String bookID) {
        checkdatastored();
        if (Objects.equals(getType(bookID), "Literature")) {
            return (String) MongoDBBookMethods.dataStored.get(bookID).get("Period");
        } else {
            System.out.println("This is not a literature, so it has no period tag.");
            return null;
        }
    }

    public Comparable<Boolean> getPeerstatus(String bookID) {
        checkdatastored();
        if (Objects.equals(getType(bookID), "ResearchPaper")) {
            return (boolean) MongoDBBookMethods.dataStored.get(bookID).get("PeerStatus");
        } else {
            System.out.println("This is not a research paper, so it has no peer review status.");
            return null;
        }
    }

    /**
     Add book to the MongoDB cluster base on its type and also add it to datastored.
     */
    public void addBook(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String type) {
        checkdatastored();
        DBObject newObject = new BasicDBObject();
        putObject(bookID, name, ISBN, publishDate, author, status, returnDate, newObject);
        newObject.put("subclass", type);
        String mark = "null"; // This means it supposes to have value, but no value has been inputted yet.
        switch (type) {
            case "Dictionary":
                newObject.put("Language", mark);
                break;

            case "Textbook":
                newObject.put("subject", mark);
                break;

            case "Magazine":
                newObject.put("Seriesname", mark);
                newObject.put("Category", mark);
                break;

            case "Literature":
                newObject.put("Period", mark);
                break;

            case "ResearchPaper":
                newObject.put("Language", mark);
                newObject.put("Subject", mark);
                newObject.put("PeerStatus", mark);
        }
        MongoDBBookMethods.dataStored.put(bookID, newObject);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    /**
     Delete certain book from the MongoDB cluster.
     */
    public void deleteDBBook(String bookID) {
        if (checkBook(bookID)) {
            deleteOriginal(dataStored.get(bookID));
            dataStored.remove(bookID);
        }
    }

    /**
     Check if book is in datastored already.
     */
    public boolean checkBook(String bookID) {
        checkdatastored();
        return MongoDBBookMethods.dataStored.containsKey(bookID);
    }

//    public void addDictionary(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language) {
//        if (dataStored == null) {
//            MongoDB dataServer = new MongoDB();
//            dataServer.store("book", "id");
//            dataStored = dataServer.database;
//        }
//        DBObject newObject = new BasicDBObject();
//        newObject.put("id", bookID);
//        newObject.put("name", name);
//        newObject.put("ISBN/ISSN", ISBN);
//        newObject.put("Pdate", publishDate);
//        newObject.put("Author", author);
//        newObject.put("Status", status);
//        newObject.put("Rdate", returnDate);
//        newObject.put("Language", language);
//        String type = "Dictionary";
//        newObject.put("Subclass", type);
//        dataStored.put(bookID, newObject);
//        MongoDBBookMethods.addToOriginal(newObject);
//    }
//
//    public void addLiterature(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String period) {
//        if (dataStored == null) {
//            MongoDB dataServer = new MongoDB();
//            dataServer.store("book", "id");
//            dataStored = dataServer.database;
//        }
//        DBObject newObject = new BasicDBObject();
//        newObject.put("id", bookID);
//        newObject.put("name", name);
//        newObject.put("ISBN/ISSN", ISBN);
//        newObject.put("Pdate", publishDate);
//        newObject.put("Author", author);
//        newObject.put("Status", status);
//        newObject.put("Rdate", returnDate);
//        newObject.put("Period", period);
//        String type = "Literature";
//        newObject.put("Subclass", type);
//        dataStored.put(bookID, newObject);
//        MongoDBBookMethods.addToOriginal(newObject);
//    }
//
//    public void addMagazine(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String seriesname, String category) {
//        if (dataStored == null) {
//            MongoDB dataServer = new MongoDB();
//            dataServer.store("book", "id");
//            dataStored = dataServer.database;
//        }
//        DBObject newObject = new BasicDBObject();
//        newObject.put("id", bookID);
//        newObject.put("name", name);
//        newObject.put("ISBN/ISSN", ISBN);
//        newObject.put("Pdate", publishDate);
//        newObject.put("Author", author);
//        newObject.put("Status", status);
//        newObject.put("Rdate", returnDate);
//        newObject.put("Seriesname", seriesname);
//        newObject.put("Category", category);
//        String type = "Magagzine";
//        newObject.put("Subclass", type);
//        dataStored.put(bookID, newObject);
//        MongoDBBookMethods.addToOriginal(newObject);
//    }
//
//    public void addTextbook(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String subject) {
//        if (dataStored == null) {
//            MongoDB dataServer = new MongoDB();
//            dataServer.store("book", "id");
//            dataStored = dataServer.database;
//        }
//        DBObject newObject = new BasicDBObject();
//        newObject.put("id", bookID);
//        newObject.put("name", name);
//        newObject.put("ISBN/ISSN", ISBN);
//        newObject.put("Pdate", publishDate);
//        newObject.put("Author", author);
//        newObject.put("Status", status);
//        newObject.put("Rdate", returnDate);
//        newObject.put("Subject", subject);
//        String type = "Textbook";
//        newObject.put("Subclass", type);
//        dataStored.put(bookID, newObject);
//        MongoDBBookMethods.addToOriginal(newObject);
//    }
//
//    public void addResearchPaper(String bookID, String name, String ISBN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerreviewstatus) {
//        if (dataStored == null) {
//            MongoDB dataServer = new MongoDB();
//            dataServer.store("book", "id");
//            dataStored = dataServer.database;
//        }
//        DBObject newObject = new BasicDBObject();
//        newObject.put("id", bookID);
//        newObject.put("name", name);
//        newObject.put("ISBN/ISSN", ISBN);
//        newObject.put("Pdate", publishDate);
//        newObject.put("Author", author);
//        newObject.put("Status", status);
//        newObject.put("Rdate", returnDate);
//        newObject.put("Language", language);
//        newObject.put("Subject", subject);
//        newObject.put("PeerStatus", peerreviewstatus);
//        String type = "ResearchPaper";
//        newObject.put("Subclass", type);
//        dataStored.put(bookID, newObject);
//        MongoDBBookMethods.addToOriginal(newObject);
//    }

}


