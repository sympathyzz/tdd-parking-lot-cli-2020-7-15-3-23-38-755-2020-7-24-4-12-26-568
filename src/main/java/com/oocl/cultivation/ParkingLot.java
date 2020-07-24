package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    Map<Ticket, Car> parkingRooms = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingRooms.put(ticket, car);
        return ticket;
    }


    public Car fetch(Ticket ticket) {
        Car car=null;
        if(parkingRooms.containsKey(ticket)){
            car=parkingRooms.get(ticket);
            parkingRooms.remove(ticket);
        }
        return car;
    }
}
