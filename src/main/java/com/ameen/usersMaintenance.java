package com.ameen;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "user")

public class usersMaintenance implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String make;
    private String model;
    private String type;
    private String year;
    private String license_no;
    private String vin;
    private int odometer;
    private String maintenance;

    public usersMaintenance() {}

    public usersMaintenance(int id, String make, String model, String type, String year, String license_no,
                            String vin, int odometer, String maintenance){
        this.id = id;
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.license_no = license_no;
        this.vin = vin;
        this.odometer = odometer;
        this.maintenance = maintenance;
    }
    public int get_id() { return id; }
    @XmlElement
    public void set_id(int id) {
        this.id = id;
    }
    public String get_make() {
        return make;
    }
    @XmlElement
    public void set_make(String make) {
        this.make = make;
    }
    public String get_model() { return model; }
    @XmlElement
    public void set_model(String model) {
        this.model = model;
    }
    public String get_type() { return type; }
    @XmlElement
    public void set_type(String type) {
        this.type = type;
    }
    public String get_year() {
        return year;
    }
    @XmlElement
    public void set_year(String year) {
        this.year = year;
    }
    public String get_license_no() {
        return license_no;
    }
    @XmlElement
    public void set_license_no(String license_no) {
        this.license_no = license_no;
    }
    public String get_vin() {
        return vin;
    }
    @XmlElement
    public void set_vin(String vin) {
        this.vin = vin;
    }
    public int get_odometer() {
        return odometer;
    }
    @XmlElement
    public void set_odometer(int odometer) {
        this.odometer = odometer;
    }
    public String get_maintenance() {
        return maintenance;
    }
    @XmlElement
    public void set_maintenance(String maintenance) {
        this.maintenance = maintenance;
    }
}
