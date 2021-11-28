package controller;
import MongoDBGateway.IMongoDBStaffMethods;
import MongoDBGateway.IMongoDBStudentMethods;
import MongoDBGateway.MongoDBStaffMethods;
import MongoDBGateway.MongoDBStudentMethods;
import UseCase.*;
import Entity.User.Staff;
import Entity.User.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("login")
public class LoginController {
    private Object IDBUserManager;
    private Object Student;

    /**
     * create a new account and add into our database
     * @param user_type the user type of this to be created account
     * @param username the username of the account
     */
    public void creatNewUser(String user_type, String username){
        if (Objects.equals(user_type, "Student")){
            String pass = randomPasswordGenerator();
            Student s = new Student(username);
            s.PasswordSetter(pass);
            IMongoDBStudentMethods sm = new MongoDBStudentMethods();
            IDBUserManager um = new DBUserManager();

            um.createNewUser(s, sm);
        }
        else if (Objects.equals(user_type, "Staff")){
            String pass = randomPasswordGenerator();
            Staff s = new Staff(username);
            s.PasswordSetter(pass);
            IMongoDBStaffMethods sm = new MongoDBStaffMethods();
            IDBUserManager um = new DBUserManager();
            um.createNewUser(s, sm);

    }}


    /**
     * login method will return true if the username exist in the database and the input password matches the record
     * in the database, else return false, as the login is unsuccessful.
     * @param user_type type of the account that is requesting to log in.
     * @param username username
     * @param password password
     * @return return true is the username exist in our database and the password match with the username, return
     * false otherwise
     */
    public boolean login(String user_type, String username, long password){
        IMongoDBStudentMethods sm = new MongoDBStudentMethods();
        IMongoDBStaffMethods sam = new MongoDBStaffMethods();
        IDBUserManager um = new DBUserManager();

            if (Objects.equals(user_type, "Student")){
                if(sm.checkStudent(username)
                        && Objects.equals(password, um.studentDBGetPassword(username, sm))){
                    Student s = new Student(username);
                    s.PasswordSetter(um.studentDBGetPassword(username, sm));
                    s.CreditScoreSetter(um.DBGetCreditScore(username, sm));
                    s.borrowingRecordsSetter(um.DBGetBorrowingRecord(username, sm));
                    UserLoginManager currStudent = new UserLoginManager(s);
                    return true;

                }
            }

            else if (Objects.equals(user_type, "Staff")){
                if(sam.checkStaff(username)
                        && Objects.equals(password, um.staffDBGetPassword(username, sam))){
                    Staff s = new Staff(username);
                    s.PasswordSetter(um.studentDBGetPassword(username, sm));
                    UserLoginManager currStaff = new UserLoginManager(s);
                    return true;
                }
            }

            return false;

    }


    /**
     *
     * @param curr_user the logged-in user
     * @param new_password the new password that replace the old one
     */
    public void changePassword(UserLoginManager curr_user, String new_password){
        if (curr_user.currentStudent != null){
            curr_user.studentModifyPassword(curr_user.currentStudent.UsernameGetter(),
                    curr_user.currentStudent.getPassword(), new_password);
        }

        else if (curr_user.currentStaff != null){
            curr_user.staffModifyPassword(curr_user.currentStaff.UsernameGetter(),
                    curr_user.currentStaff.getPassword(), new_password);
        }

    }

    /**
     *
     * @return return a random length 5, all capital letter temporary password.
     */
    private String randomPasswordGenerator() {
        return getString();

    }

    /**
     * @return return the desired long temporary password for the randomPasswordGenerator
     */
    private String getString() {
        String ran_pick_lst = "QWERTYUIOPASDFGHJKLZXCVBNM";
        Random ran = new Random();
        String pass = "";
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));
        pass += ran_pick_lst.charAt(ran.nextInt(ran_pick_lst.length() - 1));

        return pass;
    }
}
