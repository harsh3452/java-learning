package com.harsh.notesapp.service;

import com.harsh.notesapp.model.User;
import com.harsh.notesapp.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User registerUser(User user){
        Optional<User> existingUser = userRepo.findByUsername(user.getUsername());
        if(existingUser.isEmpty()){
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRole("user");
            return userRepo.save(user);
        } else {
            return null;
        }
    }
}
