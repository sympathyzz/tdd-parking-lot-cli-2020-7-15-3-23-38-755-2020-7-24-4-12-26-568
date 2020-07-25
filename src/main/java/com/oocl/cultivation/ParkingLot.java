package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Ticket, Car> parkingRooms = new HashMap<>();

    public int getCapacity() {
        return capacity;
    }

    public Map<Ticket, Car> getParkingRooms() {
        return parkingRooms;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

}
