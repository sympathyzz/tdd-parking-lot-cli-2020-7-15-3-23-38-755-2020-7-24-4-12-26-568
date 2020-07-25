package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot=new ParkingLot();

    public Ticket park(Car car) {
        if(parkingLot.getParkingRooms().size()<parkingLot.getCapacity()){
            Ticket ticket = new Ticket();
            parkingLot.getParkingRooms().put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car fetch(Ticket ticket) {
        Car car=null;
        if(parkingLot.getParkingRooms().containsKey(ticket)){
            car=parkingLot.getParkingRooms().remove(ticket);
        }
        if(car==null){
        System.out.print("Unrecognized parking ticket.\n");
        }
        return car;
    }
}
