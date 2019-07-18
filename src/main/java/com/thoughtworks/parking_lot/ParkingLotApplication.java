package com.thoughtworks.parking_lot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.thoughtworks.parking_lot.service","com.thoughtworks.parking_lot.controller"})
@SpringBootApplication
public class ParkingLotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingLotApplication.class, args);
    }

}
