package com.ironhack.bootcamp.s5.previously;

import java.util.Date;

/**
 * - With and without constructor
 * - Call super() vs change field visibility
 * - use of this
 * - strategies.
 */
public class Course {
    private String name;
    private Integer numHours;
    private Boolean started;
    protected Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Course(String name, Integer numHours, Boolean started, Date startDate) {
        this.name = name;
        this.numHours = numHours;
        this.started = started;
        this.startDate = startDate;
    }

    public Course() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumHours() {
        return numHours;
    }

    public void setNumHours(Integer numHours) {
        this.numHours = numHours;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }
}
