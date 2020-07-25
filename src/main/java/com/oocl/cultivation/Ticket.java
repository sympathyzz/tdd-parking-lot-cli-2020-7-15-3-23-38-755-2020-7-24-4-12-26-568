package com.oocl.cultivation;

public class Ticket {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Ticket(Car car) {
        this.car = car;
    }

}
