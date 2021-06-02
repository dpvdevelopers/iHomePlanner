package com.example.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;

public class Vehicle {
    private double id;
    private String brand;
    private String model;
    private String vin;
    private String detail;
    private Date date;
    private String type;
    private User owner;
    private int kms;
    /*
                                    CONSTRUCTORES
     */

    public Vehicle(double id, String brand, String model, String vin, String detail, Date date, String type, User owner, int kms) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.vin = vin;
        this.detail = detail;
        this.date = date;
        this.type = type;
        this.owner = owner;
        this.kms = kms;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Vehicle() {
        this.id = 0;
        this.brand = "";
        this.model = "";
        this.vin = "";
        this.detail = "";
        this.date = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.type = "";
        this.owner = new User();
        this.kms = 0;
    }
    public Vehicle(Vehicle v) {
        this.id = v.id;
        this.brand = v.brand;
        this.model = v.model;
        this.vin = v.vin;
        this.detail = v.detail;
        this.date = v.date;
        this.type = v.type;
        this.owner = v.owner;
        this.kms = v.kms;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Vehicle(String brand, String model, String detail, User owner) {
        this.id = 0;
        this.brand = brand;
        this.model = model;
        this.vin = "";
        this.detail = detail;
        this.date = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.type = "Coche";
        this.owner = owner;
        this.kms = 0;
    }
    /*
                                FIN CONSTRUCTORES
     */

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.id, id) == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", detail='" + detail + '\'' +
                ", kms=" + kms +
                '}';
    }
}
