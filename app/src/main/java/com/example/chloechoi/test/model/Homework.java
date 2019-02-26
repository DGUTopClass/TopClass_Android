package com.example.chloechoi.test.model;

public class Homework {
    private String title;
    private String subject;

    private String deadline;

    // 지난 과제
    private double score;
    private Boolean isHanded;
    private String feedback;

    public String toTvScore(){
        return Double.toString(score) + " / 10.0";
    }


    public Homework getToBeSummitedDummy(){
        Homework h = new Homework();
        h.title = " 과제 01";
        h.subject = "데이터통신입문";

        // 통신 후에 어떻게 자를지 고민
        h.deadline="12/29 17:00";

        // priority color는 adapter에서 자르기

        return h;
    }


    public Homework getSummitedDummy(){
        Homework h = new Homework();
        h.title = "주기율표";
        h.subject = "화학개론";
        h.isHanded = false;
        h.score = 9.5;
        h.feedback="피드백이다.";

        return h;
    }

    // getter, setter
    public String getTitle() {
        return title;
    }
    public String getSubject() {
        return subject;
    }
    public Boolean getHanded() {
        return isHanded;
    }
    public String getDeadline() {
        return deadline;
    }
    public double getScore() {
        return score;
    }
    public String getFeedback() {
        return feedback;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setHanded(Boolean handed) {
        isHanded = handed;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
