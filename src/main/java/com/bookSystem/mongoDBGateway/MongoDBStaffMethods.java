package com.bookSystem.mongoDBGateway;
import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MongoDBStaffMethods implements IMongoDBStaffMethods {
    public static HashMap<String, DBObject> dataStored;

    /**
     * Add an dbObject into Staff list of the MongoDB cluster.
     *
     * @param dbObject key-value pairs that store data of staffs.
     */
    public static void addToOriginal(DBObject dbObject){
        DB db = getDb();
        db.getCollection("Staff").insert(dbObject);
    }

    /**
     * Connect to the MongoDB cluster and return a DB.
     *
     * @return  a DB type object that stores data in MongoDB Book database.
     */
    private static DB getDb() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        return mongoclient.getDB("User");
    }

    /**
     * Delete an dbObject from Staff Lists of the MongoDB cluster.
     *
     * @param dbObject key-value pairs that store data of staffs.
     */
    public static void deleteOriginal(DBObject dbObject){
        DB db = getDb();
        db.getCollection("Staff").remove(dbObject);
    }

    /**
     * Update an dbObject from staff Lists of the MongoDB cluster.
     *
     * @param userName string that stores userName
     * @param passWord string that stores passWord
     */
    public void update(String userName, String passWord) {
        CheckNone();
        DBObject delete = MongoDBStaffMethods.dataStored.get(userName);
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.replace(userName, dataStored.get(userName), newObject);
        MongoDBStaffMethods.deleteOriginal(delete);
        MongoDBStaffMethods.addToOriginal(newObject);

    }

    /**
     *  Helper method that check if dataStored is None
     */
    private void CheckNone() {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff", "username");
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
     * add to the MongoDB cluster a new staff with username and password
     *
     * @param userName string that stores userName
     * @param passWord string that stores passWord
     */
    public void addStaff(String userName, String passWord) {
        CheckNone();
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.put(userName, newObject);
        MongoDBStaffMethods.addToOriginal(newObject);
    }

    /**
     * check if staff is in the database
     *
     * @param userName string that stores userName
     * @return  boolean that shows if the staff is in the database
     */
    public boolean checkStaff(String userName) {
        CheckNone();
        return dataStored.containsKey(userName);
    }

}
