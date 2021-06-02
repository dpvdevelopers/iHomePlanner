package com.example.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Maintenance {
    private double id;
    private double vehicleId;
    private boolean isPeriodic;
    private int periodDays;
    private int periodKms;
    private String type;
    private String name;
    private String detail;
    private float price;
    /*
                                        CONSTRUCTORES
     */

    public Maintenance(double id, double vehicleId, boolean isPeriodic, int periodDays, int periodKms, String type, String name, String detail, float price) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.isPeriodic = isPeriodic;
        this.periodDays = periodDays;
        this.periodKms = periodKms;
        this.type = type;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }
    public Maintenance() {
        this.id = 0;
        this.vehicleId = 0;
        this.isPeriodic = false;
        this.periodDays = 0;
        this.periodKms = 0;
        this.type = "";
        this.name = "";
        this.detail = "";
        this.price = 0;
    }
    public Maintenance(Maintenance m) {
        this.id = m.id;
        this.vehicleId = m.vehicleId;
        this.isPeriodic = m.isPeriodic;
        this.periodDays = m.periodDays;
        this.periodKms = m.periodKms;
        this.type = m.type;
        this.name = m.name;
        this.detail = m.detail;
        this.price = m.price;
    }
    public Maintenance(double vehicleId, String type, String name, String detail, float price) {
        this.id = 0;
        this.vehicleId = vehicleId;
        this.isPeriodic = false;
        this.periodDays = 0;
        this.periodKms = 0;
        this.type = type;
        this.name = name;
        this.detail = detail;
        this.price = price;
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

    public double getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(double vehicleId) {
        this.vehicleId = vehicleId;
    }

    public boolean isPeriodic() {
        return isPeriodic;
    }

    public void setPeriodic(boolean periodic) {
        isPeriodic = periodic;
    }

    public int getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(int periodDays) {
        this.periodDays = periodDays;
    }

    public int getPeriodKms() {
        return periodKms;
    }

    public void setPeriodKms(int periodKms) {
        this.periodKms = periodKms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Maintenance)) return false;
        Maintenance that = (Maintenance) o;
        return Double.compare(that.id, id) == 0 &&
                Double.compare(that.vehicleId, vehicleId) == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, vehicleId);
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", isPeriodic=" + isPeriodic +
                ", periodDays=" + periodDays +
                ", periodKms=" + periodKms +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }
}
