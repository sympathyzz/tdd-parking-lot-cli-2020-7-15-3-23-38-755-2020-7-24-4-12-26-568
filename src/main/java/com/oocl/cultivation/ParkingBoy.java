package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot=new ParkingLot();

    public Ticket park(Car car,Customer customer) {
        if(parkingLot.getParkingRooms().size()<parkingLot.getCapacity()){
            Ticket ticket = new Ticket(car);
            parkingLot.getParkingRooms().put(ticket, car);
            customer.setTicket(ticket);
            return ticket;
        }
        return null;
    }

    public Car fetch(Ticket ticket,Customer customer) {
        Car car=null;
        if(parkingLot.getParkingRooms().containsKey(ticket)){
            car=parkingLot.getParkingRooms().remove(ticket);
            customer.setTicket(null);
        }
        sendMessage(ticket,customer);
        return car;
    }

    private void sendMessage(Ticket ticket,Customer customer) {
        if(customer.getTicket()!=null){
            if(ticket==null){
                System.out.print("Please provide your parking ticket.\n");
            }
        }else {
            System.out.print("Unrecognized parking ticket.\n");
        }

    }
}
