package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private List<ParkingBoy> managementList=new ArrayList<>();
    public void addParkingBoyToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public List<ParkingBoy> getManagementList() {
       return managementList;
    }
}
