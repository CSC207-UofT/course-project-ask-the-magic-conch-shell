package Mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.ArrayList;
import java.util.HashMap;

public class MongoDBStudentMethods implements IMongoDBStudentMethods {
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


}