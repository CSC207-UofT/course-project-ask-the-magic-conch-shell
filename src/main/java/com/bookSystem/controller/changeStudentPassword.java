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

public class changeStudentPassword {

    @Controller
    @RequestMapping("changeStudentPassword")
    public class LoginController {

        @Autowired
        private IDBUserManager um;

        @Autowired
        private IMongoDBStudentMethods sm;

        @GetMapping
        public String loadChangeStudentPassword() {

            return "changeStudentPassword";
        }

        @PostMapping("")
        public String changeStudentPassword(@RequestParam(defaultValue = "null", name = "user_type") String user_type,
                                            @RequestParam("username") String username,
                                            @RequestParam("oldPassword") String Opassword,
                                            @RequestParam("new_password") String Npassword1,
                                            @RequestParam("new_password2") String Npassword2, Model model) {
            if (Objects.equals(user_type, "student")) {
                if (sm.checkStudent(username)
                        && Objects.equals(Opassword, um.studentDBGetPassword(username, sm))
                        && Npassword1 == Npassword2) {
                    um.studentDBModifyPassword(username, Opassword, Npassword1, sm);
                    model.addAttribute("message", "Change successfully!");
                    return "changeStudentPassword";
                }
                else if (!Objects.equals(Opassword, um.studentDBGetPassword(username, sm))){
                    model.addAttribute("message", "Old password does not match!");
                    return "changeStudentPassword";
                }
                else if (Npassword1 != Npassword2) {
                    model.addAttribute("message", "New passwords do not match!");
                    return "changeStudentPassword";
                }
            return "changeStudentPassword";

        }
            return "changeStudentPassword";
        }
    }}
