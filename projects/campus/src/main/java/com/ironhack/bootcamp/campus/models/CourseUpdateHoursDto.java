package com.ironhack.bootcamp.campus.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CourseUpdateHoursDto {

    @NotNull
    @Min(0)
    private Integer hours;

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
