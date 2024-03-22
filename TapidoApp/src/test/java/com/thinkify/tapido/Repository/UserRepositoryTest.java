package com.thinkify.tapido.Repository;

import com.thinkify.tapido.Models.Detail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserRepositoryTest
{
    private UserRepository userRepository;




    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Test
    public void getAllUsers()
    {
        List<Detail> details=this.userRepository.getAllUsers();
        Assertions.assertTrue(details.size()>=0);
    }

    @Test
    public void addUser()
    {
        int prev_size=this.userRepository.getAllUsers().size();
        this.userRepository.addUser("Rahul , M, 29");
        Assertions.assertTrue(prev_size<this.userRepository.getAllUsers().size());

    }

}
