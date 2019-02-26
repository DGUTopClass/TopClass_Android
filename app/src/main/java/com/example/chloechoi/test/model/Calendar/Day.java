package com.example.chloechoi.test.model.Calendar;

import java.util.ArrayList;

public class Day {
    private int day;
    private ArrayList<Schedule> schedules;

    public Day(int day){
        this.day = day;
        schedules = new ArrayList<Schedule>();
    }

    public void setSchedule(Schedule schedule){
        this.schedules.add(schedule);
    }

    public int getDay() {return this.day;}
}
