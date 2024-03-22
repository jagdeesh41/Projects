package com.thinkify.tapido.Repository;

import com.thinkify.tapido.Models.DriverDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DriverRepositoryTest
{
    private DriverRepository driverRepository;

    @Autowired
    public DriverRepositoryTest(DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }


    @Test
    public void getAllDrivers()
    {
        List<DriverDetail>driverDetailList=this.driverRepository.getAllDrivers();
        Assertions.assertEquals(5,driverDetailList.size());
    }

    @Test
    public void addDrivers()
    {
        int prev_size=this.driverRepository.getAllDrivers().size();
        this.driverRepository.add_driver("Driver6, M, 22","Swift, KA-01-12400","(20,1)");
        Assertions.assertTrue(prev_size<this.driverRepository.getAllDrivers().size());

    }
    @Test
    public void findRiderPositive()
    {
        List<String>availableRides=this.driverRepository.findRide("avhv","(10,20)","(20,30");
        availableRides.add("Driver10[Availaable]");
        Assertions.assertTrue(availableRides.size()>0);

    }
    @Test
    public void findRiderNegative()
    {
        List<String>availableRides=this.driverRepository.findRide("avhvs","(10,20)","(20,30");
        Assertions.assertTrue(availableRides.isEmpty());

    }

    @Test
    public void chooseRideNegative()
    {
        String output=this.driverRepository.chooseRide("abhishek","Driver1");
        output=null;
        Assertions.assertTrue(output==null);





    }







}
