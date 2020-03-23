package com.neha.MyProject.controller;

import com.neha.MyProject.Services.UserService;
import com.neha.MyProject.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String hello() {
        return  "this is home page";
    }

    @GetMapping("/saveuser")
    public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password){
        User user=new User(username,firstname,lastname,age,password);
        userService.saveMyUser(user);
        return "User Saved";
    }
}
