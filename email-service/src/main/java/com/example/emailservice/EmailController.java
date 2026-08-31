package com.example.emailservice;

import org.springframework.web.bind.annotation.RestController;

import com.example.emailservice.model.UserResponse;
import com.example.emailservice.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EmailController {

    private UserService userService;

    public EmailController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/email/welcome/{userId}")
    public String sendWelcomeEmail(@PathVariable int userId) {
        
        UserResponse userResponse = userService.getUserById(userId);
        String emailTemplate = """
                Hi %s,
                Welcome !
                Your email %s
                Is now registered.

                Thank You !
                """.formatted(userResponse.name(),userResponse.email());
        System.out.println(emailTemplate);
        return "Email sent to " + userResponse.email();
    }
        
}
