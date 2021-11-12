package MongoDBGateway;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.ArrayList;

public interface IMongoDBStudentMethods {
    static void update(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords){
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            MongoDBStudentMethods.dataStored = dataServer.database;
        }
        DBObject delete = MongoDBStudentMethods.dataStored.get(userName);
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        newObject.put("creditscore", creditScore);
        newObject.put("borrowedbook", borrowingRecords);
        MongoDBStudentMethods.dataStored.replace(userName, MongoDBStudentMethods.dataStored.get(userName), newObject);
        MongoDBStudentMethods.deleteOriginal(delete);
        MongoDBStudentMethods.addToOriginal(newObject);
    }

    static String getPassword(String UserName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            MongoDBStudentMethods.dataStored = dataServer.database;
        }

        return (String) MongoDBStudentMethods.dataStored.get(UserName).get("password");

    }

    static Integer getCreditScore(String UserName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            MongoDBStudentMethods.dataStored = dataServer.database;
        }

        return (Integer) MongoDBStudentMethods.dataStored.get(UserName).get("creditscore");
    }

    static ArrayList<String> getBorrowingHistory(String UserName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            MongoDBStudentMethods.dataStored = dataServer.database;
        }

        return (ArrayList<String>) MongoDBStudentMethods.dataStored.get(UserName).get("borrowedbook");
    }

    static void deleteStudent(String userName) {

        if (checkStudent(userName)) {
            MongoDBStudentMethods.deleteOriginal(MongoDBStudentMethods.dataStored.get(userName));
            MongoDBStudentMethods.dataStored.remove(userName);

        }

    }

    static void addStudent(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            MongoDBStudentMethods.dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        newObject.put("creditscore", creditScore);
        newObject.put("borrowedbook", borrowingRecords);
        MongoDBStudentMethods.dataStored.put(userName, newObject);
        MongoDBStudentMethods.addToOriginal(newObject);
    }

    static boolean checkStudent(String userName) {
        if (MongoDBStudentMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Student", "username");
            MongoDBStudentMethods.dataStored = dataServer.database;
        }
        return MongoDBStudentMethods.dataStored.containsKey(userName);
    }
}
