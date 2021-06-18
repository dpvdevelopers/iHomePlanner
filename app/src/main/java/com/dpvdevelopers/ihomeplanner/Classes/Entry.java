package com.dpvdevelopers.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;

public class Entry {
    private int id;
    private String name;
    private String detail;
    private float incomeAmount;
    private Date creationDate;
    private double userId;
    private boolean isIncome;
    private String currency;
    /*
                                CONSTRUCTORES
     */

    public Entry(int id, String name, String detail, float incomeAmount, Date creationDate, double userId, boolean isIncome, String currency) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.incomeAmount = incomeAmount;
        this.creationDate = creationDate;
        this.userId = userId;
        this.isIncome = isIncome;
        this.currency = currency;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Entry() {
        this.id = 0;
        this.name = "";
        this.detail = "";
        this.incomeAmount = 0;
        this.creationDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.userId = 0;
        this.isIncome = true;
        this.currency = "Euro";
    }
    public Entry(Entry e) {
        this.id = e.id;
        this.name = e.name;
        this.detail = e.detail;
        this.incomeAmount = e.incomeAmount;
        this.creationDate = e.creationDate;
        this.userId = e.userId;
        this.isIncome = e.isIncome;
        this.currency = e.currency;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Entry(String name, String detail, float incomeAmount, double userId) {
        this.id = 0;
        this.name = name;
        this.detail = detail;
        this.incomeAmount = incomeAmount;
        this.creationDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.userId = userId;
        this.isIncome = true;
        this.currency = "Euro";
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(float incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Double.compare(entry.id, id) == 0 &&
                Double.compare(entry.userId, userId) == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", incomeAmount=" + incomeAmount +
                ", creationDate=" + creationDate +
                '}';
    }
}
