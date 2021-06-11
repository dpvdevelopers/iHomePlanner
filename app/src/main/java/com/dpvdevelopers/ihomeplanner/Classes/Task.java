package com.dpvdevelopers.ihomeplanner.Classes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.util.Objects;

/**
 * This class is for manage task
 */
public class Task implements Serializable {
    private double id;
    private double userId;
    private String title;
    private String detail;
    private Date date;
    private Time time;
    private Date endTime;
    private boolean fullDay;
    private float duration;

    /**
     * This is a complete constructor to create a new instance to Task class
     * @param id This is the unique id for the task. Object double
     * @param userId This is a double. Contains an id from the user that create the task
     * @param title This is a String with a  Max length of 45 char
     * @param detail This is a String with a  Max length of 300 char
     * @param date
     * @param time
     * @param endTime
     * @param fullDay
     * @param duration
     */
    public Task(double id, double userId, String title, String detail, Date date, Time time, Date endTime, boolean fullDay, float duration) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.time = time;
        this.endTime = endTime;
        this.fullDay = fullDay;
        this.duration = duration;
    }
    public Task(Task t) {
        this.id = t.id;
        this.userId = t.userId;
        this.title = t.title;
        this.detail = t.detail;
        this.date = t.date;
        this.time = t.time;
        this.endTime = t.endTime;
        this.fullDay = t.fullDay;
        this.duration = t.duration;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Task() {
        this.id = 0;
        this.userId = 0;
        this.title = "";
        this.detail = "";
        this.date = Date.valueOf(java.util.Date.from(Instant.now()).toString());
        this.time = Time.valueOf(java.util.Date.from(Instant.now()).toString());
        this.endTime = Date.valueOf(java.util.Date.from(Instant.now()).toString());
        this.fullDay = false;
        this.duration = 0;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Task(double id) {
        this.id = id;
        this.userId = 0;
        this.title = "";
        this.detail = "";
        this.date = Date.valueOf(java.util.Date.from(Instant.now()).toString());
        this.time = Time.valueOf(java.util.Date.from(Instant.now()).toString());
        this.endTime = Date.valueOf(java.util.Date.from(Instant.now()).toString());
        this.fullDay = false;
        this.duration = 0;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Task(double userId, String title, String detail) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.detail = detail;
        this.date = Date.valueOf(java.util.Date.from(Instant.now()).toString());
        this.time = Time.valueOf(java.util.Date.from(Instant.now()).toString());
        this.endTime = Date.valueOf(java.util.Date.from(Instant.now()).toString());
        this.fullDay = false;
        this.duration = 0;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isFullDay() {
        return fullDay;
    }

    public void setFullDay(boolean fullDay) {
        this.fullDay = fullDay;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
    /*
                FIN GETTERS AND SETTERS

     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Double.compare(task.id, id) == 0 &&
                Double.compare(task.userId, userId) == 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
