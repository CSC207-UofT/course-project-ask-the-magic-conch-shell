package com.bookSystem.controller;

import com.bookSystem.mongoDBGateway.IMongoDBStudentMethods;
import com.bookSystem.useCase.IDBUserManager;
import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("studentChange")

public class StudentChangePasswordController {

        @Autowired
        private IDBUserManager um;

        @Autowired
        private IMongoDBStudentMethods sm;

        @Autowired
        private IUserLoginManager ulm;

        @GetMapping
        public String loadChangeStudentPassword() {

            return "studentChangePassword";
        }

        @PostMapping()
        public String changeStudentPassword(@RequestParam("oldPassword") String Opassword,
                                            @RequestParam("new_password") String Npassword1,
                                            @RequestParam("new_password2") String Npassword2, Model model) {
            if (Objects.equals(Opassword, um.studentDBGetPassword(ulm.getCurrentStudent().getUsername(), sm))
                    && Npassword1.equals(Npassword2)) {
                um.studentDBModifyPassword(ulm.getCurrentStudent().getUsername(), Opassword, Npassword1, sm);
                model.addAttribute("message", "Change successfully!");
                return "studentChangePassword";
                }
            else if (!Objects.equals(Opassword, um.studentDBGetPassword(ulm.getCurrentStudent().getUsername(), sm))){
                model.addAttribute("message", "Old password does not match!");
                return "studentChangePassword";
                }
            else if (!Npassword1.equals(Npassword2)) {
                model.addAttribute("message", "New passwords do not match!");
                return "studentChangePassword";
                }
            return "studentChangePassword";

        }
        }
