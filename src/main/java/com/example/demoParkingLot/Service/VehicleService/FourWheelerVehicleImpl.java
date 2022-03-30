package com.example.demoParkingLot.Service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demoParkingLot.Database.ParkingLotDatabase;
import com.example.demoParkingLot.Vehicle.VehicleType;

import POJO.VehicleCapacity;
import POJO.VehicleInfo;

@Component("fourWheelerVehicleImpl")
public class FourWheelerVehicleImpl implements VehicleService{

    @Autowired
    ParkingLotDatabase parkingLotDatabase;

    @Value("${parking-lot.four-wheeler.max-capacity}")
    String maxCapacity;

    @Override
    public Boolean isParkingSpaceAvailable(VehicleCapacity vehicleCapacity) {
        return vehicleCapacity.getCounter() < Integer.parseInt(maxCapacity) ? true : false;
        
    }

    @Override
    public void updateParkingSpace(VehicleCapacity vehicleCapacity) {
        parkingLotDatabase.updateVehicleCapacity(vehicleCapacity);
    }
}
