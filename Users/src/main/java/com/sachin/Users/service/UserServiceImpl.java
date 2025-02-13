package com.sachin.Users.service;
import com.sachin.Users.model.UsersTBL;
import com.sachin.Users.repository.UsersRepository;
import com.sachin.Users.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDetails)
    {
        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper mm = new ModelMapper();
        mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UsersTBL usersTBL = mm.map(userDetails, UsersTBL.class);
        usersTBL.setEncryptedPassword(UUID.randomUUID().toString());
        usersRepository.save(usersTBL);

        return userDetails;
    }
}
