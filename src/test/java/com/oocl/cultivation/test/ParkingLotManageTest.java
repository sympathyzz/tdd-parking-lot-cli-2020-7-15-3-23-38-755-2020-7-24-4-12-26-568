package com.oocl.cultivation.test;

import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLotManage;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLotManageTest {
    @Test
    void should_management_list_size_return_2_when_add_boy_to_manage_list_given_2_parking_boy(){
        //given
        ParkingBoy parkingBoy1=new ParkingBoy();
        ParkingBoy parkingBoy2=new ParkingBoy();
        ParkingLotManage parkingLotManage=new ParkingLotManage();
        //when
        parkingLotManage.addParkingBoyToManagementList(parkingBoy1);
        parkingLotManage.addParkingBoyToManagementList(parkingBoy2);
        //then
        assertEquals(2,parkingLotManage.getManagementList().size());
    }
}
