package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        Car car=new Car();
        //when
        ParkingLot parkingLot=new ParkingLot();
        Ticket ticket=parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parking_ticket() {
        //given
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot();
        Ticket ticket=parkingLot.park(car);
        //when
        Car car2=parkingLot.fetch(ticket);
        //then
        assertNotNull(car2);
    }
}
