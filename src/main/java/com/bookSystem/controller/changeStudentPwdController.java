package com.bookSystem.controller;

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

import java.util.Random;

@Controller
@RequestMapping("changeOtherPwd")
public class changeStudentPwdController {

    /**
     * Controller class for staff to change student's password.
     */

    @Autowired
    private IDBUserManager um;

    @Autowired
    private IMongoDBStudentMethods sm;

    @Autowired
    private IMongoDBStaffMethods sam;


    @GetMapping
    public String loadPage() {

        return "changeStudentPassword";
    }

    /**
     * Method that can change student's password.
     * @param username student's username
     * @param model for Spring boot
     * @return "changeStudentPassword" page
     */
    @PostMapping
    public String changeStudentPwd(@RequestParam("userName") String username, Model model){
        if (!sm.checkStudent(username)){
            model.addAttribute("message", "the account you wish to change password for " +
                    "does not exist");

        }
        else {
            String newPwd = createUserController.randomPasswordGenerator();
            String oldPwd = um.studentDBGetPassword(username, sm);
            um.studentDBModifyPassword(username, oldPwd, newPwd, sm);
            model.addAttribute("message", "Your password has been successfully changed, " +
                    "the temporary password is:" + newPwd);

        }
    return "changeStudentPassword";
    }}






