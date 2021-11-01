package Mongodb;


import com.mongodb.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MongoDBUser {
    public static HashMap<String, DBObject> database;
    public static void main(String[] args){
        try{
            MongoClient mongoclient = new MongoClient("localhost", 27017);
            DB db = mongoclient.getDB("local");
            System.out.println("MongoDB Connected");
            DBCollection coll = db.getCollection("User");
            DBCursor cursor = coll.find();
            database = new HashMap<String, DBObject>();
            while (cursor.hasNext()){
                DBObject data = cursor.next();
                database.put(data.get("username").toString(), data);
            }

            System.out.println(database.keySet());
            System.out.println(database.get("sky").get("password"));
            MongoDBUser.update("sky","1111");
            System.out.println(database.get("sky").get("password"));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void update(String userName, String passWord){
        MongoClient mongoclient = new MongoClient("localhost", 27017);
        DB db = mongoclient.getDB("local");
        System.out.println("MongoDB Connected");
        DBCollection coll = db.getCollection("User");

        BasicDBObject oldData = new BasicDBObject();
        oldData.put(userName,database.get(userName).get("password"));
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put(userName, passWord); // (2)

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument); // (3)

        coll.update(oldData, updateObject); // (4)
    }
}
