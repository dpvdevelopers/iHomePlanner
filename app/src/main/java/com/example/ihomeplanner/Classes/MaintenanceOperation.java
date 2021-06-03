package com.example.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;

public class MaintenanceOperation {
    private double id;
    private double userId;
    private double vehicleId;
    private Date operationDate;
    private Date expectedDate;
    private boolean closed;
    /*
                                CONSTRUCTORES
     */

    public MaintenanceOperation(double id, double userId, double vehicleId, Date operationDate, Date expectedDate, boolean closed) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.operationDate = operationDate;
        this.expectedDate = expectedDate;
        this.closed = closed;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MaintenanceOperation() {
        this.id = 0;
        this.userId = 0;
        this.vehicleId = 0;
        this.operationDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.expectedDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.closed = false;
    }
    public MaintenanceOperation(MaintenanceOperation m) {
        this.id = m.id;
        this.userId = m.userId;
        this.vehicleId = m.vehicleId;
        this.operationDate = m.operationDate;
        this.expectedDate = m.expectedDate;
        this.closed = m.closed;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MaintenanceOperation(double userId, double vehicleId, Date operationDate) {
        this.id = 0;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.operationDate = operationDate;
        this.expectedDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.closed = false;
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

    public double getUserId() {
        return userId;
    }

    public void setUserId(double userId) {
        this.userId = userId;
    }

    public double getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(double vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaintenanceOperation)) return false;
        MaintenanceOperation that = (MaintenanceOperation) o;
        return Double.compare(that.id, id) == 0 &&
                Double.compare(that.userId, userId) == 0 &&
                Double.compare(that.vehicleId, vehicleId) == 0 &&
                operationDate.equals(that.operationDate);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, userId, vehicleId, operationDate);
    }

    @Override
    public String toString() {
        return "MaintenanceOperation{" +
                "id=" + id +
                ", userId=" + userId +
                ", vehicleId=" + vehicleId +
                ", operationDate=" + operationDate +
                ", expectedDate=" + expectedDate +
                ", closed=" + closed +
                '}';
    }
}
