package com.valerych.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.valerych.services.UserService;

@RestController
public class MainController {

    private UserService userService;

    @Autowired
    public void setUserService (UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/")
    public String homePage(){
        return "<h1>Home Page</>";
    }

    @RequestMapping("/adminpanel")
    public String adminPage(){
        return "<h1>Admin Panel</>";
    }

    @RequestMapping("/profile")
    public String profilePage(){
        return "<h1>Profile Page</>";
    }
}
