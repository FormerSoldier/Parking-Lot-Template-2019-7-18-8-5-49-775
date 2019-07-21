package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.*;
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
       return parkingLotOrderRepository.getTrueStatusCountByParkingLotId(parkingLotId);
   }

   public ParkingLotOrderDTO updateOrderByOrderId(int parkingLotId, String plateNumber){
       ParkingLotOrder order = parkingLotOrderRepository.getParkingLotOrderByPlateNumberByAndParkingLotNameAndPlateNumber(parkingLotId,plateNumber);
       Date date = Calendar.getInstance().getTime();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String endTime = simpleDateFormat.format(date);

       order.setEndTime(endTime);
       order.setStatus(Constant.UP);
       parkingLotOrderRepository.save(order);

       ParkingLotOrderDTO parkingLotOrderDTO = new ParkingLotOrderDTO();
       parkingLotOrderDTO.setParkingLotOrder(order);
       return parkingLotOrderDTO;
   }

   public ParkingLotOrderDTO addOrder(int parkingLotId, Car car){
       ParkingLotOrderDTO parkingLotOrderDTO = new ParkingLotOrderDTO();
       int validCapacity = parkingLotService.getValidCapacityByParkingLotId(parkingLotId);
       if(validCapacity <= 0){
           String message = "停车场已经满了";
           parkingLotOrderDTO.setMessage(message);
           return parkingLotOrderDTO;
       }

       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String startTime = simpleDateFormat.format(Calendar.getInstance().getTime());

       ParkingLot parkingLot = parkingLotService.getParkingLotByParkingLotId(parkingLotId);
       ParkingLotOrder parkingLotOrder = new ParkingLotOrder();
       parkingLotOrder.setParkingLot(parkingLot);
       parkingLotOrder.setCar(car);
       parkingLotOrder.setStartTime(startTime);
       parkingLotOrder.setStatus(Constant.UP);

       parkingLotOrderRepository.save(parkingLotOrder);
       parkingLotOrderDTO.setParkingLotOrder(parkingLotOrder);
       return parkingLotOrderDTO;

   }
   public int updateOrderStatusAndEndTime(String plateNumber, int parkingLotId){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String endTime = simpleDateFormat.format(Calendar.getInstance().getTime());

       return parkingLotOrderRepository.updateParkingLotStatusAndAndEndTimeAnd(endTime,plateNumber,parkingLotId);

   }
}
