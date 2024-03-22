package com.thinkify.tapido.Controller;
import com.thinkify.tapido.Models.Detail;
import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tapido")
public class UserController
{
    private UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping("/addUser/{userDetail}")
    public void addUserDetails(@PathVariable String userDetail)
    {

        this.userService.addUserDetails(userDetail);
    }
    @GetMapping("/getUsers")
    public ResponseEntity<List<Detail>> getAllDrivers()
    {

        List<Detail>userDetails=this.userService.getAllUsers();
        System.out.println(userDetails);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }












}
