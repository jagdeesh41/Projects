package com.thinkify.tapido.Service;

import com.thinkify.tapido.Models.Detail;
import com.thinkify.tapido.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public void addUserDetails(String userDetail)
    {
        this.userRepository.addUser(userDetail);

    }

    @Override
    public List<Detail> getAllUsers()
    {
        return this.userRepository.getAllUsers();
    }
}
