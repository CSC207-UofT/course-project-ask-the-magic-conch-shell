package com.bookSystem.mongoDBGateway;



public interface IMongoDBStaffMethods {
    void update(String userName, String passWord);

    String getPassword(String UserName);

    void addStaff(String userName, String passWord);

    boolean checkStaff(String userName);
}
