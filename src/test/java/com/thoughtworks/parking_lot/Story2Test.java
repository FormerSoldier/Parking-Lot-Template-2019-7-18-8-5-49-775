package com.thoughtworks.parking_lot;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotOrderService;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JdbcTest
public class Story2Test {
    @Autowired
    ParkingLotOrderService parkingLotOrderService;

    @Autowired
    ParkingLotService parkingLotService;

    @Test
    public void should_return_400_when_call_get_invalid_capacity_pariking_lot_id_given_parking_lot_id(){
        ParkingLot parkingLot = parkingLotService.saveParkingLot(new ParkingLot("1号停车场",200,"钵兰街13号"));
        int invalidCapacity = parkingLotOrderService.getOrdersCountParkingLotStatusTrue(parkingLot.getId());

        Assertions.assertEquals("400",invalidCapacity);

    }

}
