package com.thinkify.tapido.Repository;

import com.thinkify.tapido.Models.Detail;
import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Models.Pair;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class DriverRepository
{
    List<DriverDetail> driverDetailList=new ArrayList<>();

    {
//        String  driver_details,String vehicle_details,String current_location
//        “Driver1, M, 22”,“Swift, KA-01-12345”,(10,1))
//        “Driver2, M, 29”,“Swift, KA-01-12345”,(11,10)
//        “Driver3, M, 24”,“Swift, KA-01-12345”,(5,3)
        driverDetailList.add(new DriverDetail("Driver1, M, 22","Swift, KA-01-12345","(10,1)"));
        driverDetailList.add(new DriverDetail("Driver2, M, 29","Swift, KA-01-12346","(11,10)"));
        driverDetailList.add(new DriverDetail("Driver3, M, 24","Swift, KA-01-12347","(5,3)"));
        driverDetailList.add(new DriverDetail("Driver4, M, 24","Swift, KA-01-12348","(2,2)"));
        driverDetailList.add(new DriverDetail("Driver5, M, 24","Swift, KA-01-12348","(5,0)"));
    }

    public  void add_driver(String  driver_details, String vehicle_details, String currentLocation)
    {
        DriverDetail driverDetail=new DriverDetail(driver_details,vehicle_details,currentLocation);
        driverDetailList.add(driverDetail);




    }

    public List<DriverDetail> getAllDrivers()
    {
        return this.driverDetailList;
    }

    public List<String> findRide(String username,String source ,String destination)
    {
        List<String>availableRides=new ArrayList<>();
        int sourceX=Integer.parseInt(source.replaceAll("[()]","").split(",")[0]);
        int sourceY=Integer.parseInt(source.replaceAll("[()]","").split(",")[1]);
        this.driverDetailList.stream().filter(e->
        {
            int xc=e.getLocation().getX();
            int yc=e.getLocation().getY();
            double distance=Math.sqrt((xc-sourceX)*(xc-sourceX)+(yc-sourceY)*(yc-sourceY));
            return distance<=5 && ! e.isStatus();
        }).collect(Collectors.toList()).forEach(e->
        {
            availableRides.add(e.getDetail().getName() + "[Available]");
        });


        return availableRides;
    }


    public  String chooseRide(String userName,String driverName)
    {
        List<DriverDetail> driverDetails1=driverDetailList.stream().filter(e->
        {
            if(e.getDetail().getName().equals(driverName) && (! e.isStatus()))
            {
                e.setStatus(! e.isStatus());
                return true;
            }
            return false;

        }).collect(Collectors.toList());

        if(driverDetails1.isEmpty())
        {
            return null;
        }
        return driverDetails1.stream().collect(Collectors.toList()).get(0).getDetail().getName()+" is on the way";



    }


}
