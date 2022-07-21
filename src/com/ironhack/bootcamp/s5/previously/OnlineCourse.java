package com.ironhack.bootcamp.s5.previously;

import java.util.Date;

/**
 * The platform needs that course start Date is not started in the pass
 */
public class OnlineCourse extends Course{
    private String link;

    public OnlineCourse(String name, Integer numHours, Boolean started, Date startDate) {
        super(name, numHours, started, startDate);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public void setStarted(Boolean started) {
        super.setStartDate(new Date());
        super.setStarted(true);
    }
}
