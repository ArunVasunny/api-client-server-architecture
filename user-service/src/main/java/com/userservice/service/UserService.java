package com.userservice.service;

import org.springframework.stereotype.Service;

import com.userservice.entity.User;
import com.userservice.models.UserRequest;
import com.userservice.repository.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepo;

    public UserService(UserRepository userRepository)
    {
        this.userRepo = userRepository;
    }

    public User saveUser(UserRequest userRequest)
    {
        User user = new User(userRequest.name(), userRequest.email());
        return userRepo.save(user);
    }
    
}
