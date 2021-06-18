package com.dpvdevelopers.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;

public class Event {
    private int id;
    private ArrayList<User> asignedUsers;
    private User owner;
    private String title;
    private String detail;
    private Date creationDate;
    private boolean fullDay;
    private boolean isPublic;
    private String category;
    /*
                            CONSTRUCTORES
     */

    public Event(int id, ArrayList<User> asignedUsers, User owner, String title, String detail, Date creationDate, boolean fullDay, boolean isPublic, String category) {
        this.id = id;
        this.asignedUsers = asignedUsers;
        this.owner = owner;
        this.title = title;
        this.detail = detail;
        this.creationDate = creationDate;
        this.fullDay = fullDay;
        this.isPublic = isPublic;
        this.category = category;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Event() {
        this.id = 0;
        this.asignedUsers = new ArrayList<User>();
        this.owner = new User();
        this.title = "";
        this.detail = "";
        this.creationDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.fullDay = false;
        this.isPublic = false;
        this.category = "";
    }
    public Event(Event e) {
        this.id = e.id;
        this.asignedUsers = e.asignedUsers;
        this.owner = e.owner;
        this.title = e.title;
        this.detail = e.detail;
        this.creationDate = e.creationDate;
        this.fullDay = e.fullDay;
        this.isPublic = e.isPublic;
        this.category = e.category;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Event(ArrayList<User> asignedUsers, User owner, String title) {
        this.id = 0;
        this.asignedUsers = asignedUsers;
        this.owner = owner;
        this.title = title;
        this.detail = "";
        this.creationDate = java.sql.Date.valueOf(Date.from(Instant.now()).toString());
        this.fullDay = false;
        this.isPublic = false;
        this.category = "";
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

    public ArrayList<User> getAsignedUsers() {
        return asignedUsers;
    }

    public void setAsignedUsers(ArrayList<User> asignedUsers) {
        this.asignedUsers = asignedUsers;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isFullDay() {
        return fullDay;
    }

    public void setFullDay(boolean fullDay) {
        this.fullDay = fullDay;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Double.compare(event.id, id) == 0 &&
                owner.equals(event.owner);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, owner);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", asignedUsers=" + asignedUsers +
                ", owner=" + owner +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", creationDate=" + creationDate +
                ", fullDay=" + fullDay +
                ", isPublic=" + isPublic +
                ", category='" + category + '\'' +
                '}';
    }
}
