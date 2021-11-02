package Mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.HashMap;

public class MongoDBBookMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void update(String name, String ISPN, String publishDate, String author){
        if (dataStored == null){
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","name");
            dataStored = dataServer.database;
        }

        DBObject newObject = new BasicDBObject();
        newObject.put("name", name);
        newObject.put("ISPN", ISPN);
        newObject.put("publishDate", publishDate);
        newObject.put("author", author);
        dataStored.replace(name, dataStored.get(name), newObject);

    }

    public static String getISPN(String name) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","name");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(name).get("ISPN");
    }

    public static String getPublishDate(String name) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","name");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(name).get("publishDate");
    }

    public static String getAuthor(String name) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","name");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(name).get("author");
    }

    public static void addBook(String name, String ISPN, String publishDate, String author) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("book","name");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("name", name);
        newObject.put("ISPN", ISPN);
        newObject.put("publishDate", publishDate);
        newObject.put("author", author);
        dataStored.put(name,newObject);
    }
}

