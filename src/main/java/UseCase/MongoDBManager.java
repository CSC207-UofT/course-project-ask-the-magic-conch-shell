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

public class MongoDBManager {

    public MongoDBManager() {

    }

    /**
     To check whether the student currently exists in the database
     * @param username student's username
     * @return true if the student is in the system, otherwise false
     */

    public static boolean checkStudent(String username) {
        return IMongoDBStudentMethods.checkStudent(username);

    }

    /**
     * To check whether the staff currently exists in the database
     * @param username staff's username
     * @return true if the student is in the system, otherwise false
     */

    public static boolean checkStaff(String username) {
        return IMongoDBStaffMethods.checkStaff(username);
    }


    /**
     * Adds an instance of Staff to the overall database of Staffs
     * @param staff staff entity created by login controller
     * @return true if the new staff has now been successfully created, false otherwise
     */
    public boolean createNewUser(Staff staff) {
        String username = staff.UsernameGetter();
        Long password = staff.PasswordGetter(username);
        if (!checkStaff(username)) {
            String pw = Long.toString(password);
            IMongoDBStaffMethods.addStaff(username,pw);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an instance of Student to the overall database of Students
     * @param student student entity created by login controller
     * @return true if the new user has been successfully created, false otherwise
     */
    public boolean createNewUser(Student student) {
        String username = student.UsernameGetter();
        Long password = student.PasswordGetter(username);
        int cs = student.CreditScoreGetter();
        if (!checkStudent(username)) {
            ArrayList<String> borrowRecord = new ArrayList<>(5);
            String pw = Long.toString(password);
            IMongoDBStudentMethods.addStudent(username, pw, cs, borrowRecord);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Delete a student from the overall database of Users.
     * @param username username
     * @return whether the user has been successfully deleted, false otherwise
     */

    public boolean deleteStudent(String username) {
        if (checkStudent(username)) {
            IMongoDBStudentMethods.deleteStudent(username);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * To modify student's credit score
     * @param username student's username
     * @param changeBy change the credit score by "changeBy" amount of credit
     */

    public void modifyDBCreditScore(String username, int changeBy) {
        if (checkStudent(username)) {
            int old = IMongoDBStudentMethods.getCreditScore(username);
            String pw = IMongoDBStudentMethods.getPassword(username);
            ArrayList<String> borrowRecord = IMongoDBStudentMethods.getBorrowingHistory(username);
            IMongoDBStudentMethods.update(username, pw, old + changeBy,borrowRecord);
        }

    }


    /**
     * To modify student's password stored in the database
     * @param username student's username
     * @param oldPassword student's old password
     * @param newPassword student's new password
     */

    public void studentDBModifyPassword(String username, long oldPassword, long newPassword) {
        String oldPw = Long.toString(oldPassword);
        if (checkStudent(username) && IMongoDBStudentMethods.getPassword(username).equals(oldPw)) {
            int cs = IMongoDBStudentMethods.getCreditScore(username);
            ArrayList<String> borrowRecord = IMongoDBStudentMethods.getBorrowingHistory(username);
            String newPw = Long.toString(newPassword);
            IMongoDBStudentMethods.update(username,  newPw, cs, borrowRecord);

        }
    }

    /**
     * To modify student's password stored in the database
     * @param username student's username
     * @param newBR new Current Borrowing Record for the student
     */

    public void studentDBModifyBorrowRecord(String username, ArrayList<String> newBR) {
        if (checkStudent(username)) {
            String pw = IMongoDBStudentMethods.getPassword(username);
            int cs = IMongoDBStudentMethods.getCreditScore(username);
            IMongoDBStudentMethods.update(username, pw, cs, newBR);

        }
    }


    /**
     * To modify staff's password stored in the database
     * @param username staff's username
     * @param oldPassword staff's old password
     * @param newPassword staff's new password
     */

    public void staffDBModifyPassword(String username, long oldPassword, long newPassword) {
        String oldPw = Long.toString(oldPassword);
        if (checkStaff(username) && IMongoDBStaffMethods.getPassword(username).equals(oldPw)) {

            String newPw = Long.toString(newPassword);
            IMongoDBStaffMethods.update(username, newPw);

        }

    }



}
