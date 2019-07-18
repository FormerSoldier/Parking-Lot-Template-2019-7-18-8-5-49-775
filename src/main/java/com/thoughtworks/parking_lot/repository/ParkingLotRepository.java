package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

    @Query(value = "SELECT * FROM parkinglot Limit CONCAT('%',:start,'%'), CONCAT('%',:end,'%')", nativeQuery = true)
    List<ParkingLot> getParkingLotsLimit(@Param("start") int start, @Param("end") int end);
}
