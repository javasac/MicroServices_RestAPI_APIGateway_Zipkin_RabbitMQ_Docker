package com.sachin.Users.service;
import com.sachin.Users.model.CreateUserRequest;
import com.sachin.Users.shared.UserDTO;

public interface UserService
{
    UserDTO createUser(UserDTO udto);
}
