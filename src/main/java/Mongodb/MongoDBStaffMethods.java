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
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("User");
        db.getCollection("Staff").insert(dbObject);
    }

    public static void deleteOriginal(DBObject dbObject){
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("User");
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
