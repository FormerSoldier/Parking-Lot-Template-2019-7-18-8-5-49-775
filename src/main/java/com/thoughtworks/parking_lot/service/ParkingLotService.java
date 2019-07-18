package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    public ParkingLot saveParkingLot(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
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
}
