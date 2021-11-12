package Mongodb;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MongoDBBookMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("Book");
        db.getCollection("book").insert(dbObject);
    }

    public static void deleteOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("Book");
        db.getCollection("book").remove(dbObject);
    }

    public static void update(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String dynamic) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
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
        ArrayList<String> subclass = new ArrayList<>(); // An arraylist that contains all the strings that represent types.
        subclass.add("Dictionary");
        subclass.add("Textbook");
        subclass.add("Literature");
        subclass.add("ResearchPaper");
        subclass.add("Magazine");
        if (subclass.contains(dynamic)) {    // The last parameter dynamic can be the name of type or attributes of some subclasses.
            newObject.put("subclass", dynamic);
        } else {                                         // The case that last parameter dynamic is the attributes of some subclasses.
            switch (getType(bookID)) {
                case "Dictionary":
                    newObject.put("Language", dynamic);
                    newObject.put("subclass", "Dictionary");
                    break;

                case "Textbook":
                    newObject.put("Subject", dynamic);
                    newObject.put("subclass", "Textbook");
                    break;

                case "Literature":
                    newObject.put("Period", dynamic);
                    newObject.put("subclass", "Literature");
                    break;
            }
        }
        dataStored.replace(bookID, dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static void update(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String seriesname, String category) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
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
        newObject.put("Seriesname", seriesname);
        newObject.put("Category", category);
        newObject.put("subclass", "Magazine");
        dataStored.replace(bookID, dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static void update(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerstatus) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
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
        newObject.put("Language", language);
        newObject.put("Subject", subject);
        newObject.put("PeerStatus", peerstatus);
        newObject.put("subclass", "ResearchPaper");
        dataStored.replace(bookID, dataStored.get(bookID), newObject);
        MongoDBBookMethods.deleteOriginal(delete);
        MongoDBBookMethods.addToOriginal(newObject);
    }

    public static String getISPN(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("ISPN");
    }

    public static String getPublishDate(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("publishDate");
    }

    public static String getAuthor(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("author");
    }

    public static String getStatus(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("status");
    }

    public static String getReturnDate(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("Rdate");
    }

    public static String getType(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(bookID).get("subclass");
    }

    public static String getLanguage(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (Objects.equals(getType(bookID), "Dictionary")) {
            return (String) dataStored.get(bookID).get("Language");
        } else if (Objects.equals(getType(bookID), "ResearchPaper")) {
            return (String) dataStored.get(bookID).get("Language");
        } else {
            System.out.println("This is not a dictionary or research paper, so it has no language tag.");
            return null;
        }
    }

    public static String getSubject(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (Objects.equals(getType(bookID), "Textbook")) {
            return (String) dataStored.get(bookID).get("Subject");
        } else if (Objects.equals(getType(bookID), "ResearchPaper")) {
            return (String) dataStored.get(bookID).get("Subject");
        } else {
            System.out.println("This is not a textbook or research paper, so it has no subject tag.");
            return null;
        }
    }

    public static String getSeriesName(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (Objects.equals(getType(bookID), "Magazine")) {
            return (String) dataStored.get(bookID).get("Seriesname");
        } else {
            System.out.println("This is not a magazine, so it has no series name tag.");
            return null;
        }
    }

    public static String getCategory(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (Objects.equals(getType(bookID), "Magazine")) {
            return (String) dataStored.get(bookID).get("Category");
        } else {
            System.out.println("This is not a magazine, so it has no category tag.");
            return null;
        }
    }

    public static String getPeriod(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (Objects.equals(getType(bookID), "Literature")) {
            return (String) dataStored.get(bookID).get("Period");
        } else {
            System.out.println("This is not a literature, so it has no period tag.");
            return null;
        }
    }

    public static String getPeerstatus(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (Objects.equals(getType(bookID), "ResearchPaper")) {
            return (String) dataStored.get(bookID).get("PeerStatus");
        } else {
            System.out.println("This is not a research paper, so it has no peer review status.");
            return null;
        }
    }

    public static void addBook(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String type) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (checkBook(bookID)) {
            update(bookID, name, ISPN, publishDate, author, status, returnDate, type);
        } else {
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
            dataStored.put(bookID, newObject);
            MongoDBBookMethods.addToOriginal(newObject);
        }
    }

    public static void addDictionary(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String language) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (checkBook(bookID)) {
            update(bookID, name, ISPN, publishDate, author, status, returnDate, language);
        } else {
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
            dataStored.put(bookID, newObject);
            MongoDBBookMethods.addToOriginal(newObject);
        }
    }

    public static void addLiterature(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String period) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (checkBook(bookID)) {
            update(bookID, name, ISPN, publishDate, author, status, returnDate, period);
        } else {
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
            dataStored.put(bookID, newObject);
            MongoDBBookMethods.addToOriginal(newObject);
        }
    }

    public static void addMagazine(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String seriesname, String category) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (checkBook(bookID)) {
            update(bookID, name, ISPN, publishDate, author, status, returnDate, seriesname, category);
        } else {
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
            dataStored.put(bookID, newObject);
            MongoDBBookMethods.addToOriginal(newObject);
        }
    }

    public static void addTextbook(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String subject) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (checkBook(bookID)) {
            update(bookID, name, ISPN, publishDate, author, status, returnDate, subject);
        } else {
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
            dataStored.put(bookID, newObject);
            MongoDBBookMethods.addToOriginal(newObject);
        }
    }

    public static void addResearchPaper(String bookID, String name, String ISPN, String publishDate, String author, String status, String returnDate, String language, String subject, String peerreviewstatus) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        if (checkBook(bookID)) {
            update(bookID, name, ISPN, publishDate, author, status, returnDate, language, subject, peerreviewstatus);
        } else {
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
            dataStored.put(bookID, newObject);
            MongoDBBookMethods.addToOriginal(newObject);
        }
    }

    public static boolean checkBook(String bookID) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book", "id");
            dataStored = dataServer.database;
        }
        return dataStored.containsKey(bookID);
    }
}



