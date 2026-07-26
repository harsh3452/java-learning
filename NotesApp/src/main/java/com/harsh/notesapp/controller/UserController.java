package com.harsh.notesapp.controller;

import com.harsh.notesapp.model.User;
import com.harsh.notesapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
        private final UserService userService;
        UserController(UserService userService){
            this.userService = userService;
        }
        @PostMapping("/register")
        public ResponseEntity<User> registerUser(@RequestBody User user){
            User savedUser = userService.registerUser(user);
            if(savedUser == null){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
            }
        }
}
