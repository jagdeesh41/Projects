package com.thinkify.tapido.Repository;

import com.thinkify.tapido.Models.Detail;
import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Models.Pair;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository
{
    List<Detail> userDetails=new ArrayList<>();

    {
        userDetails.add(new Detail("Abhishek, M, 23"));
        userDetails.add(new Detail("Rahul , M, 29"));
        userDetails.add(new Detail("Nandini, F, 22"));
    }




    public  void addUser(String user)
    {
        Detail userDetail=new Detail(user);

        userDetails.add(userDetail);
    }

    public List<Detail> getAllUsers()
    {
        return this.userDetails;
    }





}
