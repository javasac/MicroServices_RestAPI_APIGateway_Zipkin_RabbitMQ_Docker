package com.sachin.Users.controller;
import com.sachin.Users.model.CreateUserRequest;
import com.sachin.Users.model.CreateUserResponse;
import com.sachin.Users.service.UserServiceImpl;
import com.sachin.Users.shared.UserDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersControllers
{
    @Autowired
    private Environment env;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/status")
    public String status()
    {
        return "Working on port = " + env.getProperty("local.server.port");
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest cr)
    {
        ModelMapper mm = new ModelMapper();
        mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDTO userDTO = mm.map(cr, UserDTO.class);
        UserDTO createduserDTO = userService.createUser(userDTO);
        CreateUserResponse cur = mm.map(createduserDTO, CreateUserResponse.class);

        System.out.println("Create User body is " + cr);
        return ResponseEntity.status(HttpStatus.CREATED).body(cur);
    }
}
