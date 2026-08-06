package com.userservice.service;

import org.springframework.stereotype.Service;

import com.userservice.repository.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepo;

    public UserService(UserRepository userRepository)
    {
        this.userRepo = userRepository;
    }
    
}
