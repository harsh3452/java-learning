package com.harsh.notesapp.service;

import com.harsh.notesapp.dto.user.RegisterUserRequest;
import com.harsh.notesapp.dto.user.UserResponse;
import com.harsh.notesapp.exception.UserAlreadyExistException;
import com.harsh.notesapp.mapper.UserMapper;
import com.harsh.notesapp.model.User;
import com.harsh.notesapp.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    //cannot modify, class name is needed give identify to the log, Logger is the interface of slf4j, static it belongs to class, not objects;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    UserService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
            if(userRepo.findByUsername(registerUserRequest.getUsername()).isPresent()){
                logger.warn("Registration failed. Username '{}' already exists.", registerUserRequest.getUsername());
                throw new UserAlreadyExistException("User already exists! Please log in");
            }
            User user = UserMapper.toEntity(registerUserRequest);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("user");
            User savedUser =  userRepo.save(user);
            logger.info("User '{}' registered successfully", savedUser.getUsername());

            return UserMapper.toResponse(savedUser);
    }
}
