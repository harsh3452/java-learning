package com.harsh.notesapp.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequest {
    @NotBlank
    @Size(min = 4, max = 50, message = "username should be between 4 and 50 characters long!")
    private String username;
    @NotBlank // ignoring max and min length of password for now and also we can add message here
    private String password;
}
