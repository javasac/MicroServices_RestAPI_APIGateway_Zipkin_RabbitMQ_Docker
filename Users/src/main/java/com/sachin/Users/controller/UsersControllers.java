package com.sachin.Users.controller;
import com.sachin.Users.model.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersControllers
{
    @Autowired
    private Environment env;

    @GetMapping("/status")
    public String status()
    {
        return "Working on port = " + env.getProperty("local.server.port");
    }

    @PostMapping("/create")
    public String createUser(@Valid @RequestBody CreateUserRequest cr)
    {
        System.out.println("Create User body is " + cr);
        return cr.toString();
    }
}
