package com.example.ihomeplanner.Classes;

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
}
