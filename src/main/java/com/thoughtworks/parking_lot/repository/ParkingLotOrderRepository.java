package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkingLotOrderRepository extends JpaRepository<ParkingLotOrder, Long> {

    @Query(value = "SELECT count(*) FROM parking_lot_order WHERE parking_lot_id = :parking_lot_id AND status = true",nativeQuery = true)
    int getTrueStatusoCuntByParkingLotId(@Param("parking_lot_id")int parkingLotId);

    @Query(value = "SELECT * FROM parking_lot_order_WHERE parking_lot_id = :parking_lot_id AND plate_number = :plate_number AND status = true", nativeQuery = true)
    ParkingLotOrder getParkingLotOrderByPlateNumberByAndParkingLotNameAndPlateNumber(@Param("parking_lot_id") int parkingLotId, @Param("plate_number") String plateNumber);
}
