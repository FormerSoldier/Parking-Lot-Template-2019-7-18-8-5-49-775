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

    public void deleteParkingLotById(int parkingLotId) {
        parkingLotRepository.deleteById(parkingLotId);
    }


    public List<ParkingLot> getParkingLotsLimit(int page, int pageSize) {
        return parkingLotRepository.getParkingLotsLimit(page * pageSize, pageSize);
    }

    public ParkingLot getParkingLotByParkingLotId(int parkingLotId) {
        return parkingLotRepository.findById(parkingLotId).orElse(null);
    }

    public void updateParkingLotCapacityByParkingLotId(String parkingLotName, int capacity){
        parkingLotRepository.updateParkingLotCapacityByParkingLotId(parkingLotName,capacity);
    }

    public ParkingLot updateParkingLot(int parkingLotId, int capacity){
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElse(null);
        if(parkingLot == null)
            return null;
        parkingLot.setCapacity(capacity);
        return parkingLotRepository.save(parkingLot);
    }

    public int getValidCapacityByParkingLotId(int parkingLotId){
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElse(null);
        if(parkingLot == null)
            return 0;
        int capacity = parkingLot.getCapacity();
        return capacity - parkingLotOrderService.getOrdersCountParkingLotStatusTrue(parkingLotId);
    }
    public int fetch(int parkingLotId, String plateNumber){
        return parkingLotOrderService.updateOrderStatusAndEndTime(plateNumber, parkingLotId);
    }

    public ParkingLotOrderDTO park(int parkingLotId, Car car){
        return parkingLotOrderService.addOrder(parkingLotId,car);
    }
}
