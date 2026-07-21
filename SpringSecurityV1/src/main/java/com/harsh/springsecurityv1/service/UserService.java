package com.harsh.springsecurityv1.service;

import com.harsh.springsecurityv1.model.Users;
import com.harsh.springsecurityv1.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;
    private BCryptPasswordEncoder encorder = new BCryptPasswordEncoder(12);
    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public Users register(Users user){
        user.setPassword(encorder.encode(user.getPassword()));
         return userRepo.save(user);
    }
}
