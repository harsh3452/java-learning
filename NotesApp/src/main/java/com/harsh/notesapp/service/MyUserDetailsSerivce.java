package com.harsh.notesapp.service;

import com.harsh.notesapp.model.User;
import com.harsh.notesapp.config.UserPrincipal;
import com.harsh.notesapp.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsSerivce implements UserDetailsService {
    private final UserRepo userRepo;


    public MyUserDetailsSerivce(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        if(user.isPresent()){
            return new UserPrincipal(user.get());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
