package com.example.secyrity.controller;

import com.example.secyrity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
@RequestMapping("/user")
public class userCon {

    private UserService userService;

    public userCon(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserInfo(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
        return "user/user";
    }
}
