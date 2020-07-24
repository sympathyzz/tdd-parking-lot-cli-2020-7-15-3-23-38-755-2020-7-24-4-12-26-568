package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        Car car=new Car();
        //when
        ParkingLot parkingLot=new ParkingLot(10);
        Ticket ticket=parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parking_ticket() {
        //given
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(10);
        Ticket ticket=parkingLot.park(car);
        //when
        Car fetchedCar=parkingLot.fetch(ticket);
        //then
        assertNotNull(fetchedCar);
    }

    @Test
    void should_return_correspond_car_when_fetch_given_correspond_ticket() {
        //given
        Car car1=new Car();
        ParkingLot parkingLot=new ParkingLot(10);
        Ticket ticket1=parkingLot.park(car1);
        Car car2=new Car();
        Ticket ticket2=parkingLot.park(car2);
        //when
        Car fetchedCar1=parkingLot.fetch(ticket1);
        Car fetchedCar2=parkingLot.fetch(ticket2);
        //then
        assertEquals(car1,fetchedCar1);
        assertEquals(car2,fetchedCar2);
        assertNotEquals(fetchedCar1,fetchedCar2);
    }

    @Test
    void should_return_null_when_fetch_given_wrong_ticket() {
        //given
        Ticket ticket=new Ticket();
        ParkingLot parkingLot=new ParkingLot(10);
        //when
        Car fetchedCar=parkingLot.fetch(ticket);
        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_null_when_fetch_given_used_ticket() {
        //given
        Car car=new Car();
        ParkingLot parkingLot=new ParkingLot(10);
        Ticket ticket=parkingLot.park(car);
        parkingLot.fetch(ticket);
        //when
        Car fetchecCar=parkingLot.fetch(ticket);
        //then
        assertNull(fetchecCar);
    }

    @Test
    void should_return_null_when_park_given_no_position() {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        for(int i=0;i<10;i++){
            parkingLot.park(new Car());
        }
        //when
        Ticket ticket=parkingLot.park(new Car());
        //then
        assertNull(ticket);
    }
}
