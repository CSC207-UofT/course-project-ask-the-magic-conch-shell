package com.bookSystem.controller;

import com.bookSystem.mongoDBGateway.IMongoDBStaffMethods;
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

public class changeStaffPassword {

    @Controller
    @RequestMapping("staffChangePassword")
    public class changeStaffPasswordController {

        @Autowired
        private IDBUserManager um;

        @Autowired
        private IMongoDBStaffMethods sam;

        @Autowired
        private IUserLoginManager ulm;

        @GetMapping
        public String loadChangeStaffPassword() {

            return "staffChangePassword";
        }

        @PostMapping("")
        public String changeStaffPassword(@RequestParam("oldPassword") String Opassword,
                                          @RequestParam("new_password") String Npassword1,
                                          @RequestParam("new_password2") String Npassword2, Model model) {
            if (Objects.equals(Opassword, um.staffDBGetPassword((ulm.getCurrentStaff().getUsername()), sam))
                    && Npassword1.equals(Npassword2)) {
                um.staffDBModifyPassword(ulm.getCurrentStaff().getUsername(), Opassword, Npassword1, sam);
                model.addAttribute("message", "Change successfully!");
                return "staffChangePassword";
            }
            else if (!Objects.equals(Opassword, um.staffDBGetPassword(ulm.getCurrentStudent().getUsername(), sam))){
                model.addAttribute("message", "Old password does not match!");
                return "staffChangePassword";
            }
            else if (!Npassword1.equals(Npassword2)) {
                model.addAttribute("message", "New passwords do not match!");
                return "staffChangePassword";
            }
            return "staffChangePassword";
        }
    }}
