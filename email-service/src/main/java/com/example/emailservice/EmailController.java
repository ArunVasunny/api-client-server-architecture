package com.example.emailservice;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EmailController {
        @GetMapping("/email/welcome/{userId}")
        public String sendWelcomeEmail(@PathVariable String userId) {
            return "Email sent to user ID: " +userId;
        }
        
}
