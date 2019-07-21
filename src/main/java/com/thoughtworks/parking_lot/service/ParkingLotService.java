package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.Car;
import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.model.ParkingLotOrderDTO;
import com.thoughtworks.parking_lot.repository.ParkingLotOrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    ParkingLotOrderService parkingLotOrderService;

    public ParkingLot saveParkingLot(ParkingLot parkingLot){
        return parkingLotRepository.saveAndFlush(parkingLot);
    }

    public List<ParkingLot> listAllParkingLots(){
        return parkingLotRepository.findAll();
    }

    public void deleteParkingLotById(String parkingLotName) {
        parkingLotRepository.deleteById(parkingLotName);
    }


    public List<ParkingLot> getParkingLotsLimit(int page, int pageSize) {
        return parkingLotRepository.getParkingLotsLimit(page * pageSize, pageSize);
    }

    public ParkingLot getParkingLotByParkingLotId(String parkingLotName) {
        return parkingLotRepository.findById(parkingLotName).get();
    }

    public void updateParkingLotCapacityByParkingLotId(String parkingLotName, int capacity){
        parkingLotRepository.updateParkingLotCapacityByParkingLotId(parkingLotName,capacity);
    }

    public ParkingLot updateParkingLot(String parkingLotName, int capacity){
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotName).get();
        parkingLot.setCapacity(capacity);
        return parkingLotRepository.save(parkingLot);
    }

    public int getValidCapacityByParkingLotId(String parkingLotName){
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotName).get();
        int capacity = parkingLot.getCapacity();
        return capacity - parkingLotOrderService.getOrdersCountParkingLotStatusTrue(parkingLotName);
    }
    public int fetch(String name, String plateNumber){
        return parkingLotOrderService.updataOrderStatusAndEndTime(plateNumber, name);
    }

    public ParkingLotOrderDTO park(String parkingLotName, Car car){
        return parkingLotOrderService.addOrder(parkingLotName,car);
    }
}
