package com.example.chloechoi.test.model.Calendar;

public class Schedule {
    private String id;
    private String title;
    private int priority;

    public Schedule(){
        this.id = "";
        this.title = "";
        this.priority = 0;
    }

    public Schedule(String id, String title){
        this.id = id;
        this.title = title;
        this.priority = 0;
    }
}
