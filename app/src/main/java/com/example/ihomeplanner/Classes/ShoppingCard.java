package com.example.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;

public class ShoppingCard {
    private double id;
    private double ownerId;
    private boolean isPublic;
    private Date creationDate;
    private ArrayList<ShoppingCardLine> lines;
    /*
                            CONSTRUCTORES
     */

    public ShoppingCard(double id, double ownerId, boolean isPublic, Date creationDate, ArrayList<ShoppingCardLine> lines) {
        this.id = id;
        this.ownerId = ownerId;
        this.isPublic = isPublic;
        this.creationDate = creationDate;
        this.lines = lines;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ShoppingCard() {
        this.id = 0;
        this.ownerId = 0;
        this.isPublic = false;
        this.creationDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.lines = new ArrayList<ShoppingCardLine>();
    }
    public ShoppingCard(ShoppingCard s) {
        this.id = s.id;
        this.ownerId = s.ownerId;
        this.isPublic = s.isPublic;
        this.creationDate = s.creationDate;
        this.lines = s.lines;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ShoppingCard(double ownerId) {
        this.id = 0;
        this.ownerId = ownerId;
        this.isPublic = false;
        this.creationDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.lines = new ArrayList<ShoppingCardLine>();
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

    public double getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(double ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ArrayList<ShoppingCardLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<ShoppingCardLine> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCard)) return false;
        ShoppingCard that = (ShoppingCard) o;
        return Double.compare(that.id, id) == 0 &&
                Double.compare(that.ownerId, ownerId) == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId);
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", isPublic=" + isPublic +
                ", creationDate=" + creationDate +
                '}';
    }
}
