package com.ameen;

class car {
    int odometer;

    car(int odometer){
        this.odometer = odometer;
    }

    public boolean getTire_rotation() {
        return ((this.odometer % 50000) < 1000) | ((this.odometer % 50000) > 49000);
    }
}
