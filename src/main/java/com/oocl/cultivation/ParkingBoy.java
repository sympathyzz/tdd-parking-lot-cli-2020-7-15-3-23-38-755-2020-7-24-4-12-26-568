package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    protected   List<ParkingLot> allParkingLot=new ArrayList<>();

    public List<ParkingLot> getAllParkingLot() {
        return allParkingLot;
    }

    public ParkingBoy() {
        ParkingLot parkingLot1=new ParkingLot(5);
        ParkingLot parkingLot2=new ParkingLot(10);
        allParkingLot.add(parkingLot1);
        allParkingLot.add(parkingLot2);
    }

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

    protected void sendMessage(Ticket ticket,Customer customer) {
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
