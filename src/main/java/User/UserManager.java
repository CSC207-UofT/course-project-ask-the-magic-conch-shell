package User;
import java.util.HashMap;

/**
 * Manage all Users (Student/Staff). Responsible for checking if a User is in the system, storing and deleting Users,
 * checking and modifying Students' credit score and changing Users' passwords.
 */

public class UserManager {
    private static HashMap<String, Student> all_student;
    private static HashMap<String, Staff> all_staff;


    public UserManager() {
        all_student = new HashMap<>();
        all_staff = new HashMap<>();
    }

    /**
     * To check whether the student currently exists in the system
     * @param username student's username
     * @return true if the student is in the system, otherwise false
     */

    public static boolean checkStudent(String username) {
        return all_student.containsKey(username);
    }

    /**
     * To check whether the staff currently exists in the system
     * @param username staff's username
     * @return true if the student is in the system, otherwise false
     */

    public boolean checkStaff(String username) {
        return all_staff.containsKey(username);
    }

        /**
         * Adds an instance of Staff to the overall list of Staffs
         * @param usertype usertype Staff
         * @param username staff's username
         * @return true if the new staff has now been successfully created, false otherwise
         */

    public boolean createNewUser(Staff usertype, String username) {
        if (!checkStaff(username)) {
            all_staff.put(username, usertype);
            return true;
        } else {
            return false;
        }
    }

        /**
         * Adds an instance of Student to the overall list of Students
         * @param usertype usertype Student
         * @param username student's username
         * @return true if the new staff has now been successfully created, false otherwise
         */
    public boolean createNewUser(Student usertype, String username) {
        if (!checkStudent(username)) {
            all_student.put(username, usertype);
            return true;
        } else {
            return false;
        }
    }

        /**
         * Delete a user from the overall list of Users
         * @param username username
         * @return true if the new staff has now been successfully deleted, false otherwise
         */

    public boolean deleteUser(String username) {
        if (checkStudent(username)) {
            all_student.remove(username);
            return true;
        } else {
            return false;
        }
    }

        /**
         * To check student's credit score
         * @param username student's username
         * @return student's credit score if username exists in the system, return -1 if username cannot be found
         */

    public int checkCreditScore(String username) {
        if (checkStudent(username)) {
            return all_student.get(username).CreditScoreGetter();
        }
        return -1;
    }

        /**
         * To modify student's credit score
         * @param username student's username
         * @param change_by change the credit score by "change_by" amount of credit
         */

    public void modifyCreditScore(String username, int change_by) {
        if (checkStudent(username)) {
            int old = all_student.get(username).CreditScoreGetter();
            all_student.get(username).CreditScoreSetter(old + change_by);
        }
    }

        /**
         * To modify student's password
         * @param username student's username
         * @param old_password student's old password
         * @param new_password student's new password
         */

    public void studentModifyPassword(String username, long old_password, long new_password) {
        if (checkStudent(username) && all_student.get(username).PasswordGetter(username) == old_password) {
            all_student.get(username).PasswordSetter(new_password);
        }
    }

        /**
         * To modify staff's password
         * @param username staff's username
         * @param new_password staff's new password
         */

    public void staffModifyPassword(String username, long new_password) {
        if (checkStaff(username)){
            all_staff.get(username).PasswordSetter(new_password);}
            else if(checkStudent(username)){
                all_student.get(username).PasswordSetter(new_password);
            }

        }

        /**
         * To check how many books a student is currently borrowing
         * @param username student's username
         * @return numbers of book a student is currently borrowing, return -1 if username cannot be found
         */

    public int BorrowedBookAmount(String username) {
        if (checkStudent(username)) {
            return all_student.get(username).CurrentBorrowingRecordsGetter().size();
        }
        return -1;
    }
    }


