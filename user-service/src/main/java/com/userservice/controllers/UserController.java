package com.userservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.models.UserRequest;
import com.userservice.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserRequest userRequest)
    {
        System.out.println("User Created");
        System.out.println(userRequest);
        userService.saveUser(userRequest);
    }
}
