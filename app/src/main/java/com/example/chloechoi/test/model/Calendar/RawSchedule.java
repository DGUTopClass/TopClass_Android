package com.example.chloechoi.test.model.Calendar;

public class RawSchedule {
    private String id;
    private String title;
    private String startDate;
    private String startTime;
    private String finishDate;
    private String finishTime;

    public RawSchedule(String id, String title, String startDate, String startTime,
                       String finishDate, String finishTime){
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.finishDate = finishDate;
        this.finishTime = finishTime;
    }

//    public void getDummyData(){
//
//    }

    public String getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getStartDate(){ return this.startDate; }
    public String getFinishDate(){ return this.finishDate; }
}
