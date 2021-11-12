package MongoDBGateway;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


public interface IMongoDBStaffMethods {
    static void update(String userName, String passWord) {
        if (MongoDBStaffMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff", "username");
            MongoDBStaffMethods.dataStored = dataServer.database;
        }
        DBObject delete = MongoDBStaffMethods.dataStored.get(userName);
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        MongoDBStaffMethods.dataStored.replace(userName, MongoDBStaffMethods.dataStored.get(userName), newObject);
        MongoDBStaffMethods.deleteOriginal(delete);
        MongoDBStaffMethods.addToOriginal(newObject);

    }

    static String getPassword(String UserName) {
        if (MongoDBStaffMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff", "username");
            MongoDBStaffMethods.dataStored = dataServer.database;
        }

        return (String) MongoDBStaffMethods.dataStored.get(UserName).get("password");
    }

    static void addStaff(String userName, String passWord) {
        if (MongoDBStaffMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff", "username");
            MongoDBStaffMethods.dataStored = dataServer.database;
        }
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        MongoDBStaffMethods.dataStored.put(userName, newObject);
        MongoDBStaffMethods.addToOriginal(newObject);
    }

    static boolean checkStaff(String userName) {
        if (MongoDBStaffMethods.dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff", "username");
            MongoDBStaffMethods.dataStored = dataServer.database;
        }
        return MongoDBStaffMethods.dataStored.containsKey(userName);
    }
}
