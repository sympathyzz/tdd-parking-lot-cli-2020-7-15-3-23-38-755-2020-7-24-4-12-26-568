package com.oocl.cultivation;

public class Customer {
    private Car car;
    private Ticket ticket;

    public Customer(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
