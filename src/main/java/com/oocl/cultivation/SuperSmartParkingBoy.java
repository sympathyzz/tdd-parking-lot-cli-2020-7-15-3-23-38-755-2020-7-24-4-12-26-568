package com.oocl.cultivation;

import java.util.*;

public class SuperSmartParkingBoy extends ParkingBoy {

    private Map<Integer,Double> availablePositionRateMap=new HashMap<>();

    public SuperSmartParkingBoy(int id) {
        super(id);
    }

    public Ticket park(Car car, Customer customer) {
        for(int i=0;i<allParkingLot.size();i++){
            double freeParkingLotNumber=allParkingLot.get(i).getCapacity()-allParkingLot.get(i).getParkingRooms().size();
            double totalCapacity=allParkingLot.get(i).getCapacity();
            double availablePositionRate=freeParkingLotNumber/totalCapacity;
            availablePositionRateMap.put(i,availablePositionRate);
        }
        Collection<Double> availablePositionRateMapValueCollection = availablePositionRateMap.values();
        List<Double> availablePositionRateList = new ArrayList<>(availablePositionRateMapValueCollection);
        double maxAvailablePositionRate=availablePositionRateList.get(0);
        int maxAvailablePositionRateKey=0;
        for (int i=0;i<availablePositionRateList.size();i++){
            if (maxAvailablePositionRate<availablePositionRateList.get(i)){
                maxAvailablePositionRate=availablePositionRateList.get(i);
                maxAvailablePositionRateKey=i;
            }
        }
        if(maxAvailablePositionRate!=(double) 0){
            Ticket ticket = new Ticket(car);
            allParkingLot.get(maxAvailablePositionRateKey).getParkingRooms().put(ticket, car);
            car.setIsParking(true);
            customer.setTicket(ticket);
            return ticket;
        }
        sendMessage(null,customer);
        return null;
    }
}
