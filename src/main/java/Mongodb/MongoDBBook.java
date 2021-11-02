package Mongodb;

import com.mongodb.*;

import java.util.HashMap;

public class MongoDBBook {
    public HashMap<String, DBObject> database;
    public DBCollection coll;
    public  void store(){
        try{
            MongoClient mongoclient = new MongoClient("localhost", 27017);
            DB db = mongoclient.getDB("local");
            System.out.println("MongoDB Connected");
            coll = db.getCollection("Book");
            DBCursor cursor = coll.find();
            database = new HashMap<String, DBObject>();
            while (cursor.hasNext()){
                DBObject data = cursor.next();
                database.put(data.get("name").toString(), data);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}