package com.ameen;

class car_diesel extends car {

    car_diesel(int odometer) {
        super(odometer);
        this.odometer = odometer;
    }

    String get_maintenance() {
        String tmp = "";
        if(getOil_change())
            tmp += " Oil Change.";
        if(getTire_rotation())
            tmp += " Tire Rotation.";
        if(getGears_checked())
            tmp += " Gears Check.";
        if(tmp.length() != 0)
            return "@" + odometer + tmp;
        else
            return "";
    }

    private boolean getOil_change() {
        return ((this.odometer % 4000) < 100) | ((this.odometer % 4000) > 3900);
    }

    private boolean getGears_checked() {
        return ((this.odometer % 20000) < 500) | ((this.odometer % 20000) > 19500);
    }
}
