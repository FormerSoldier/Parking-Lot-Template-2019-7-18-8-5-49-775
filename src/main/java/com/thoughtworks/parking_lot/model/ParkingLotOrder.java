package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
public class ParkingLotOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private ParkingLot parkingLot;

    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    private String startTime;
    private String endTime;
    private boolean status;



    public ParkingLotOrder() {
    }

    public ParkingLotOrder(ParkingLot parkingLot, Car car, String startTime, boolean status) {
        this.parkingLot = parkingLot;
        this.car = car;
        this.startTime = startTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
