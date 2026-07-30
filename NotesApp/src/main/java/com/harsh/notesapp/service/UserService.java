package com.harsh.notesapp.service;

import com.harsh.notesapp.dto.user.RegisterUserRequest;
import com.harsh.notesapp.dto.user.UserResponse;
import com.harsh.notesapp.exception.UserAlreadyExistException;
import com.harsh.notesapp.mapper.UserMapper;
import com.harsh.notesapp.model.User;
import com.harsh.notesapp.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    UserService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
            if(userRepo.findByUsername(registerUserRequest.getUsername()).isPresent()){
                throw new UserAlreadyExistException("User already exists! Please log in");
            }
            User user = UserMapper.toEntity(registerUserRequest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("user");
            User savedUser =  userRepo.save(user);
            return UserMapper.toResponse(savedUser);
    }
}
