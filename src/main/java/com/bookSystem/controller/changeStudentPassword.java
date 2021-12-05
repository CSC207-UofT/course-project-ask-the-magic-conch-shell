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

        @Autowired
        private IMongoDBStaffMethods sam;

        @PostMapping("")
        public String changeStudentPassword(@RequestParam(defaultValue = "null", name = "user_type") String user_type, @RequestParam("username") String username,
                                            @RequestParam("oldPassword") String Opassword, @RequestParam("newPassword") String Npassword, Model model) {
            if (!Objects.equals(user_type, "null")) {
                if (Objects.equals(user_type, "student")) {
                    if (sm.checkStudent(username)
                            && Objects.equals(Opassword, um.studentDBGetPassword(username, sm))) {
                        um.studentDBModifyPassword(username, Opassword, Npassword, sm);
                        model.addAttribute("message", "Change successfully!");
                        return "changeStudentPassword";
                    }

                }

            }
            return "changeStudentPassword";
        }
    }}
