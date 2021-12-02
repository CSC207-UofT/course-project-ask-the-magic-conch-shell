package com.bookSystem.controller;
import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.useCase.IDBUserManager;
import com.bookSystem.useCase.IUserLoginManager;
import com.bookSystem.useCase.UserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IDBUserManager um;

    @Autowired
    private IMongoDBStudentMethods sm;

    @Autowired
    private IMongoDBStaffMethods sam;

    @GetMapping
    public String loadLogin() {


        return "login";
    }

    /*
     */
/**
 * create a new account and add into our database
 * @param user_type the user type of this to be created account
 * @param username the username of the account
 *//*

    public void creatNewUser(String user_type, String username){
        if (Objects.equals(user_type, "Student")){
            String pass = randomPasswordGenerator();
            Student s = new Student(username);
            s.setPassword(pass);
            IMongoDBStudentMethods sm = new MongoDBStudentMethods();
            IDBUserManager um = new DBUserManager();

            um.createNewUser(s, sm);
        }
        else if (Objects.equals(user_type, "Staff")){
            String pass = randomPasswordGenerator();
            Staff s = new Staff(username);
            s.setPassword(pass);
            IMongoDBStaffMethods sm = new MongoDBStaffMethods();
            IDBUserManager um = new DBUserManager();
            um.createNewUser(s, sm);

        }}
*/


    /**
     * login method will return true if the username exist in the database and the input password matches the record
     * in the database, else return false, as the login is unsuccessful.
     *
     * @param user_type type of the account that is requesting to log in.
     * @param username  username
     * @param password  password
     * @return return true is the username exist in our database and the password match with the username, return
     * false otherwise
     */
    @PostMapping("")
    public String login(@RequestParam(defaultValue = "null", name = "user_type") String user_type, @RequestParam("username") String username,
                        @RequestParam("password") String password, Model model) {

        if (!Objects.equals(user_type, "null")) {
            if (Objects.equals(user_type, "student")) {
                if (sm.checkStudent(username)
                        && Objects.equals(password, um.studentDBGetPassword(username, sm))) {

                    UserLoginManager currStudent = new UserLoginManager(username, um.studentDBGetPassword(username, sm),
                            um.DBGetCreditScore(username, sm), um.DBGetBorrowingRecord(username, sm));
                    return "studentMenu";

                } else {
                    model.addAttribute("message", "Your username and password does not match, please try again");
                    return "login";
                }
            } else if (Objects.equals(user_type, "staff")) {
                if (sam.checkStaff(username)
                        && Objects.equals(password, um.staffDBGetPassword(username, sam))) {
                    UserLoginManager currStaff = new UserLoginManager(username, um.studentDBGetPassword(username, sm));
                    return "staffMenu";
                } else {
                    model.addAttribute("message", "Your username and password does not match, please try again");
                    return "login";
                }
            }
        } else {
            model.addAttribute("message", "Please select a user type");

            return "login";
        }
        return "login";

    }

/*
    @PutMapping()
    public String forgetPassword(Model model) {
        model.addAttribute("message", "if you are a student, please reach out to a staff " +
                "member at the front desk, they will help out with the password reset process \n" +
                "if you are a staff member, please reach out to admin at IT");
        return "login";
    }
*/



    /*

     */
/**
 *
 * @param curr_user the logged-in user
 * @param new_password the new password that replace the old one
 *//*

    public void changePassword(UserLoginManager curr_user, String new_password){
        if (curr_user.currentStudent != null){
            curr_user.studentModifyPassword(curr_user.currentStudent.getUsername(),
                    curr_user.currentStudent.getPassword(), new_password);
        }

        else if (curr_user.currentStaff != null){
            curr_user.staffModifyPassword(curr_user.currentStaff.getUsername(),
                    curr_user.currentStaff.getPassword(), new_password);
        }

    }

    */
/**
 *
 * @return return a random length 5, all capital letter temporary password.
 *//*

    private String randomPasswordGenerator() {
        return getString();

    }

    */
/**
 * @return return the desired long temporary password for the randomPasswordGenerator
 *//*

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
*/
}