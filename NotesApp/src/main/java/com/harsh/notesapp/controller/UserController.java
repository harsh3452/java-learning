package com.harsh.notesapp.controller;

import com.harsh.notesapp.dto.user.RegisterUserRequest;
import com.harsh.notesapp.dto.user.UserResponse;
import com.harsh.notesapp.service.UserService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
        private final UserService userService;
        UserController(UserService userService){
            this.userService = userService;
        }

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("/register")
        public UserResponse registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest){
            return userService.registerUser(registerUserRequest);
        }
}
