package com.example.chloechoi.test.model;

public class Notice {

    private String subject;
    private String title;
    private String date;
    private String contents;

    public Notice getDummy(){
        Notice n = new Notice();
        n.subject = "소프트웨어공학개론";
        n.title = "StarUML 튜토리얼";
        n.date = "12/05";
        n.contents="StarUML 튜토리얼은 강의 계획서에 5주차(10/2)에 링크되어 있습니다. 앞으로 모든 과제와 플립러닝의 강의실 활동에서는 이 도구를 사용하겠습니다.";

        return n;
    }

    // getter, setter
    public String getSubject() {
        return subject;
    }
    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }
    public String getContents() {
        return contents;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
}
