package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
public class ParkingLotOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private String parkingLotName;

    @OneToOne(cascade = CascadeType.ALL)
    private String plateNumber;

    private String startTime;
    private String endTime;
    private boolean status;



    public ParkingLotOrder() {
    }

    public ParkingLotOrder(String parkingLotName, String plateNumber, String startTime, boolean status) {
        this.parkingLotName = parkingLotName;
        this.plateNumber = plateNumber;
        this.startTime = startTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
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
