package com.thoughtworks.parking_lot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class ParkingLotOrderDTO {
    @Autowired
    private ParkingLotOrder parkingLotOrder;

    private String message;

    public ParkingLotOrder getParkingLotOrder() {
        return parkingLotOrder;
    }

    public void setParkingLotOrder(ParkingLotOrder parkingLotOrder) {
        this.parkingLotOrder = parkingLotOrder;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
