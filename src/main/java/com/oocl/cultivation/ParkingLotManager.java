package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {

    protected   List<ParkingLot> allParkingLot=new ArrayList<>();
    private List<ParkingBoy> managementList=new ArrayList<>();
    public void addParkingBoyToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public ParkingLotManager(List<ParkingLot> allParkingLot) {
        this.allParkingLot = allParkingLot;
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
