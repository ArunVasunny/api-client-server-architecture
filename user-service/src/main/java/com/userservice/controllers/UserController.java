package com.userservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.userservice.entity.User;
import com.userservice.models.UserRequest;
import com.userservice.models.UserResponse;
import com.userservice.service.UserService;
import java.net.URI;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
    {
        System.out.println(userRequest);
        User user = userService.saveUser(userRequest);
        UserResponse userRespo = new UserResponse(user.getId(), user.getName(), user.getEmail());
        // return ResponseEntity.status(HttpStatus.CREATED).body(userRespo);
        return ResponseEntity.created(URI.create("/api/v1/users" + user.getId())).body(userRespo);
    }
}
