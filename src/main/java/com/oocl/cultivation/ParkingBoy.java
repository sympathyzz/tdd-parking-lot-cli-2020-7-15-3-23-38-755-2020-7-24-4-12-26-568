package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot=new ParkingLot();

    public Ticket park(Car car,Customer customer) {
        if(parkingLot.getParkingRooms().size()<parkingLot.getCapacity()){
            Ticket ticket = new Ticket(car);
            parkingLot.getParkingRooms().put(ticket, car);
            car.setIsParking(true);
            customer.setTicket(ticket);
            return ticket;
        }
        sendMessage(null,customer);
        return null;
    }

    public Car fetch(Ticket ticket,Customer customer) {
        Car car=null;
        if(parkingLot.getParkingRooms().containsKey(ticket)){
            car=parkingLot.getParkingRooms().remove(ticket);
            customer.setTicket(null);
            customer.getCar().setIsParking(false);
        }
        sendMessage(ticket,customer);
        return car;
    }

    private void sendMessage(Ticket ticket,Customer customer) {
        if(customer.getCar().getIsParking()){
            if(customer.getTicket()!=null){
                if(ticket==null){
                    System.out.print("Please provide your parking ticket.\n");
                }
            }else {
                System.out.print("Unrecognized parking ticket.\n");
            }
        }else if (ticket==null){
            System.out.print("Not enough position.\n");
        }else{
            System.out.print("Unrecognized parking ticket.\n");
        }
    }
}
