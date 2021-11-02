package Mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.HashMap;

public class MongoDBUserMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void update(String userName, String passWord){
        if (dataStored == null){
            System.out.println(1);
            MongoDB dataServer = new MongoDB();
            dataServer.store("UserTest","username");
            dataStored = dataServer.database;
        }

        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.replace(userName, dataStored.get(userName), newObject);

    }

    public static String getPassword(String UserName) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("UserTest","username");
            dataStored = dataServer.database;
        }

        return (String) dataStored.get(UserName).get("password");
    }

    public static void addUser(String userName, String passWord) {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("UserTest","username");
            dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.put(userName,newObject);
    }
}
