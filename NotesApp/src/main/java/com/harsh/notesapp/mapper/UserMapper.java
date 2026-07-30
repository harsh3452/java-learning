package com.harsh.notesapp.mapper;

import com.harsh.notesapp.dto.user.RegisterUserRequest;
import com.harsh.notesapp.dto.user.UserResponse;
import com.harsh.notesapp.model.User;

public class UserMapper {
    public static User toEntity(RegisterUserRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }
    public static UserResponse toResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        return userResponse;
    }
}
