package com.bookSystem.controller;

import com.bookSystem.entity.User.Staff;
import com.bookSystem.entity.User.Student;
import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.useCase.IDBUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("create")
public class createUserController {

    @Autowired
    private IDBUserManager um;

    @Autowired
    private IMongoDBStudentMethods sm;

    @Autowired
    private IMongoDBStaffMethods sam;



    @GetMapping
    public String loadCreateNewUser() {


        return "createNewUser";
    }

    @PostMapping("")
    public String createNewUser(@RequestParam("createNewUser") String desired_username,
                                @RequestParam(defaultValue = "null", name = "user_type") String user_type, Model model) {

        if (Objects.equals(user_type, "null")){
            model.addAttribute("message", "Please select a user type you wish to create" +
                    "account for");
        }

        else{

        if (um.checkStudent(desired_username, sm) || um.checkStaff(desired_username, sam)) {
            model.addAttribute("message", "The username you picked already exists, please" +
                    "try another username, we recommend to add some numbers after the username to avoid conflicting " +
                    "username");
            return "createNewUser";
        }
        else{
            if (Objects.equals(user_type, "student")){
                Student s = new Student(desired_username);
                String pass = randomPasswordGenerator();
                s.setPassword(pass);
                s.setCreditScore(100);
                ArrayList<Integer> br = new ArrayList<>();
                s.setBorrowingRecords(br);
                um.createNewUser(s, sm);
                model.addAttribute("message", "You have successfully created an student" +
                        " account with username:" + desired_username + " "+ "and your temporary password is:" + pass);
                return "createNewUser";
            }

            else if (Objects.equals(user_type, "staff")){
                Staff s = new Staff(desired_username);
                String pass = randomPasswordGenerator();
                s.setPassword(pass);
                um.createNewUser(s, sam);
                model.addAttribute("message", "You have successfully created an staff" +
                        " account with username:" + desired_username + " "+ "and your temporary password is:" + pass);
                return "createNewUser";
            }
        }

        }
        return "createNewUser";
    }

/**
 *
 * @return return a random length 5, all capital letter temporary password.
 */

    public static String randomPasswordGenerator() {
        return getString();

    }

/**
 * @return return the desired 5 string long temporary password for the randomPasswordGenerator
 */

    private static String getString() {
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
