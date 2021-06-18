package com.dpvdevelopers.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class User {
    private int id;
    private int level;
    private int license;
    private String name;
    private String lastName;
    private String mail;
    private double groupId;

    /*
                            CONSTRUCTORES
     */
    public User(int id, int level, int license, String name, String lastName, String mail, double groupId) {
        this.id = id;
        this.level = level;
        this.license = license;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.groupId = groupId;
    }
    public User() {
        this.id = 0;
        this.level = 0;
        this.license = 0;
        this.name = "";
        this.lastName = "";
        this.mail = "";
        this.groupId = 0;
    }
    public User(User u) {
        this.id = u.id;
        this.level = u.level;
        this.license = u.license;
        this.name = u.name;
        this.lastName = u.lastName;
        this.mail = u.mail;
        this.groupId = u.groupId;
    }
    public User(String name, String lastName, String mail) {
        this.id = 0;
        this.level = 0;
        this.license = 0;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.groupId = 0;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getGroupId() {
        return groupId;
    }

    public void setGroupId(double groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Double.compare(user.id, id) == 0 &&
                mail.equals(user.mail);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, mail);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", license=" + license +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
