package com.ameen;

class car_gas extends car {

    car_gas(int odometer) {
        super(odometer);
        this.odometer = odometer;
    }

    String get_maintenance() {
        String tmp = "";
        if(getOil_change())
            tmp += " Oil Change.";
        if(getTire_rotation())
            tmp += " Tire Rotation.";
        if(getSparking_plug_checked())
            tmp += " Sparking Plug Check.";
        if(tmp.length() != 0)
            return "@" + odometer + tmp;
        else
            return "";
    }

    private boolean getOil_change() {
        return ((this.odometer % 5000) < 100) | ((this.odometer % 5000) > 4900);
    }

    private boolean getSparking_plug_checked() {
        return ((this.odometer % 50000) < 100) | ((this.odometer % 50000) > 49000);
    }
}
