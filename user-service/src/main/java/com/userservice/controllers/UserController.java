package com.userservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.models.UserRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class UserController {
    
    @PostMapping("/users")
    public void createUser(@RequestBody UserRequest userRequest)
    {
        System.out.println("User Created");
        System.out.println(userRequest);
    }
}
