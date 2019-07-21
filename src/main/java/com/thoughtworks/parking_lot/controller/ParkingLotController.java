package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping(params = {"page", "pageSize"})
    public List<ParkingLot> getParkingLotsLimt(int page, int pageSize){
        return parkingLotService.getParkingLotsLimit(page,pageSize);
    }

    @GetMapping("/{parkingLotId}")
    public ParkingLot getParkingLotById(@PathVariable String parkingLotName){
        return parkingLotService.getParkingLotByParkingLotId(parkingLotName);
    }


    @PostMapping
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotService.saveParkingLot(parkingLot);
    }
    @DeleteMapping("/{parkingLotId}")
    public void deleteParkingById(@PathVariable String parkingLotName){
        parkingLotService.deleteParkingLotById(parkingLotName);
    }

    @PutMapping("/{id}/capacity/{capacity}")
    public ParkingLot updateParkingLotCapacity(@PathVariable String parkingLotName,@PathVariable Integer capacity){
        return parkingLotService.updateParkingLot(parkingLotName, capacity);
    }

}
