package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotManagerTest {

    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    void management_list_size_is_2_when_add_parking_boy_given_2_parking_boy(){
        //given
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot=new ParkingLot(5);
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        //when
        parkingLotManager.addParkingBoyToManagementList(parkingBoy1);
        parkingLotManager.addParkingBoyToManagementList(parkingBoy2);
        //then
        assertEquals(2,parkingLotManager.getManagementList().size());
    }

    @Test
    void should_return_a_ticket_when_specify_parking_boy_park_given_specified_parking_boy(){
        //given
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot=new ParkingLot(5);
        parkingLots.add(parkingLot);
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        //when
        Ticket ticket=parkingLotManager.specifyParkingBoyToPark(parkingBoy,car,customer);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_the_same_car_when_specify_parking_boy_fetch_given_specified_parking_boy_and_available_ticket(){
        //given
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot=new ParkingLot(5);
        parkingLots.add(parkingLot);
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        Ticket ticket=parkingLotManager.specifyParkingBoyToPark(parkingBoy,car,customer);
        //when
        Car fetchedCar=parkingLotManager.specifyParkingBoyToFetch(parkingBoy,ticket,customer);
        //then
        assertEquals(car,fetchedCar);
    }

    @Test
    void should_return_a_ticket_when_parking_manager_park_given_his_own_parking_lots (){
        //given
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot=new ParkingLot(5);
        parkingLots.add(parkingLot);
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        //when
        Ticket ticket=parkingLotManager.park(car,customer);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_get_not_enough_position_message__when_specify_parking_boy_fetch_given_16_cars (){
        //given
        ParkingBoy parkingBoy=new ParkingBoy();
        List<ParkingLot> parkingLots=new ArrayList<>();
        ParkingLot parkingLot=new ParkingLot(5);
        parkingLots.add(parkingLot);
        for(int i=0;i<15;i++){
            Car car=new Car();
            Customer customer=new Customer(car);
            ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
            parkingLotManager.specifyParkingBoyToPark(parkingBoy,car,customer);
        }
        //when
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);
        parkingLotManager.specifyParkingBoyToPark(parkingBoy,car,customer);
        //then
        assertThat(systemOut().endsWith("Not enough position.\n")).isTrue();
    }

}
