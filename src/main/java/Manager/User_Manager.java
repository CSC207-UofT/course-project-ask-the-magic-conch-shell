package Manager;
import User.User;
import User.Student;
import User.Staff;


import java.util.HashMap;

package User;

public class User_Manager {
    private final HashMap<String, Student> all_student;
    private final HashMap<String, Staff> all_staff;


    public User_Manager() {
        this.all_student = new HashMap<String, Student>();
        this.all_staff = new HashMap<String, Staff>();
    }


    public boolean check_student(String username) {
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

    public void store_all_user() {
        //TODO
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


