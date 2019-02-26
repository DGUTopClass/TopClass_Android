package com.example.chloechoi.test.model;

public class NoticeData {

    public String subject;
    public String title;
    public String date;
    public String contents;

    public NoticeData getDummy(){
        NoticeData n = new NoticeData();
        n.subject = "소프트웨어공학개론";
        n.title = "StarUML 튜토리얼";
        n.date = "12/05";
        n.contents="StarUML 튜토리얼은 강의 계획서에 5주차(10/2)에 링크되어 있습니다. 앞으로 모든 과제와 플립러닝의 강의실 활동에서는 이 도구를 사용하겠습니다.";

        return n;
    }

}
