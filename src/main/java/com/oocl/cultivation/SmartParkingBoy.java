package com.oocl.cultivation;

public class SmartParkingBoy extends ParkingBoy{

    public Ticket park(Car car, Customer customer) {
        for(int i=0;i<allParkingLot.size();i++){
            if(allParkingLot.get(i).getParkingRooms().size()<allParkingLot.get(i).getCapacity()){
                Ticket ticket = new Ticket(car);
                allParkingLot.get(i).getParkingRooms().put(ticket, car);
                car.setIsParking(true);
                customer.setTicket(ticket);
                return ticket;
            }
        }
        sendMessage(null,customer);
        return null;
    }

    public Car fetch(Ticket ticket,Customer customer) {
        Car car=null;
        for(int i=0;i<allParkingLot.size();i++){
            if(allParkingLot.get(i).getParkingRooms().containsKey(ticket)){
                car=allParkingLot.get(i).getParkingRooms().remove(ticket);
                customer.setTicket(null);
                customer.getCar().setIsParking(false);
            }
        }
        sendMessage(ticket,customer);
        return car;
    }

}
