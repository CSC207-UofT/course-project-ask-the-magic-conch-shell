package Mongodb;
import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.HashMap;

public class MongoDBStaffMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject){
        MongoClient mongoclient = new MongoClient("localhost", 27017);
        DB db = mongoclient.getDB("local");
        db.getCollection("Staff").insert(dbObject);
    }
    public static void deleteOriginal(DBObject dbObject){
        MongoClient mongoclient = new MongoClient("localhost", 27017);
        DB db = mongoclient.getDB("local");
        db.getCollection("Staff").remove(dbObject);
    }

    public static void update(String userName, String passWord){
        if (dataStored == null){
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff","username");
            dataStored = dataServer.database;
        }
        DBObject delete = dataStored.get(userName);
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.replace(userName, dataStored.get(userName), newObject);
        MongoDBStaffMethods.deleteOriginal(delete);
        MongoDBStaffMethods.addToOriginal(newObject);

    }

    public static String getPassword(String UserName) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff","username");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(UserName).get("password");
    }

    public static void addUser(String userName, String passWord) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff","username");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.put(userName,newObject);
        MongoDBStaffMethods.addToOriginal(newObject);
    }
    public static boolean checkUser(String userName){
        if (dataStored == null){
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff","username");
            dataStored = dataServer.database;
        }
        return dataStored.containsKey(userName);
    }
}
