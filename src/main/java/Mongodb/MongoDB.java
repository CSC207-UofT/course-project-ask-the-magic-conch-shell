
package Mongodb;

import com.mongodb.*;

import java.util.HashMap;
import java.util.Map;

public class MongoDB {
    public static HashMap<String, DBObject> database;
    public static void main(String[] args){
        try{
            MongoClient mongoclient = new MongoClient("localhost", 27017);
            DB db = mongoclient.getDB("local");
            System.out.println("MongoDB Connected");
            DBCollection coll = db.getCollection("book");
            DBCursor cursor = coll.find();
            database = new HashMap<String, DBObject>();
            while (cursor.hasNext()){
                DBObject data = cursor.next();

                database.put(data.get("name").toString(), data);
                //System.out.println(database);

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
