package com.thinkify.tapido.Service;

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
        return  this.driverRepository.findRide(user,source,destination);

    }

    @Override
    public String chooseRide(String userName, String driverName)
    {
        return this.driverRepository.chooseRide(userName,driverName);
    }
}
