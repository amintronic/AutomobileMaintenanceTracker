package com.ameen;

class car_electric extends car{

    car_electric(int odometer) {
        super(odometer);
        this.odometer = odometer;
    }

    String get_maintenance() {
        String tmp = "";
        if(getBattery_check())
            tmp += " Battery Check.";
        if(getTire_rotation())
            tmp += " Tire Rotation.";
        if(tmp.length() != 0)
            return "@" + odometer + tmp;
        else
            return "";
    }
    private boolean getBattery_check() {
        return ((this.odometer % 10000) < 100) | ((this.odometer % 10000) > 9900);
    }
}
