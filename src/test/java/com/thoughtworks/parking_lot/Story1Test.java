package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class Story1Test {

    @Autowired
    ParkingLotService parkingLotService;

    // AC 1
    @Test
    public void should_return_parking_lot_when_call_add_parking_lot_given_parking_lot(){
        ParkingLot parkingLot = new ParkingLot("1号停车场",200,"波兰街十三号");
        parkingLot = parkingLotService.saveParkingLot(parkingLot);

        Assertions.assertNotNull(parkingLot.getId());
    }

    @Test
    public void call_delete_parking_lot_by_id(){
        ParkingLot parkingLot = new ParkingLot("1号停车场",200,"波兰街十三号");
        parkingLot = parkingLotService.saveParkingLot(parkingLot);

        parkingLotService.deleteParkingLotById(parkingLot.getId());
        List<ParkingLot> parkingLotList = parkingLotService.listAllParkingLots();
        Assertions.assertEquals(parkingLotList.size(),0);
    }

    @Test
    public void should_return_fifteen_ParkingLots_when_call_getParkingLotsLimit_given_fifteen(){
        for(int i = 0; i < 20; i++){
            parkingLotService.saveParkingLot(new ParkingLot(String.format("%d号停车场",i),i*45,String.format("钵兰街第%d号",i)));
        }
        List<ParkingLot> parkingLots = parkingLotService.getParkingLotsLimit(0,15);

        Assertions.assertEquals(parkingLots.size(),15);
    }

}
