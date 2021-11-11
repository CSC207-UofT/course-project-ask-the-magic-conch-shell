package User;


import Mongodb.IMongoDBStudentMethods;
import Mongodb.IMongoDBStaffMethods;

import java.util.HashMap;
import java.util.ArrayList;


    /**
     * Manage all Users (Student/Staff). Responsible for checking if a User is in the system, storing and deleting Users,
     * checking and modifying Students' credit score and changing Users' passwords.
     */

public class UserManager {

    IMongoDBStudentMethods studentMethods;
    IMongoDBStaffMethods staffMethods;


    public UserManager() {

    }

    /**
     To check whether the student currently exists in the system
     * @param username student's username
     * @return true if the student is in the system, otherwise false
     */

    public static boolean checkStudent(String username) {
        return IMongoDBStudentMethods.checkStudent(username);

    }

    /**
     * To check whether the staff currently exists in the system
     * @param username staff's username
     * @return true if the student is in the system, otherwise false
     */

    public boolean checkStaff(String username) {
        return IMongoDBStaffMethods.checkStaff(username);
    }


    /**
     * Adds an instance of Staff to the overall list of Staffs
     * @param password staff's password
     * @param username staff's username
     * @return whether the new staff has now been successfully created, false otherwise
     */

    public boolean createNewStaff(String username, long password) {
        if (!checkStaff(username)) {
            String pw = Long.toString(password);
            IMongoDBStaffMethods.addStaff(username,pw);
            return true;
        } else {
            return false;
        }
    }

        /**
         * Adds an instance of Student to the overall list of Students
         * @param password student's password
         * @param username student's username
         * @return whether the new user has been successfully created, false otherwise
         */
    public boolean createNewStudent(String username, long password) {
        if (!checkStudent(username)) {
            int cs = 100;
            ArrayList<String> borrowRecord = new ArrayList<>(5);
            String pw = Long.toString(password);
            IMongoDBStudentMethods.addStudent(username, pw, cs, borrowRecord);
            return true;
        } else {
            return false;
        }
    }

        /**
         * Delete a user from the overall list of Users.
         * @param username username
         * @return whether the user has been successfully deleted, false otherwise
         */

    public boolean deleteUser(String username) {
        if (checkStudent(username)) {
            IMongoDBStudentMethods.deleteStudent(username);
            return true;
        } else {
            return false;
        }
    }

        /**
         * To check student's credit score
         * @param username username
         * @return student's credit score if username exists in the system, return -1 if username cannot be found
         */

    public int checkCreditScore(String username) {
        if (checkStudent(username)) {
            return IMongoDBStudentMethods.getCreditScore(username);
        }
        return -1;
    }

        /**
         * To modify student's credit score
         * @param username student's username
         * @param changeBy change the credit score by "changeBy" amount of credit
         */

    public void modifyCreditScore(String username, int changeBy) {
        if (checkStudent(username)) {
            int old = IMongoDBStudentMethods.getCreditScore(username);
            String pw = IMongoDBStudentMethods.getPassword(username);
            ArrayList<String> borrowRecord = IMongoDBStudentMethods.getBorrowingHistory(username);
            IMongoDBStudentMethods.update(username, pw, old + changeBy,borrowRecord);
        }

    }

        /**
         * To modify student's password
         * @param username student's username
         * @param oldPassword student's old password
         * @param newPassword student's new password
         */

    public void studentModifyPassword(String username, long oldPassword, long newPassword) {
        String oldPw = Long.toString(oldPassword);
        if (checkStudent(username) && IMongoDBStudentMethods.getPassword(username).equals(oldPw)) {
            int cs = IMongoDBStudentMethods.getCreditScore(username);
            ArrayList<String> borrowRecord = IMongoDBStudentMethods.getBorrowingHistory(username);
            String newPw = Long.toString(newPassword);
            IMongoDBStudentMethods.update(username,  newPw, cs, borrowRecord);

        }
    }

        /**
         * To modify staff's password
         * @param username staff's username
         * @param oldPassword staff's old password
         * @param newPassword staff's new password
         */

    public void staffModifyPassword(String username, long oldPassword, long newPassword) {
        String oldPw = Long.toString(oldPassword);
        if (checkStaff(username) && IMongoDBStaffMethods.getPassword(username).equals(oldPw)) {

            String newPw = Long.toString(newPassword);
            IMongoDBStaffMethods.update(username, newPw);

        }

        }

        /**
         * To check how many books a student is currently borrowing
         * @param username student's username
         * @return numbers of book a student is currently borrowing, return -1 if username cannot be found
         */

    public int BorrowedBookAmount(String username) {
        if (checkStudent(username)) {
            return IMongoDBStudentMethods.getBorrowingHistory(username).size();
        }
        return -1;
    }
    }


