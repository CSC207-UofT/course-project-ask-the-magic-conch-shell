package com.bookSystem.useCase;

import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;

import java.util.ArrayList;

public interface IDBUserManager {

    /**
     * Public interface of DBUserManager.
     */

    boolean checkStudent(String username, IMongoDBStudentMethods sum);

    boolean checkStaff(String username, IMongoDBStaffMethods sm);

    boolean createNewUser(Staff staff, IMongoDBStaffMethods sm);

    boolean createNewUser(Student student, IMongoDBStudentMethods sum);

    boolean deleteStudent(String username, IMongoDBStudentMethods sum);

    String studentDBGetPassword(String username, IMongoDBStudentMethods sum);

    String staffDBGetPassword(String username, IMongoDBStaffMethods sm);

    Integer DBGetCreditScore(String username, IMongoDBStudentMethods sum);

    ArrayList<Integer> DBGetBorrowingRecord(String username, IMongoDBStudentMethods sum);

    void modifyDBCreditScore(String username, int changeBy, IMongoDBStudentMethods sum);

    void studentDBModifyPassword(String username, String oldPassword, String newPassword, IMongoDBStudentMethods sum);

    void studentDBModifyBorrowRecord(String username, ArrayList<Integer> newBR, IMongoDBStudentMethods sum);

    void staffDBModifyPassword(String username, String oldPassword, String newPassword, IMongoDBStaffMethods sm);



}
