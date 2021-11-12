package Mongodb;

import com.mongodb.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MongoDBStudentMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("User");
        db.getCollection("Student").insert(dbObject);
    }

    public static void deleteOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("User");
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
        MongoDBStudentMethods.deleteOriginal(delete);
        MongoDBStudentMethods.addToOriginal(newObject);

    }

    public static String getPassword(String UserName) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(UserName).get("password");
    }

    public static Integer getCreditScore(String UserName) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }

        return (Integer) dataStored.get(UserName).get("creditscore");
    }
    public static ArrayList<String> getBorrowingHistory(String UserName) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        return (ArrayList<String>) dataStored.get(UserName).get("borrowedbook");
    }

    public static void deleteStudent(String userName){

        if(MongoDBStudentMethods.checkStudent(userName)){
            MongoDBStudentMethods.deleteOriginal(dataStored.get(userName));
            dataStored.remove(userName);

        }


    }
    public static void addStudent(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        if (checkStudent(userName)){
            update(userName, passWord, creditScore, borrowingRecords);
        } else {
            DBObject newObject = new BasicDBObject();
            newObject.put("username", userName);
            newObject.put("password", passWord);
            newObject.put("creditscore", creditScore);
            newObject.put("borrowedbook", borrowingRecords);
            dataStored.put(userName, newObject);
            MongoDBStudentMethods.addToOriginal(newObject);
        }
    }

    public static boolean checkStudent(String userName){
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        return dataStored.containsKey(userName);
    }

}