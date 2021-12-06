package com.bookSystem.mongoDBGateway;

import com.mongodb.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
@Component
public class MongoDBStudentMethods implements IMongoDBStudentMethods {
    public static HashMap<String, DBObject> dataStored;
    /**
     * Add an dbObject into Student list of the MongoDB cluster.
     *
     * @param dbObject key-value pairs that store data of students.
     */
    public static void addToOriginal(DBObject dbObject) {
        DB db = getDb();
        db.getCollection("Student").insert(dbObject);
    }
    /**
     * Connect to the MongoDB cluster and return a DB.
     *
     * @return  a DB type object that stores data in MongoDB student database.
     */
    private static DB getDb() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        return mongoclient.getDB("User");
    }

    /**
     * Delete an dbObject from students list of the MongoDB cluster.
     *
     * @param dbObject key-value pairs that store data of students
     */
    public static void deleteOriginal(DBObject dbObject) {
        DB db = getDb();
        db.getCollection("Student").remove(dbObject);
    }

    /**
     * Update an dbObject from Students Lists of the MongoDB cluster.
     *
     * @param userName string that stores userName
     * @param passWord string that stores passWord
     */
    public void update(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords){
        CheckNone();
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

    /**
     *  Helper method that check if dataStored is None
     */
    private void CheckNone() {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
    }

    /**
     * Connect to the MongoDB cluster and return password
     * @param UserName string that stores userName
     * @return  String of password
     */
    public String getPassword(String UserName) {
        CheckNone();
        return (String) dataStored.get(UserName).get("password");

    }

    /**
     * Connect to the MongoDB cluster and return the creditScore
     * @param UserName string that stores userName
     * @return  Integer of creditScore
     */
    public Integer getCreditScore(String UserName) {
        CheckNone();
        return (Integer) dataStored.get(UserName).get("creditscore");
    }

    /**
     * Connect to the MongoDB cluster and return the BorrowingHistory
     * @param UserName string that stores userName
     * @return  ArrayList of Strings of the BorrowingHistory
     */
    public ArrayList<String> getBorrowingHistory(String UserName) {
        CheckNone();
        return (ArrayList<String>) dataStored.get(UserName).get("borrowedbook");
    }

    /**
     * Connect to the MongoDB cluster and delete a student
     * @param userName string that stores userName
     */
    public void deleteStudent(String userName) {
        if (checkStudent(userName)) {
            MongoDBStudentMethods.deleteOriginal(MongoDBStudentMethods.dataStored.get(userName));
            dataStored.remove(userName);
        }
    }
    /**
     * Connect to the MongoDB cluster and add a student
     * @param userName string that stores userName
     * @param passWord string that stores password
     * @param creditScore integer that stores creditScore
     * @param borrowingRecords ArrayList of Strings of the BorrowingHistory
     */
    public void addStudent(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords) {
        CheckNone();
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        newObject.put("creditscore", creditScore);
        newObject.put("borrowedbook", borrowingRecords);
        dataStored.put(userName, newObject);
        MongoDBStudentMethods.addToOriginal(newObject);
    }
    /**
     * check if student is in the database
     *
     * @param userName string that stores userName
     * @return  boolean that shows if the student is in the database
     */
    @Override
    public boolean checkStudent(String userName) {
        CheckNone();
        return dataStored.containsKey(userName);
    }
}