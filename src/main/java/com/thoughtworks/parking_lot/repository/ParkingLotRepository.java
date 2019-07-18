package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLot;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

    @Query(value = "SELECT * FROM parking_lot Limit :start, :count", nativeQuery = true)
    List<ParkingLot> getParkingLotsLimit(@Param("start") int start, @Param("count") int count);

    @SQLUpdate("UPDATE parking_lot SET capacity = :capacity WHERE id = :id",nativeQuery = true)
    void updateParkingLotCapacityByParkingLotId(@Param("capacity") int capacity, @Param("id") int parkingLotId);


}
