package MongoDBGateway;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MongoDBStudentMethods implements IMongoDBStudentMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("Entity/User");
        db.getCollection("Student").insert(dbObject);
    }

    public static void deleteOriginal(DBObject dbObject) {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        DB db = mongoclient.getDB("Entity/User");
        db.getCollection("Student").remove(dbObject);
    }

    public void update(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords){
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        DBObject delete = dataStored.get(userName);
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        newObject.put("creditscore", creditScore);
        newObject.put("borrowedbook", borrowingRecords);
        dataStored.replace(userName, dataStored.get(userName), newObject);
        MongoDBStudentMethods.deleteOriginal(delete);
        MongoDBStudentMethods.addToOriginal(newObject);
    }

    public String getPassword(String UserName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(UserName).get("password");

    }

    public Integer getCreditScore(String UserName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }

        return (Integer) dataStored.get(UserName).get("creditscore");
    }

    public ArrayList<String> getBorrowingHistory(String UserName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }

        return (ArrayList<String>) dataStored.get(UserName).get("borrowedbook");
    }

    public void deleteStudent(String userName) {

        if (checkStudent(userName)) {
            MongoDBStudentMethods.deleteOriginal(MongoDBStudentMethods.dataStored.get(userName));
            dataStored.remove(userName);

        }
    }

    public void addStudent(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        newObject.put("creditscore", creditScore);
        newObject.put("borrowedbook", borrowingRecords);
        dataStored.put(userName, newObject);
        MongoDBStudentMethods.addToOriginal(newObject);
    }

    @Override
    public boolean checkStudent(String userName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            dataStored = dataServer.database;
        }
        return dataStored.containsKey(userName);
    }
}