package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotManagerTest {
    @Test
    void management_list_size_is_2_when_add_parking_boy_given_2_parking_boy(){
        //given
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        //when
        parkingLotManager.addParkingBoyToManagementList(parkingBoy1);
        parkingLotManager.addParkingBoyToManagementList(parkingBoy2);
        //then
        assertEquals(2,parkingLotManager.getManagementList().size());
    }

    @Test
    void should_return_a_ticket_when_specify_parking_boy_park_given_specified_parking_boy(){
        //given
        int parkingBoyId=1;
        Car car=new Car();
        Customer customer=new Customer(car);
        ParkingBoy parkingBoy = new ParkingBoy(parkingBoyId);
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        //when
        Ticket ticket=parkingLotManager.specifyParkingBoyToPark(parkingBoy,car,customer);
        //then
        assertNotNull(ticket);
    }

}
