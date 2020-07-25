package com.oocl.cultivation;

import java.util.*;

public class SmartParkingBoy extends ParkingBoy{
    private Map<Integer,Integer> parkingLotMap=new HashMap<>();
    public Ticket park(Car car, Customer customer) {
        for(int i=0;i<allParkingLot.size();i++){
            int freeParkingLotNumber=allParkingLot.get(i).getCapacity()-allParkingLot.get(i).getParkingRooms().size();
            parkingLotMap.put(i,freeParkingLotNumber);
        }
        Collection<Integer> parkingLotMapValueCollection = parkingLotMap.values();
        List<Integer> freeParkingLotNumberList = new ArrayList<>(parkingLotMapValueCollection);
        int maxFreeParkingLotNumber=freeParkingLotNumberList.get(0);
        int maxFreeParkingLotNumberKey=0;
        for (int i=0;i<freeParkingLotNumberList.size();i++){
            if (maxFreeParkingLotNumber<freeParkingLotNumberList.get(i)){
                maxFreeParkingLotNumber=freeParkingLotNumberList.get(i);
                maxFreeParkingLotNumberKey=i;
            }
        }
        if(maxFreeParkingLotNumber!=0){
            Ticket ticket = new Ticket(car);
            allParkingLot.get(maxFreeParkingLotNumberKey).getParkingRooms().put(ticket, car);
            car.setIsParking(true);
            customer.setTicket(ticket);
            return ticket;
        }
        sendMessage(null,customer);
        return null;
    }

}
