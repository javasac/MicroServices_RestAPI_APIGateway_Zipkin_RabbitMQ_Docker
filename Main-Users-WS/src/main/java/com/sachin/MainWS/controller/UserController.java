package com.sachin.MainWS.controller;
import com.sachin.MainWS.exception.UserServiceException;
import com.sachin.MainWS.response.UserUpdate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.sachin.MainWS.response.UserResponse;
import com.sachin.MainWS.response.UserRequest;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@RestController
@RequestMapping("/users")
@Validated
public class UserController
{
    Map<String, UserResponse> users;

    @GetMapping("/all")
    public Map getUsers()
    {
        return users;
    }

    @GetMapping
    public String getUser(@RequestParam(value = "page", required = false) int page,
                          @RequestParam(value = "limit", defaultValue = "100") int limit,
                          @RequestParam(value = "sort", required = false) String sort)
    {
        return "Page = " + page + " and Limit = " + limit + " and Sort = " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId)
    {
        if (true)
        {
            throw new UserServiceException("A user service exception is thrown.");
        }

        if (users.containsKey(userId))
        {
            return new ResponseEntity<UserResponse>(users.get(userId), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(path = "/add", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserRequest u)
    {
        UserResponse newUser = new UserResponse();
        newUser.setEmail(u.getEmail());
        newUser.setFirstName(u.getFirstName());
        newUser.setLastName(u.getLastName());

        String userId = UUID.randomUUID().toString();
        newUser.setUserId(userId);

        if (users==null)
        {
            users = new HashMap<>();
        }

        users.put(userId, newUser);
        return new ResponseEntity<UserResponse>(newUser, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdate u)
    {
        System.out.println("update method = " + u.getFirstName());
        UserResponse ur = users.get(userId);

        ur.setFirstName(u.getFirstName());
        ur.setLastName(u.getLastName());

        users.put(userId, ur);
        return ur;
    }
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId)
    {
        if (users.containsKey(userId))
        {
            users.remove(userId);
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
