package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
}
