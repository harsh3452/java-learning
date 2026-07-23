package com.harsh.springsecurityv1.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.harsh.springsecurityv1.model.Users;
import com.harsh.springsecurityv1.repo.UserRepo;

@Service
public class UserService {
    private UserRepo userRepo;
    private AuthenticationManager authManager;
    private JWTService jwtService;

    private BCryptPasswordEncoder encorder = new BCryptPasswordEncoder(12);

    UserService(UserRepo userRepo, AuthenticationManager authManager, JWTService jwtService) {
        this.userRepo = userRepo;
        this.authManager = authManager;
        this.jwtService=jwtService;
    }

    public Users register(Users user){
        user.setPassword(encorder.encode(user.getPassword()));
         return userRepo.save(user);
    }

    public String verify(Users user) {
         Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
         if(authentication.isAuthenticated()){
             return jwtService.generateToken(user.getUsername());
         } else {
             return "Failed";
         }
    }
}
