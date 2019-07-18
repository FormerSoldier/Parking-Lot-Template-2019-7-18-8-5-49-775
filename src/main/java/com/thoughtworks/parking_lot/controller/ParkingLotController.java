package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingLot> getAllParkingLots(){
        return parkingLotService.listAllParkingLots();
    }

    @PostMapping
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotService.saveParkingLot(parkingLot);
    }
    @DeleteMapping("/{parkingLotId}")
    public void deleteParkingById(@PathVariable int parkingLotId){
        parkingLotService.deleteParkingLotById(parkingLotId);
    }
}
