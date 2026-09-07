package com.example.emailservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.emailservice.model.UserRequest;
import com.example.emailservice.model.UserResponse;
import com.example.emailservice.service.UserService;

@SpringBootApplication
public class EmailserviceApplication implements CommandLineRunner{

	private final UserService userService;

    public EmailserviceApplication(UserService userService)
	{
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserResponse admin = userService.createUser(new UserRequest("admin", "admin@google.com"));
		System.out.println(admin);
	}

}
