package com.bookSystem.controller;

import com.bookSystem.entity.User.Staff;
import com.bookSystem.useCase.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("staffInfo")
public class staffInfoController {

    @Autowired
    private IUserLoginManager ulm;

    @GetMapping
    public String loadPage(Model model){

        Staff s = ulm.getCurrentStaff();
        model.addAttribute("username", s.getUsername());
        return "staffInfo";
    }
}
