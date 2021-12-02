package MongoDBGateway;
import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.HashMap;

public class MongoDBStaffMethods implements IMongoDBStaffMethods {
    public static HashMap<String, DBObject> dataStored;

    public static void addToOriginal(DBObject dbObject){
        DB db = getDb();
        db.getCollection("Staff").insert(dbObject);
    }

    private static DB getDb() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Hewitt:C*gh8%40f8R*9Hw%40U@cluster0.hmi0f.mongodb.net/User?retryWrites=true&w=majority");
        MongoClient mongoclient = new MongoClient(uri);
        return mongoclient.getDB("User");
    }

    public static void deleteOriginal(DBObject dbObject){
        DB db = getDb();
        db.getCollection("Staff").remove(dbObject);
    }

    public void update(String userName, String passWord) {
        checkNone();
        DBObject delete = MongoDBStaffMethods.dataStored.get(userName);
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.replace(userName, dataStored.get(userName), newObject);
        MongoDBStaffMethods.deleteOriginal(delete);
        MongoDBStaffMethods.addToOriginal(newObject);

    }

    private void checkNone() {
        if (dataStored == null) {
            MongoDB dataServer = new MongoDB();
            dataServer.store("Staff", "username");
            dataStored = dataServer.database;
        }
    }

    public String getPassword(String UserName) {
        checkNone();
        return (String) dataStored.get(UserName).get("password");
    }

    public void addStaff(String userName, String passWord) {
        checkNone();
        DBObject newObject = new BasicDBObject();
        newObject.put("username", userName);
        newObject.put("password", passWord);
        dataStored.put(userName, newObject);
        MongoDBStaffMethods.addToOriginal(newObject);
    }

    public boolean checkStaff(String userName) {
        checkNone();
        return dataStored.containsKey(userName);
    }

}
