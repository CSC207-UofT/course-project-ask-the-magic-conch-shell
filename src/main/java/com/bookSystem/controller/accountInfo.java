package com.bookSystem.controller;

import com.bookSystem.useCase.IDBUserManager;
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
    private IDBUserManager ulm;

    @GetMapping
    public String loadInfo(Model model) {
        ulm.

        model.addAttribute("message", "");


        return "studentInfo";
    }
}

