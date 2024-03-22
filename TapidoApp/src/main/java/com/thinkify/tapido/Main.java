package com.thinkify.tapido;

import com.thinkify.tapido.Models.Detail;
import com.thinkify.tapido.Models.DriverDetail;
import com.thinkify.tapido.Models.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




public class Main
{


    static List<Detail> userDetails=new ArrayList<>();
    static List<DriverDetail>driverDetails=new ArrayList<>();






    public static void add_user(String user_detail)
    {

        Detail userDetail=new Detail(user_detail);
        userDetails.add(userDetail);



    }
    public static void add_driver(String  driver_details, String vehicle_details, String current_location)
    {
        DriverDetail driverDetail=new DriverDetail(driver_details,vehicle_details,current_location);
        driverDetails.add(driverDetail);
    }

    public static String choose_ride(String userName,String driverName)
    {

        List<DriverDetail> driverDetails1=driverDetails.stream().filter(e->
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
            return " Can't find a Ride Try again";
        }
        return driverDetails1.stream().collect(Collectors.toList()).get(0).getDetail().getName()+" is on the way";



    }


    public static List<String> findRide(String username,Pair source ,Pair destination)
    {
        List<String>availableRides=new ArrayList<>();

        driverDetails.stream().filter(e->
        {
            int xc=e.getLocation().getX();
            int yc=e.getLocation().getY();
            int sourceX= source.getX();
            int sourceY=source.getY();
            double distance=Math.sqrt((xc-sourceX)*(xc-sourceX)+(yc-sourceY)*(yc-sourceY));
            return distance<=5 && ! e.isStatus();
        }).collect(Collectors.toList()).forEach(e->
        {
            availableRides.add(e.getDetail().getName() + "[Available]");
        });

        if(availableRides.isEmpty())
        {
            availableRides.add("No Rides Found");
        }
        return availableRides;
    }
    void shortestPath(int src)
    {
        //we can use the dijkistras algorithm and find the available rides with
        // shortest distance to destination

    }
    public static void main(String[] args)
    {

        add_user("Abhishek, M, 23");
        add_user("Rahul , M, 29");
        add_user("Nandini, F, 22") ;
        //print all the user details
//        userDetails.stream().forEach((e)->
//        {
//            System.out.println(e);
//        });

          add_driver("Driver1, M, 22","Swift, KA-01-12345","(10,1)");
          add_driver("Driver2, M, 29","Swift, KA-02-12345","(11,10)");
          add_driver("Driver3, M, 22","Swift, KA-03-12345","(5,3)");
        //print all the driver details
//        driverDetails.stream().forEach(System.out::println);


        System.out.println(findRide("Abhishek",new Pair(0,0),new Pair(20,1)));
        System.out.println(findRide("Rahul",new Pair(10,0),new Pair(15,3)));
        System.out.println(findRide("Nandini",new Pair(15,6),new Pair(20,4)));

        System.out.println(choose_ride("Abhishek","Driver1"));
        System.out.println(choose_ride("Abhishek","Driver1"));
        System.out.println(choose_ride("Abhishek","Driver3"));






















    }
}