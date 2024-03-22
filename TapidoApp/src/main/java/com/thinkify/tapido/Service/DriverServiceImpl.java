package com.thinkify.tapido.Service;

import com.thinkify.tapido.Exceptions.RideNotFoundException;
import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Models.Pair;
import com.thinkify.tapido.Repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService
{
    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }

    @Override
    public void addDriverDetails(String driver_details,String vehicle_details,String  currentLocation)
    {
        this.driverRepository.add_driver(driver_details,vehicle_details,currentLocation);
        System.out.println(currentLocation+getClass().getSimpleName());

    }

    @Override
    public List<DriverDetail> getAllDrivers()
    {
        return this.driverRepository.getAllDrivers();

    }

    @Override
    public List<String> findRide(String user, String source, String destination)
    {
        List<String> rides=this.driverRepository.findRide(user,source,destination);
        if(rides.isEmpty())
        {
            throw new RideNotFoundException("No ride found -Near By Drivers Not Found");
        }
        return rides;

    }

    @Override
    public String chooseRide(String userName, String driverName)
    {

        String message=this.driverRepository.chooseRide(userName,driverName);
        if(message==null)
        {
            throw new RideNotFoundException("Cant Find Ride -All Drivers are Occupied");
        }
        return message;
    }
}
