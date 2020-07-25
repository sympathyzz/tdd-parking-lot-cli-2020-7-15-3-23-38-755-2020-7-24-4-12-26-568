package com.oocl.cultivation.test;

import com.oocl.cultivation.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



public class ParkingBoyTest {

    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void should_return_ticket_when_parkCar_given_car() {
        //given
        Car car=new Car();
        Customer customer=new Customer(car);
        //when
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car,customer);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parking_ticket() {
        //given
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car,customer);
        //when
        Car fetchedCarr=parkingBoy.fetch(ticket,customer);
        //then
        assertNotNull(fetchedCarr);
    }

    @Test
    void should_return_correspond_car_when_fetch_given_correspond_ticket() {
        //given
        Car car1 = new Car();
        Customer customer1=new Customer(car1);
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket1 = parkingBoy.park(car1,customer1);
        Car car2 = new Car();
        Customer customer2=new Customer(car2);
        Ticket ticket2 = parkingBoy.park(car2,customer2);
        //when
        Car fetchedCar1 = parkingBoy.fetch(ticket1,customer1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2,customer2);
        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
        assertNotEquals(fetchedCar1, fetchedCar2);
    }

    @Test
    void should_return_null_when_fetch_given_wrong_ticket() {
        //given
        Customer customer=new Customer(new Car());
        Ticket ticket=new Ticket(null);
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Car fetchedCar=parkingBoy.fetch(ticket,customer);
        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_null_when_fetch_given_used_ticket() {
        //given
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car,customer);
        parkingBoy.fetch(ticket,customer);
        //when
        Car fetchecCar=parkingBoy.fetch(ticket,customer);
        //then
        assertNull(fetchecCar);
    }

    @Test
    void should_return_null_when_park_given_no_position() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        for(int i=0;i<20;i++){
            Car car=new Car();
            parkingBoy.park(car,new Customer(car));
        }
        //when
        Car car=new Car();
        Customer customer=new Customer(car);
        Ticket ticket=parkingBoy.park(car,customer);
        //then
        assertNull(ticket);
    }

    @Test
    void should_get_unrecognized_message_when_fetch_given_no_ticket_from_parking_boy() {
        //given
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy=new ParkingBoy();
        parkingBoy.park(car,customer);
        customer.setTicket(null);
        //when
        parkingBoy.fetch(customer.getTicket(),customer);
        //then
        assertThat(systemOut().endsWith("Unrecognized parking ticket.\n")).isTrue();
    }

    @Test
    void should_get_unrecognized_message_when_fetch_given_used_ticket() {
        //given
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car,customer);
        parkingBoy.fetch(ticket,customer);
        //when
        parkingBoy.fetch(ticket,customer);
        //then
        assertThat(systemOut().endsWith("Unrecognized parking ticket.\n")).isTrue();
    }

    @Test
    void should_get_please_provide_ticket_message_when_fetch_given_no_ticket_by_customer() {
        //given
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy=new ParkingBoy();
        parkingBoy.park(car,customer);
        Ticket ticket=null;
        //when
        parkingBoy.fetch(ticket,customer);
        //then
        assertThat(systemOut().endsWith("Please provide your parking ticket.\n")).isTrue();
    }

    @Test
    void should_get_not_enough_position_message_when_park_given_no_position() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        for(int i=0;i<20;i++){
            Car car=new Car();
            Customer customer=new Customer(car);
            parkingBoy.park(car,customer);
        }
        Car car=new Car();
        Customer customer=new Customer(car);
        //when
        parkingBoy.park(car,customer);
        //then
        assertThat(systemOut().endsWith("Not enough position.\n")).isTrue();
    }

    @Test
    void should_first_parkinglot_full_second_parkinglot_has_1_car_when_park_given_6_cars() {
        //given
        //when
        ParkingBoy parkingBoy=new ParkingBoy();
        for(int i=0;i<6;i++){
            Car car=new Car();
            Customer customer=new Customer(car);
            parkingBoy.park(car,customer);
        }
        //then
        assertEquals(5,parkingBoy.getAllParkingLot().get(0).getParkingRooms().size());
        assertEquals(1,parkingBoy.getAllParkingLot().get(1).getParkingRooms().size());
    }

    @Test
    void should_first_parkinglot_has_1_car__second_parkinglot_has_6_cars_when_park_given_7_cars() {
        //given
        //when
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        for(int i=0;i<7;i++){
            Car car=new Car();
            Customer customer=new Customer(car);
            smartParkingBoy.park(car,customer);
        }
        //then
        assertEquals(1,smartParkingBoy.getAllParkingLot().get(0).getParkingRooms().size());
        assertEquals(6,smartParkingBoy.getAllParkingLot().get(1).getParkingRooms().size());
    }

    @Test
    void should_first_parkinglot_has_1_car__second_parkinglot_has_1_car_when_park_given_2_cars() {
        //given
        //when
        SuperSmartParkingBoy smartParkingBoy=new SuperSmartParkingBoy();
        for(int i=0;i<2;i++){
            Car car=new Car();
            Customer customer=new Customer(car);
            smartParkingBoy.park(car,customer);
        }
        //then
        assertEquals(1,smartParkingBoy.getAllParkingLot().get(0).getParkingRooms().size());
        assertEquals(1,smartParkingBoy.getAllParkingLot().get(1).getParkingRooms().size());
    }

    private String systemOut() {
        return outContent.toString();
    }

}
