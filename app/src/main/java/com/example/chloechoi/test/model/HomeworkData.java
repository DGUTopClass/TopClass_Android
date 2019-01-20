package com.example.chloechoi.test.model;

public class HomeworkData {
    public String title;
    public String subject;
    public Boolean isHanded;
    public double score;
    public String feedback;

    public String toTvScore(){
        return Double.toString(score) + " / 10.0";
    }

    public HomeworkData getDummy(){
        HomeworkData h = new HomeworkData();
        h.title = "주기율표";
        h.subject = "화학개론";
        h.isHanded = false;
        h.score = 9.5;
        h.feedback="피드백이다.";

        return h;
    }
}
