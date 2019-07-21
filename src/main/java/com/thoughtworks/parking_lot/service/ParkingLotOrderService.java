package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.model.ParkingLotOrderDTO;
import com.thoughtworks.parking_lot.repository.ParkingLotOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ParkingLotOrderService {

    @Autowired
    ParkingLotService parkingLotService;

    @Autowired
    ParkingLotOrderRepository parkingLotOrderRepository;

   public int getOrdersCountParkingLotStatusTrue(int parkingLotId){
       return parkingLotOrderRepository.getTrueStatusoCuntByParkingLotId(parkingLotId);
   }

   public ParkingLotOrderDTO updateOrderByOrderId(int parkingLotId, String plateNumber){
       ParkingLotOrder order = parkingLotOrderRepository.getParkingLotOrderByPlateNumberByAndParkingLotNameAndPlateNumber(parkingLotId,plateNumber);
       Date date = Calendar.getInstance().getTime();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String endTime = simpleDateFormat.format(date);

       order.setEndTime(endTime);
       order.setStatus(false);
       parkingLotOrderRepository.save(order);

       ParkingLotOrderDTO parkingLotOrderDTO = new ParkingLotOrderDTO();
       parkingLotOrderDTO.setParkingLotOrder(order);
       return parkingLotOrderDTO;
   }

   public ParkingLotOrderDTO addOrder(int parkingLotId, String plateNumber){
       ParkingLotOrderDTO parkingLotOrderDTO = new ParkingLotOrderDTO();
       int validCapacity = parkingLotService.getValidCapacityByParkingLotId(parkingLotId);
       if(validCapacity <= 0){
           String message = "停车场已满";
           parkingLotOrderDTO.setMessage(message);
           return parkingLotOrderDTO;
       }

       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String startTime = simpleDateFormat.format(Calendar.getInstance().getTime());

       ParkingLot parkingLot = parkingLotService.getParkingLotByParkingLotId(parkingLotId);
       ParkingLotOrder parkingLotOrder = new ParkingLotOrder();
       parkingLotOrder.setParkingLotName(parkingLot.getName());
       parkingLotOrder.setPlateNumber(plateNumber);
       parkingLotOrder.setStartTime(startTime);
       parkingLotOrder.setStatus(true);

       parkingLotOrderRepository.save(parkingLotOrder);
       parkingLotOrderDTO.setParkingLotOrder(parkingLotOrder);
       return parkingLotOrderDTO;



   }
}
