package Mongodb;


import com.mongodb.*;
import org.bson.Document;

import java.util.HashMap;
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
                database.put(data.get("userName").toString(), data);
                //System.out.println(data.get("userName"));
            }
            System.out.println(database.keySet());
            System.out.println(database.get("sky").get("passWord"));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void update(String userName, String passWord){
        // TODO: 2021-11-01  o
//        MongoClient mongoclient = new MongoClient("localhost", 27017);
//        DB db = mongoclient.getDB("local");
//        System.out.println("MongoDB Connected");
//        DBCollection coll = db.getCollection("User");
//        Document found = (Document) coll.find (new DB("userName",userName)).first();
//
//        BasicDBObject newDocument = new BasicDBObject();
//        newDocument.put("hostingName", "goDaddy"); // (2)
//
//        BasicDBObject updateObject = new BasicDBObject();
//        updateObject.put("$set", newDocument); // (3)
//
//        db.getCollection("webHostInfo").updateOne(query, updateObject); // (4)
    }
}
