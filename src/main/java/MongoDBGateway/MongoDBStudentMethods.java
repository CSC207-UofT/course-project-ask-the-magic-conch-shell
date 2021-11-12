package MongoDBGateway;

import com.mongodb.*;

import java.util.HashMap;

public class MongoDBStudentMethods implements IMongoDBStudentMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("User");
        db.getCollection("Student").insert(dbObject);
    }

    public static void deleteOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("User");
        db.getCollection("Student").remove(dbObject);
    }
}