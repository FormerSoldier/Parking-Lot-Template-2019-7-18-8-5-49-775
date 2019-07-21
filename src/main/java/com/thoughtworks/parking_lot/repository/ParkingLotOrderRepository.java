package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingLotOrderRepository extends JpaRepository<ParkingLotOrder, Long> {

    @Query(value = "SELECT count(*) FROM parking_lot_order WHERE parking_lot_name = :parking_lot_name AND status = true",nativeQuery = true)
    int getTrueStatusCountByParkingLotId(@Param("parking_lot_name")String parkingLotName);

    @Query(value = "SELECT * FROM parking_lot_order_WHERE parking_lot_id = :parking_lot_id AND plate_number = :plate_number AND status = true", nativeQuery = true)
    ParkingLotOrder getParkingLotOrderByPlateNumberByAndParkingLotNameAndPlateNumber(@Param("parking_lot_id") int parkingLotId, @Param("plate_number") String plateNumber);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE parking_lot_order SET status = FALSE, end_time = :end_time WHERE status = TRUE AND car_plate_number = :plate_number AND parking_lot_name = :name", nativeQuery = true)
    int updateParkingLotStatusAndAndEndTimeAnd(@Param("end_time") String endTime,
                                                           @Param("plate_number") String plateNumber,
                                                           @Param("name") String parkingLotName);
}
