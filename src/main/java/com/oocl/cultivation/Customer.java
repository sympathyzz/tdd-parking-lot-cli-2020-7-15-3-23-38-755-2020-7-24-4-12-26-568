package com.oocl.cultivation;

public class Customer {
    private Car car;
    private Ticket ticket;


    public Car getCar() {
        return car;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void parkCar(Car car){
        ParkingBoy parkingBoy=new ParkingBoy();
        this.ticket=parkingBoy.park(car);
    }

    public void fetchCar(Ticket ticket) {
        ParkingBoy parkingBoy=new ParkingBoy();
        this.car=parkingBoy.checkTicketToReturnCar(ticket);
    }
}
