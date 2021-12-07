package com.bookSystem.controller;
import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;
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


@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * Controller that allows a user to login.
     */

    @Autowired
    private IDBUserManager um;

    @Autowired
    private IMongoDBStudentMethods sm;

    @Autowired
    private IMongoDBStaffMethods sam;

    @Autowired
    private IUserLoginManager ulm;

    @GetMapping
    public String loadLogin() {


        return "login";
    }


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
    public String login(@RequestParam(defaultValue = "null", name = "user_type") String user_type,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password, Model model) {

        if (!Objects.equals(user_type, "null")) {
            if (Objects.equals(user_type, "student")) {
                if (sm.checkStudent(username)
                        && Objects.equals(password, um.studentDBGetPassword(username, sm))) {

                    Student currStudent = new Student(username);
                    currStudent.setPassword(um.studentDBGetPassword(username, sm));
                    currStudent.setCreditScore(um.DBGetCreditScore(username, sm));
                    currStudent.setBorrowingRecords(um.DBGetBorrowingRecord(username, sm));
                    ulm.setCurrentStudent(currStudent);

                    return "studentMenu";

                } else {
                    model.addAttribute("message", "Your username and password does not match, please try again");
                    return "login";
                }
            } else if (Objects.equals(user_type, "staff")) {
                if (sam.checkStaff(username)
                        && Objects.equals(password, um.staffDBGetPassword(username, sam))) {
                    Staff currStaff = new Staff(username);
                    currStaff.setPassword(um.studentDBGetPassword(username, sm));
                    ulm.setCurrentStaff(currStaff);
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

    @GetMapping("/studentMenu")
    public String loadStudentMenu(){
        return "studentMenu";
    }

    @GetMapping("/staffMenu")
    public String loadStaffMenu(){
        return "staffMenu";
    }





}
