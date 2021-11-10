package Mongodb;


import com.mongodb.*;
import com.mongodb.client.MongoClients;

import java.security.cert.CollectionCertStoreParameters;
import java.util.HashMap;
import java.util.Objects;


public class MongoDB {
    public  HashMap<String, DBObject> database;
    public DBCollection coll;
    public  void store(String collectionName, String keyname){
        try{
            MongoClient mongoclient = (MongoClient) MongoClients.create("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
            DB db;
            if (Objects.equals(collectionName, "book")) {
                db = mongoclient.getDB("Book");
            } else {
                db = mongoclient.getDB("User");
            }
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