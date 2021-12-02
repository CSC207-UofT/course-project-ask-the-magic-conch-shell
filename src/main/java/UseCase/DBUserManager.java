package UseCase;

import MongoDBGateway.IMongoDBStudentMethods;
import MongoDBGateway.IMongoDBStaffMethods;
import User.Staff;
import User.Student;

import java.util.ArrayList;

/**
 * Manage all Users (Student/Staff) in the MongoDB. Responsible for checking if a User is in the database, storing and
 * deleting Users, checking and updating Students' credit score and Users' passwords.
 */

public class DBUserManager implements IDBUserManager {

    /**
     To check whether the student currently exists in the database
     * @param username student's username
     * @param sum inject a mongodb student method interface and get methods from it
     * @return true if the student is in the system, otherwise false
     */

    @Override
    public boolean checkStudent(String username, IMongoDBStudentMethods sum) {
        return sum.checkStudent(username);

    }

    /**
     * To check whether the staff currently exists in the database
     * @param username staff's username
     * @param sm inject a mongodb staff method interface and get methods from it
     * @return true if the student is in the system, otherwise false
     */

    @Override
    public boolean checkStaff(String username, IMongoDBStaffMethods sm) {
        return sm.checkStaff(username);
    }


    /**
     * Adds an instance of Staff to the overall database of Staffs
     * @param staff staff entity created by login controller
     * @param sm inject a mongodb staff method interface and get methods from it
     * @return true if the new staff has now been successfully created, false otherwise
     */
    @Override
    public boolean createNewUser(Staff staff, IMongoDBStaffMethods sm) {
        String username = staff.UsernameGetter();
        String password = staff.PasswordGetter(username);
        if (!checkStaff(username, sm)) {

            sm.addStaff(username,password);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an instance of Student to the overall database of Students
     * @param student student entity created by login controller
     * @param sum inject a mongodb student method interface and get methods from it
     * @return true if the new user has been successfully created, false otherwise
     */
    @Override
    public boolean createNewUser(Student student, IMongoDBStudentMethods sum) {
        String username = student.UsernameGetter();
        String password = student.PasswordGetter(username);
        int cs = student.CreditScoreGetter();
        if (!checkStudent(username, sum)) {
            ArrayList<String> borrowRecord = new ArrayList<>(5);

            sum.addStudent(username, password, cs, borrowRecord);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete a student from the overall database of Users.
     * @param username username
     * @param sum inject a mongodb student method interface and get methods from it
     * @return whether the user has been successfully deleted, false otherwise
     */

    @Override
    public boolean deleteStudent(String username, IMongoDBStudentMethods sum) {
        if (checkStudent(username, sum)) {
            sum.deleteStudent(username);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * To get student's password stored in the database
     * @param username student's username
     * @param sum inject a mongodb student method interface and get methods from it
     * @return student's password if the student exist in the database, null otherwise
     */

    @Override
    public String studentDBGetPassword(String username, IMongoDBStudentMethods sum) {
        if (checkStudent(username, sum)) {
            String passwordString = sum.getPassword(username);
            return passwordString;

        }
        return null;
    }

    /**
     * To get staff's password stored in the database
     * @param username staff's username
     * @param sm inject a mongodb staff method interface and get methods from it
     * @return staff's password if the staff exist in the database, null otherwise
     */

    @Override
    public String staffDBGetPassword(String username, IMongoDBStaffMethods sm) {
        if (checkStaff(username, sm)) {
            String passwordString = sm.getPassword(username);
            return passwordString;

        }
        return null;
    }

    /**
     * To get student's credit score stored in the database
     * @param username student's username
     * @param sum inject a mongodb student method interface and get methods from it
     * @return student's credit score if the student exist in the database, null otherwise
     */

    @Override
    public Integer DBGetCreditScore(String username, IMongoDBStudentMethods sum) {
        if (checkStudent(username, sum)) {
            return sum.getCreditScore(username);

        }
        return null;
    }

    /**
     * To get student's current borrowing record stored in the database
     * @param username student's username
     * @param sum inject a mongodb student method interface and get methods from it
     * @return student's borrowing record if the student exist in the database, null otherwise
     */

    @Override
    public ArrayList<String> DBGetBorrowingRecord(String username, IMongoDBStudentMethods sum) {
        if (checkStudent(username, sum)) {
            return sum.getBorrowingHistory(username);

        }
        return null;
    }

    /**
     * To modify student's credit score
     * @param username student's username
     * @param changeBy change the credit score by "changeBy" amount of credit
     * @param sum inject a mongodb student method interface and get methods from it
     */

    @Override
    public void modifyDBCreditScore(String username, int changeBy, IMongoDBStudentMethods sum) {
        if (checkStudent(username, sum)) {
            int old = sum.getCreditScore(username);
            String pw = sum.getPassword(username);
            ArrayList<String> borrowRecord = sum.getBorrowingHistory(username);
            sum.update(username, pw, old + changeBy,borrowRecord);
        }

    }


    /**
     * To modify student's password stored in the database
     * @param username student's username
     * @param oldPassword student's old password
     * @param newPassword student's new password
     * @param sum inject a mongodb student method interface and get methods from it
     */

    @Override
    public void studentDBModifyPassword(String username, String oldPassword, String newPassword, IMongoDBStudentMethods sum) {
        String oldPw = oldPassword;
        if (checkStudent(username, sum) && sum.getPassword(username).equals(oldPw)) {
            int cs = sum.getCreditScore(username);
            ArrayList<String> borrowRecord = sum.getBorrowingHistory(username);
            String newPw = newPassword;
            sum.update(username,  newPw, cs, borrowRecord);

        }
    }

    /**
     * To modify student's current borrowing record stored in the database
     * @param username student's username
     * @param newBR new Current Borrowing Record for the student
     * @param sum inject a mongodb student method interface and get methods from it
     */

    @Override
    public void studentDBModifyBorrowRecord(String username, ArrayList<String> newBR, IMongoDBStudentMethods sum) {
        if (checkStudent(username, sum)) {
            String pw = sum.getPassword(username);
            int cs = sum.getCreditScore(username);
            sum.update(username, pw, cs, newBR);

        }
    }


    /**
     * To modify staff's password stored in the database
     * @param username staff's username
     * @param oldPassword staff's old password
     * @param sm inject a mongodb staff method interface and get methods from it
     * @param newPassword staff's new password
     */

    @Override
    public void staffDBModifyPassword(String username, String oldPassword, String newPassword, IMongoDBStaffMethods sm) {
        String oldPw = oldPassword;
        if (checkStaff(username, sm) && sm.getPassword(username).equals(oldPw)) {

            String newPw = newPassword;
            sm.update(username, newPw);

        }

    }



}