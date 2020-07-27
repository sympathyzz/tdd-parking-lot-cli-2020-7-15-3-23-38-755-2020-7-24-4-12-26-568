package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLotManager;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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
}
