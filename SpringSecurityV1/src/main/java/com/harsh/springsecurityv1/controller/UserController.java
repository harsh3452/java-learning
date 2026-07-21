package com.harsh.springsecurityv1.controller;

import com.harsh.springsecurityv1.model.Users;
import com.harsh.springsecurityv1.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public Users register(@RequestBody  Users user){
        return userService.register(user);
    }
}
