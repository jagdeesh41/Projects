package org.example;

public class VehicleDetail
{
    String vehicleName;
    String vehicleNumber;
    public VehicleDetail(String vehicle)
    {
        String[] vehicleDetails=vehicle.split(", ");
        this.vehicleName=vehicleDetails[0];
        this.vehicleNumber=vehicleDetails[1];


    }
}
