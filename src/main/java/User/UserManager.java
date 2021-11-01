package User;
import User.User;
import User.Student;
import User.Staff;


import java.util.HashMap;

    /**
     * user manager
     */
public class UserManager {
    /**
     * stores all students
     */
    private static HashMap<String, Student> all_student;
    /**
     *  stores all staffs
     */
    private static HashMap<String, Staff> all_staff;


    public UserManager() {
        all_student = new HashMap<>();
        all_staff = new HashMap<>();
    }

    /**
     *
     * @param username username
     * @return whether the student exists in the system
     */

    public static boolean check_student(String username) {
        return all_student.containsKey(username);
    }

    /**
     *
     * @param username username
     * @return whether the staff exists in the system
     */

    public boolean check_staff(String username) {
        return all_staff.containsKey(username);
    }

        /**
         *
         * @param usertype usertype (Staff/Student)
         * @param username username
         * @return whether the new user has been successfully created
         */

    public boolean create_new_user(Staff usertype, String username) {
        if (!check_staff(username)) {
            all_staff.put(username, usertype);
            return true;
        } else {
            return false;
        }
    }

        /**
         *
         * @param usertype usertype (Student/Staff)
         * @param username username
         * @return whether the new user has been successfully created
         */
    public boolean create_new_user(Student usertype, String username) {
        if (!check_student(username)) {
            all_student.put(username, usertype);
            return true;
        } else {
            return false;
        }
    }

        /**
         *
         * @param username username
         * @return whether the user has been successfully deleted
         */

    public boolean delete_user(String username) {
        if (check_student(username)) {
            all_student.remove(username);
            return true;
        } else {
            return false;
        }
    }

        /**
         *
         * @param username username
         * @return credit score
         */

    public int check_credit_score(String username) {
        if (check_student(username)) {
            return all_student.get(username).CreditScoreGetter();
        }
        return -1;
    }

        /**
         *
         * @param username username
         * @param change_by change the credit score by "change_by" amount of credit
         */

    public void modify_credit_score(String username, int change_by) {
        if (check_student(username)) {
            int old = all_student.get(username).CreditScoreGetter();
            all_student.get(username).CreditScoreSetter(old + change_by);
        }
    }

        /**
         *
         * @param username username
         * @param old_password old password
         * @param new_password new password
         */

    public void student_modify_password(String username, long old_password, long new_password) {
        if (check_student(username) && all_student.get(username).PasswordGetter(username) == old_password) {
            all_student.get(username).PasswordSetter(new_password);
        }
    }

        /**
         *
         * @param username username
         * @param new_password new password
         */

    public void staff_modify_password(String username, long new_password) {
        if (check_staff(username)){
            all_staff.get(username).PasswordSetter(new_password);}
            else if(check_student(username)){
                all_student.get(username).PasswordSetter(new_password);
            }

        }

        /**
         *
         * @param username username
         * @return numbers of currently borrowed book
         */

    public int BorrowedBookAmount(String username) {
        if (check_student(username)) {
            return all_student.get(username).CurrentBorrowingRecordsGetter().size();
        }
        return -1;
    }
    }


