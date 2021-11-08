package Mongodb;

import Book.Book;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.ArrayList;
import java.util.HashMap;


import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.HashMap;
import java.util.Objects;

public class MongoDBStudentMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject) {
        MongoClient mongoclient = new MongoClient("localhost", 27017);
        DB db = mongoclient.getDB("local");
        db.getCollection("Student").insert(dbObject);
    }

    public static void deleteOriginal(DBObject dbObject) {
        MongoClient mongoclient = new MongoClient("localhost", 27017);
        DB db = mongoclient.getDB("local");
        db.getCollection("Student").remove(dbObject);
    }

    public static void update(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        DBObject delete = dataStored.get(userName);
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        newObject.put("creditscore", creditScore);
        newObject.put("borrowedbook", borrowingRecords);
        dataStored.replace(userName, dataStored.get(userName), newObject);
        MongoDBUserMethods.deleteOriginal(delete);
        MongoDBUserMethods.addToOriginal(newObject);

    }

    public static String getPassword(String UserName) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(UserName).get("password");
    }

    public static void addStudent(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        newObject.put("creditscore", creditScore);
        newObject.put("borrowedbook", borrowingRecords);
        dataStored.put(userName, newObject);
        MongoDBStudentMethods.addToOriginal(newObject);
    }
}