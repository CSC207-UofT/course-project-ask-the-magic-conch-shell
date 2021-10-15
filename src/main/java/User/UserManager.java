package User;
import User.User;
import User.Student;
import User.Staff;


import java.util.HashMap;


public class UserManager {
    private static HashMap<String, Student> all_student;
    private static HashMap<String, Staff> all_staff;


    public UserManager() {
        all_student = new HashMap<>();
        all_staff = new HashMap<>();
    }


    public static boolean check_student(String username) {
        return all_student.containsKey(username);
    }

    public boolean check_staff(String username) {
        return all_staff.containsKey(username);
    }


    public boolean create_new_user(Staff usertype, String username) {
        if (!check_staff(username)) {
            all_staff.put(username, usertype);
            return true;
        } else {
            return false;
        }
    }

    public boolean create_new_user(Student usertype, String username) {
        if (!check_student(username)) {
            all_student.put(username, usertype);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete_user(String username) {
        if (check_student(username)) {
            all_student.remove(username);
            return true;
        } else {
            return false;
        }
    }


    public int check_credit_score(String username) {
        if (check_student(username)) {
            return all_student.get(username).CreditScoreGetter();
        }
        return -1;
    }


    public void modify_credit_score(String username, int change_by) {
        if (check_student(username)) {
            int old = all_student.get(username).CreditScoreGetter();
            all_student.get(username).CreditScoreSetter(old + change_by);
        }
    }

    public void student_modify_password(String username, long old_password, long new_password) {
        if (check_student(username) && all_student.get(username).PasswordGetter(username) == old_password) {
            all_student.get(username).PasswordSetter(new_password);
        }
    }

    public void staff_modify_password(String username, long new_password) {
        if (check_staff(username)){
            all_staff.get(username).PasswordSetter(new_password);}
            else if(check_student(username)){
                all_student.get(username).PasswordSetter(new_password);
            }

        }
    }


