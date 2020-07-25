package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public Ticket park(Car car) {
        if(parkingLot.getParkingRooms().size()<parkingLot.getCapacity()){
            Ticket ticket = new Ticket();
            parkingLot.getParkingRooms().put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car checkTicketToReturnCar(Ticket ticket) {
        Car car=null;
        if(parkingLot.getParkingRooms().containsKey(ticket)){
            car=parkingLot.getParkingRooms().remove(ticket);
        }
        return car;
    }
}
