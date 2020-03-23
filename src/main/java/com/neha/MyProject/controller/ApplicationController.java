package com.neha.MyProject.controller;

import com.neha.MyProject.Services.UserService;
import com.neha.MyProject.modal.User;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class ApplicationController {

    @Autowired
    UserService userService;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        System.out.println("hiiii");
        request.setAttribute("mode","MODE_HOME");
        return "welcome";
    }

    @RequestMapping("/register")
    public  String register(HttpServletRequest request){
        request.setAttribute("mode","MODE_REGISTER");
        return "welcome";
    }

    @PostMapping("/save-user")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request){
        System.out.println("inside save-user");
        userService.saveMyUser(user);
        request.setAttribute("users",userService.showAllUsers());
        request.setAttribute("mode","ALL_USERS");
        return "welcome";
    }

    @GetMapping("/show-users")
    public String showAllUsers(HttpServletRequest request){
        request.setAttribute("users",userService.showAllUsers());
        request.setAttribute("mode","ALL_USERS");
        return  "welcome";
    }

    @RequestMapping("/delete-user")
    public String deleteUser(@RequestParam int id, HttpServletRequest request){
        userService.deleteMyUser(id);
        request.setAttribute("users",userService.showAllUsers());
        request.setAttribute("mode","ALL_USERS");
        return "welcome";
    }

    /*@RequestMapping("/edit-user")
    public String editUser(@RequestParam int id,HttpServletRequest request){
        Optional<User> user= userService.editMyUser(id);
        request.setAttribute("user",userService.editMyUser(id));
        request.setAttribute("mode","MODE_UPDATE");
        return "/welcome";
    }
*/
}
