package org.example;

import java.util.Arrays;

public class DriverDetail
{
    private Detail detail;
    private String vehicle_detail;
    private Pair location;

    private boolean status=false;



    public DriverDetail(String  driver_details,String vehicle_details,Pair current_location)
    {
        this.detail=new Detail(driver_details);
        this.vehicle_detail=vehicle_details;
        this.location=current_location;
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

    public Pair getLocation() {
        return location;
    }

    public void setLocation(Pair location) {
        this.location = location;
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
