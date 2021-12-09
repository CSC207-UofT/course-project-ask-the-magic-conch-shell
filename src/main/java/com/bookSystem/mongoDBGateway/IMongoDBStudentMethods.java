package com.bookSystem.mongoDBGateway;


import java.util.ArrayList;

/**
 * Interface for methods in MongoDBStudentMethods.
 */
public interface IMongoDBStudentMethods {

    void update(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords);

    String getPassword(String UserName);

    Integer getCreditScore(String UserName);

    ArrayList<String> getBorrowingHistory(String UserName);

    void deleteStudent(String userName);

    void addStudent(String userName, String passWord, Integer creditScore, ArrayList<String> borrowingRecords);

    boolean checkStudent(String userName);
}
