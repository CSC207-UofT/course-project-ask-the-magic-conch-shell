package Mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.HashMap;

public class MongoDBBookMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject){
        MongoClient mongoclient = new MongoClient("localhost", 27017);
        DB db = mongoclient.getDB("local");
        db.getCollection("book").insert(dbObject);
    }
    public static void deleteOriginal(DBObject dbObject){
        MongoClient mongoclient = new MongoClient("localhost", 27017);
        DB db = mongoclient.getDB("local");
        db.getCollection("book").remove(dbObject);
    }

    public static void update(String bookID, String name, String ISPN, String publishDate, String author, String type){
        if (dataStored == null){
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","name");
            dataStored = dataServer.database;
        }
        DBObject delete = dataStored.get(bookID);
        DBObject newObject = new BasicDBObject();
        newObject.put("bookID", bookID);
        newObject.put("name", name);
        newObject.put("ISPN", ISPN);
        newObject.put("publishDate", publishDate);
        newObject.put("author", author);
        newObject.put("type", type);
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

    public static void addBook(String bookID, String name, String ISPN, String publishDate, String author, String type) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","bookID");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("bookID", bookID);
        newObject.put("name", name);
        newObject.put("ISPN", ISPN);
        newObject.put("publishDate", publishDate);
        newObject.put("author", author);
        newObject.put("type", type);
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

