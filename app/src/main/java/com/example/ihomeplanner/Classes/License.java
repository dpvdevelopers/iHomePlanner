package com.example.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class License {
    private int id;
    private String name;
    private float price;
    private int days;
    private int maxUserLimit;

    /*
                        CONSTRUCTORES
     */

    public License(int id, String name, float price, int days, int maxUserLimit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.days = days;
        this.maxUserLimit = maxUserLimit;
    }
    public License() {
        this.id = 0;
        this.name = "";
        this.price = 0.0f;
        this.days = 0;
        this.maxUserLimit = 0;
    }
    public License(License l) {
        this.id = l.id;
        this.name = l.name;
        this.price = l.price;
        this.days = l.days;
        this.maxUserLimit = l.maxUserLimit;
    }
    public License(String name, float price, int days, int maxUserLimit) {
        this.id = 0;
        this.name = name;
        this.price = price;
        this.days = days;
        this.maxUserLimit = maxUserLimit;
    }
    /*
                        FIN CONSTRUCTORES
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getMaxUserLimit() {
        return maxUserLimit;
    }

    public void setMaxUserLimit(int maxUserLimit) {
        this.maxUserLimit = maxUserLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof License)) return false;
        License license = (License) o;
        return Float.compare(license.price, price) == 0 &&
                days == license.days &&
                maxUserLimit == license.maxUserLimit;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(price, days, maxUserLimit);
    }

    @Override
    public String toString() {
        return "License{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", days=" + days +
                ", maxUserLimit=" + maxUserLimit +
                '}';
    }
}
