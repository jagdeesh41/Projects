package com.thinkify.tapido.Service;

import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Models.Pair;

import java.util.List;

public interface DriverService
{
     void addDriverDetails(String driver_details,String vehicle_details,String current_location);
     List<DriverDetail> getAllDrivers();

     List<String> findRide(String user, String source, String destination);

     String chooseRide(String user, String driver);
}
