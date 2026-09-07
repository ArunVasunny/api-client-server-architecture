package com.example.emailservice.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.example.emailservice.model.UserRequest;
import com.example.emailservice.model.UserResponse;

@Service
public class UserService {
    
    RestClient restClient = RestClient.create();
    
    public UserResponse getUserById(int id)
    {   
        UserResponse userResponse = restClient
                                    .get()
                                    .uri("http://localhost:8080/api/v1/users/{id}",id)
                                    .retrieve()
                                    .body(UserResponse.class);
        return userResponse;
    }

    public UserResponse createUser(UserRequest userRequest)
    {
        UserResponse userResponse = restClient
                                    .post()
                                    .uri("http://localhost:8080/api/v1/users")
                                    .body(userRequest)
                                    .retrieve()
                                    .body(UserResponse.class);
        return userResponse;
    }
}
