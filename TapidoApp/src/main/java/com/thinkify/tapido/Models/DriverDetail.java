package com.thinkify.tapido.Models;
import java.util.*;


public class DriverDetail
{
    private Detail detail;
    private String vehicle_detail;
    private Pair location=new Pair(0,0);
    private boolean status=false;



    public DriverDetail(String  driver_details,String vehicle_details,String current_location)
    {
        this.detail=new Detail(driver_details);
        this.vehicle_detail=vehicle_details;
        String[] coord=current_location.replaceAll("[()]","").split(",");
        this.location=new Pair(Integer.parseInt(coord[0]),Integer.parseInt(coord[1]));



    }

    public Detail getDetail()
    {
        return detail;
    }

    public void setDetail(Detail detail)
    {
        this.detail = detail;
    }

    public String getVehicle_detail() {
        return vehicle_detail;
    }

    public void setVehicle_detail(String vehicle_detail) {
        this.vehicle_detail = vehicle_detail;
    }

    public Pair getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        String[] coord=location.replaceAll("[()]","").split(",");
        this.location.setX(Integer.valueOf(coord[0]));
        this.location.setY(Integer.valueOf(coord[1]));
    }


    @Override
    public String toString() {
        return "DriverDetail{" +
                "detail=" + detail +
                ", vehicle_detail='" + vehicle_detail + '\'' +
                ", location=" + location +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
