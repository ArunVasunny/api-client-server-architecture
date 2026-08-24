package com.userservice.service;

import java.util.ArrayList;
import java.util.List;
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

    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : allUsers) {
            userResponseList.add(new UserResponse(user.getId(), user.getName(), user.getEmail()));
        }
        return userResponseList;
    }

    public void deleteById(Long id)
    {
        userRepo.deleteById(id);
    }

    public UserResponse updateUserById(Long id,UserRequest userRequest)
    {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with ID = " + id + " not found"));
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        User savedUser = userRepo.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
