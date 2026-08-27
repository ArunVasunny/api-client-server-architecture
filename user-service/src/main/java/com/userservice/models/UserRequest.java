package com.userservice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
    
    @NotBlank(message = "name should not be blank")
    String name, 

    @NotBlank(message = "email should not be blank")
    @Email
    String email

){}
