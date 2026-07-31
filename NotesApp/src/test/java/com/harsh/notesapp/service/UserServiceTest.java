package com.harsh.notesapp.service;

import com.harsh.notesapp.dto.user.RegisterUserRequest;
import com.harsh.notesapp.dto.user.UserResponse;
import com.harsh.notesapp.exception.UserAlreadyExistException;
import com.harsh.notesapp.model.User;
import com.harsh.notesapp.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepo userRepo;
    @Mock
    private BCryptPasswordEncoder passwordEncoder;
    @InjectMocks
    private UserService userService;

    @Test
    void shouldRegisterUserSuccessfully(){
        // ---------- Arrange ----------

        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("harsh");
        request.setPassword("password123");

        User savedUser = new User();
        savedUser.setUsername(request.getUsername());
        savedUser.setPassword("encoded-password");
        savedUser.setRole("user");

        when(userRepo.findByUsername(request.getUsername()))
                .thenReturn(Optional.empty());

        when(passwordEncoder.encode(request.getPassword()))
                .thenReturn("encoded-password");

        when(userRepo.save(any(User.class)))
                .thenReturn(savedUser);

        // ---------- Act ----------
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class) ;
        UserResponse response = userService.registerUser(request);

        assertEquals(request.getUsername(), response.getUsername());
        verify(userRepo).save(captor.capture());
        verify(passwordEncoder).encode(anyString());
        verify(userRepo).findByUsername(request.getUsername());
        User capturedUser = captor.getValue();
        assertEquals(savedUser.getUsername(),capturedUser.getUsername());
        assertEquals("encoded-password",capturedUser.getPassword());
        assertEquals(savedUser.getRole(),capturedUser.getRole());
    }

    @Test
    void shouldThrowUserAlreadyExistExceptionWhenUsernameAlreadyExists(){
        //arranging the request body to send;
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("harsh");
        request.setPassword("password123");

        //prepared response to be sent when called
        User existingUser = new User();
        existingUser.setUsername(request.getUsername());

        when(userRepo.findByUsername(request.getUsername())).thenReturn(Optional.of(existingUser));

        UserAlreadyExistException exception = assertThrows(UserAlreadyExistException.class,()->userService.registerUser(request));
        assertEquals("User already exists! Please log in",
                exception.getMessage());
        verify(userRepo).findByUsername(request.getUsername());
        verify(userRepo,never()).save(any(User.class));
        verify(passwordEncoder, never()).encode(anyString());

    }
}
