package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private ParkingLot parkingLot;
    private List<ParkingBoy> managementList=new ArrayList<>();
    public void addParkingBoyToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }


    public List<ParkingBoy> getManagementList() {
       return managementList;
    }

    public Ticket specifyParkingBoyToPark(ParkingBoy parkingBoy, Car car, Customer customer) {
        return parkingBoy.park(car,customer);
    }


    public Car specifyParkingBoyToFetch(ParkingBoy parkingBoy, Ticket ticket, Customer customer) {
        return parkingBoy.fetch(ticket,customer);
    }
}
