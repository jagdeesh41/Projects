package com.thinkify.tapido.Service;

import com.thinkify.tapido.Models.Detail;

import java.util.List;

public interface UserService {
    void addUserDetails(String userDetail);

    List<Detail> getAllUsers();
}
