package Mongodb;

import com.mongodb.*;

import java.util.Dictionary;
import java.util.HashMap;

public class MongoDBBookMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject){
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("Book");
        db.getCollection("book").insert(dbObject);
    }
    public static void deleteOriginal(DBObject dbObject){
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("Book");
        db.getCollection("book").remove(dbObject);
    }

    public static void update(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String type){
        if (dataStored == null){
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","name");
            dataStored = dataServer.database;
        }
        DBObject delete = dataStored.get(bookID);
        DBObject newObject = new BasicDBObject();
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISPN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
        newObject.put("Subclass", type);
        dataStored.replace(bookID, dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);

    }

    public static String getISPN(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","bookID");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("ISPN");
    }

    public static String getPublishDate(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","bookID");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("publishDate");
    }

    public static String getAuthor(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","bookID");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("author");
    }

    public static void addBook(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String type) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","bookID");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISPN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
        newObject.put("Subclass", type);
        String mark = "null"; // This means it supposes to have value, but no value has been inputted yet.
        switch(type){
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
        dataStored.put(bookID,newObject);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static void addDictionary(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String language) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "bookID");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISPN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
        newObject.put("Language", language);
        String type = "Dictionary";
        newObject.put("Subclass", type);
        dataStored.put(bookID,newObject);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static void addLiterature(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String period) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "bookID");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISPN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
        newObject.put("Period", period);
        String type = "Dictionary";
        newObject.put("Subclass", type);
        dataStored.put(bookID,newObject);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static void addMagazine(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String seriesname, String category) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "bookID");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISPN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
        newObject.put("Seriesname", seriesname);
        newObject.put("Category", category);
        String type = "Magagzine";
        newObject.put("Subclass", type);
        dataStored.put(bookID,newObject);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static void addTextbook(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String subject) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "bookID");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISPN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
        newObject.put("Subject", subject);
        String type = "Textbook";
        newObject.put("Subclass", type);
        dataStored.put(bookID,newObject);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static void addResearchPaper(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerreviewstatus) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "bookID");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("id", bookID);
        newObject.put("name", name);
        newObject.put("ISBN/ISSN", ISPN);
        newObject.put("Pdate", publishDate);
        newObject.put("Author", author);
        newObject.put("Status", status);
        newObject.put("Rdate", returnDate);
        newObject.put("Language", language);
        newObject.put("Subject", subject);
        newObject.put("PeerStatus", peerreviewstatus);
        String type = "ResearchPaper";
        newObject.put("Subclass", type);
        dataStored.put(bookID,newObject);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static boolean checkBook(String bookID){
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "bookID");
            dataStored = dataServer.database;
        }
        return dataStored.containsKey(bookID);
    }
}

