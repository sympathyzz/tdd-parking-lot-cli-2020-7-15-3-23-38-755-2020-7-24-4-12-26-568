package com.oocl.cultivation.test;

import com.oocl.cultivation.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


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
        //when
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parking_ticket() {
        //given
        Car car=new Car();
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car);
        //when
        Car fetchedCarr=parkingBoy.fetch(ticket);
        //then
        assertNotNull(fetchedCarr);
    }

    @Test
    void should_return_correspond_car_when_fetch_given_correspond_ticket() {
        //given
        Car car1 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket1 = parkingBoy.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        //then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
        assertNotEquals(fetchedCar1, fetchedCar2);
    }

    @Test
    void should_return_null_when_fetch_given_wrong_ticket() {
        //given
        Ticket ticket=new Ticket();
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Car fetchedCar=parkingBoy.fetch(ticket);
        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_null_when_fetch_given_used_ticket() {
        //given
        Car car=new Car();
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        //when
        Car fetchecCar=parkingBoy.fetch(ticket);
        //then
        assertNull(fetchecCar);
    }

    @Test
    void should_return_null_when_park_given_no_position() {
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        for(int i=0;i<10;i++){
            parkingBoy.park(new Car());
        }
        //when
        Ticket ticket=parkingBoy.park(new Car());
        //then
        assertNull(ticket);
    }

    @Test
    void should_get_unrecognized_message_when_fetch_given_no_ticket_from_parking_boy() {
        //given
        Car car=new Car();
        ParkingBoy mockedfetch= Mockito.mock(ParkingBoy.class);
        given(mockedfetch.park(car)).willReturn(null);
        Ticket ticket=mockedfetch.park(car);
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        parkingBoy.fetch(ticket);
        //then
        assertThat(systemOut().endsWith("Unrecognized parking ticket.\n")).isTrue();
    }

    @Test
    void should_get_unrecognized_message_when_fetch_given_used_ticket() {
        //given
        Car car=new Car();
        ParkingBoy parkingBoy=new ParkingBoy();
        Ticket ticket=parkingBoy.park(car);;
        parkingBoy.fetch(ticket);
        //when
        parkingBoy.fetch(ticket);
        //then
        assertThat(systemOut().endsWith("Unrecognized parking ticket.\n")).isTrue();
    }

    @Test
    void should_get_please_provide_ticket_message_when_fetch_given_no_ticket_by_customer() {
        //given
        Customer customer=new Customer(new Car());
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        parkingBoy.fetch(customer.getTicket());
        //then
        assertThat(systemOut().endsWith("Please provide your parking ticket.\n")).isTrue();
    }

    private String systemOut() {
        return outContent.toString();
    }

}
