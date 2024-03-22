package com.thinkify.tapido.Controller;
import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tapido")
public class DriverController
{
    private DriverService driverService;
    @Autowired
    public DriverController(DriverService driverService)
    {
        this.driverService=driverService;
    }
    @PostMapping("/addDriver/{driverDetails}/{vehicleDetails}/{currentLocation}")
    public void addDriverDetails(@PathVariable String driverDetails,
                                 @PathVariable String vehicleDetails,
                                 @PathVariable String currentLocation)
    {
        this.driverService.addDriverDetails(driverDetails,vehicleDetails,currentLocation);


    }
    @GetMapping("/getDrivers")
    public ResponseEntity<List<DriverDetail>> getAllDrivers()
    {
        List<DriverDetail>driverDetails=this.driverService.getAllDrivers();
        return new ResponseEntity<>(driverDetails, HttpStatus.OK);
    }









}
