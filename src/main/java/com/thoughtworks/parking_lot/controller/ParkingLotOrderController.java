package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.Car;
import com.thoughtworks.parking_lot.model.ParkingLotOrderDTO;
import com.thoughtworks.parking_lot.service.ParkingLotOrderService;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotOrderController {

    @Autowired
    ParkingLotOrderService parkingLotOrderService;

    @Autowired
    ParkingLotService parkingLotService;

    @PostMapping("/{parking-lot-id}")
    public ParkingLotOrderDTO parkCar(@PathVariable("parking-lot-id") int parkingLotId, @RequestBody Car car){
        return parkingLotService.park(parkingLotId, car);
    }

    @PutMapping("/{parkingLotId}")
    public int fetchCar(@PathVariable("parkingLotId") int parkingLotId,@RequestBody Car car){
        return parkingLotService.fetch(parkingLotId, car.getPlateNumber());
    }
}
