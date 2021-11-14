package MongoDBGateway;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.ArrayList;


public interface IMongoDBStudentMethods {

    public void update(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords);

    public String getPassword(String UserName);

    public Integer getCreditScore(String UserName);

    public ArrayList<String> getBorrowingHistory(String UserName);

    public void deleteStudent(String userName);

    public void addStudent(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords);

    public boolean checkStudent(String userName);
}
