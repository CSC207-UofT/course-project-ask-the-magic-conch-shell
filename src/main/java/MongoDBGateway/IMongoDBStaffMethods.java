package MongoDBGateway;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


public interface IMongoDBStaffMethods {
    public void update(String userName, String passWord);

    public String getPassword(String UserName);

    public void addStaff(String userName, String passWord);

    public boolean checkStaff(String userName);
}
