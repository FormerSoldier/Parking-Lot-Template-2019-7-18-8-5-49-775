package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteParkingLotById(Integer id) {
        parkingLotRepository.deleteById(id);
    }


    public List<ParkingLot> getParkingLotsLimit(int page, int pageSize) {
        return parkingLotRepository.getParkingLotsLimit(page * pageSize, pageSize);
    }

    public ParkingLot getParkingLotByParkingLotId(Integer id) {
        return parkingLotRepository.findById(id).get();
    }

    public void updateParkingLotCapacityByParkingLotId(int parkingLotId, int capacity){
        parkingLotRepository.updateParkingLotCapacityByParkingLotId(parkingLotId,capacity);
    }

    public ParkingLot updateParkingLot(int id, int capacity){
        ParkingLot parkingLot = parkingLotRepository.findById(id).get();
        parkingLot.setCapacity(capacity);
        return parkingLotRepository.save(parkingLot);
    }

    public int getValidCapacityByParkingLotId(int parkingLotId){
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).get();
        int capacity = parkingLot.getCapacity();
        return capacity - parkingLotOrderService.getOrdersCountParkingLotStatusTrue(parkingLotId);
    }

}
