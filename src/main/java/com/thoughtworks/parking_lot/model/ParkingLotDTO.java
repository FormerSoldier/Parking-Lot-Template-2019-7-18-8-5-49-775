package com.thoughtworks.parking_lot.model;

public class ParkingLotDTO {
    private ParkingLot  parkingLot;
    private String message;

    public ParkingLotDTO() {
    }

    public ParkingLotDTO(ParkingLot parkingLot, String message) {
        this.parkingLot = parkingLot;
        this.message = message;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
