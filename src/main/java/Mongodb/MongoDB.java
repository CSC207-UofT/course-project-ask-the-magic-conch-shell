package Mongodb;


import com.mongodb.*;
import java.util.HashMap;



public class MongoDB {
    public  HashMap<String, DBObject> database;
    public DBCollection coll;
    public  void store(String collectionName, String keyname){
        try{
            MongoClient mongoclient = new MongoClient("localhost", 27017);
            DB db = mongoclient.getDB("local");
            System.out.println("MongoDB Connected");
            coll = db.getCollection(collectionName);
            DBCursor cursor = coll.find();
            database = new HashMap<String, DBObject>();
            while (cursor.hasNext()){
                DBObject data = cursor.next();
                database.put(data.get(keyname).toString(), data);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}