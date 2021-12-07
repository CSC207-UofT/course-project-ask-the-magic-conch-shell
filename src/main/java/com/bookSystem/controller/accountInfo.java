package com.bookSystem.controller;

import com.bookSystem.entity.User.Student;
import com.bookSystem.useCase.IDBUserManager;
import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("info")
public class accountInfo {

    @Autowired
    private IUserLoginManager ulm;

    @GetMapping
    public String loadInfo(Model model) {
        Student s = ulm.getCurrentStudent();
        String username = s.getUsername();
        String str = "Username:" + username;
        model.addAttribute("message", str);


        return "studentInfo";
    }
}

