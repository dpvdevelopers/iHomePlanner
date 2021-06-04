package com.dpvdevelopers.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Group {
    private double id;
    private String name;
    private int totalUsers;
    private int license;

    /*
                                CONSTRUCTORES
     */

    public Group(double id, String name, int totalUsers, int license) {
        this.id = id;
        this.name = name;
        this.totalUsers = totalUsers;
        this.license = license;
    }
    public Group() {
        this.id = 0;
        this.name = "";
        this.totalUsers = 0;
        this.license = 0;
    }
    public Group(Group g) {
        this.id = g.id;
        this.name = g.name;
        this.totalUsers = g.totalUsers;
        this.license = g.license;
    }
    public Group(String name, int license) {
        this.id = 0;
        this.name = name;
        this.totalUsers = 0;
        this.license = license;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Double.compare(group.id, id) == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", totalUsers=" + totalUsers +
                ", license=" + license +
                '}';
    }
}
