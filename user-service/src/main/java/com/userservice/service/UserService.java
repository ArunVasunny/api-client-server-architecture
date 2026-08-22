package com.userservice.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.userservice.entity.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.models.UserRequest;
import com.userservice.models.UserResponse;
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
    
    public UserResponse getUserById(Long id)
    {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with ID = " + id + " not found"));
        UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getEmail());
        return userResponse;
    }
}
