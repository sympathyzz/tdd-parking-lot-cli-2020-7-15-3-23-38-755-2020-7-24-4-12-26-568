package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private ParkingLot parkingLot;
    private List<ParkingBoy> managementList=new ArrayList<>();
    public void addParkingBoyToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<ParkingBoy> getManagementList() {
       return managementList;
    }
}
