package com.thinkify.tapido.Controller;

import com.thinkify.tapido.Exceptions.ExceptionResponse;
import com.thinkify.tapido.Exceptions.RideNotFoundException;
import com.thinkify.tapido.Models.Pair;
import com.thinkify.tapido.Service.DriverService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tapido")
public class RideController
{
    private DriverService driverService;

    public RideController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/findRide/{user}/{source}/{destination}")
    public ResponseEntity<List<String>> findRide(@PathVariable String user,@PathVariable  String source ,@PathVariable String destination)
    {
        List<String> availableRides=this.driverService.findRide(user,source,destination);
        return new ResponseEntity<>(availableRides,HttpStatus.OK);

    }
    @GetMapping("/chooseRide/{user}/{driver}")
    public ResponseEntity<String> chooseRide(@PathVariable String user, @PathVariable String driver)
    {

        return ResponseEntity.ok(this.driverService.chooseRide(user,driver));

    }




}
