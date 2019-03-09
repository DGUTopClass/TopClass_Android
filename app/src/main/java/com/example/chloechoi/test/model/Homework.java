package com.example.chloechoi.test.model;

import android.util.Log;

import com.example.chloechoi.test.utility.Constants;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework {
    private String title;
    private String subject;
    private String startDate;
    private String finishDate;
    private String contents;
    private String memo;

    // 지난 과제
    private double score;
    private Boolean isHanded;
    private String feedback;

    Constants constants = new Constants();

    public String toTvScore(){
        return Double.toString(score) + " / 10.0";
    }

    public String toShowStartDate(){
        String s = null;

        // new date format
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

        try {
            // old date format
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
            s = formatter.format(date);

        } catch (ParseException e){
            s = "01/01 00:00";
            Log.e("parse exception","at toShowDeadline()");
        }
        return s;
    }

    public String toShowFinishDate(int type){
        String s = null;
        SimpleDateFormat formatter = null;

        // new date format
        if(type == constants.TYPE_TO_BE_SUMMITED_HW) {
            formatter = new SimpleDateFormat("MM/dd HH:mm");
            Log.v("toShowFinishDate()","i'm in initialing formatter by type_to_be_summited");
        } else if(type == constants.TYPE_HW_DETAIL){
            formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Log.v("toShowFinishDate()","i'm in initialing formatter by type_hw_detail");
        }


        try {
            // old date format
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(finishDate);
            s = formatter.format(date);

        } catch (ParseException e){
            s = "01/01 00:00";
            Log.e("parse exception","at toShowDeadline()");
        }
        return s;

    }

    public Homework getToBeSummitedDummy(){
        Homework h = new Homework();
        h.title = " 과제 01";
        h.subject = "데이터통신입문";

        h.finishDate="2019-03-15 15:00:00";

        return h;
    }

    public Homework getToBeSummitedDummy2(){
        Homework h = new Homework();
        h.title = "USECASE";
        h.subject = "소프트웨어공학개론";

        h.finishDate="2019-03-10 17:00:00";

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

    public Homework getDetailDummy(){

        Log.v("where i am","getDetailDummy");

        Homework h = new Homework();
        h.title = " 과제 01";
        h.subject = "데이터통신입문";
        h.startDate ="2019-03-01 15:00:00";
        h.finishDate="2019-03-15 15:00:00";
        h.contents = "9월 4일 화요일 수업시간에 시청했던 OT영상에서 사용한 자료를 첨부합니다. 학생들은 9월 11일 화요일까지 Team-Up 및 팀별 주제에 대한 PPT발표를 준비해오시기 바랍니다. (팀이 정해지지 않은 인원들은 개인별로 PPT를 준비해주시기 바라며 제한시간은 똑같이 유지됩니다.) 빈칸채우기 중입니다. 방해 9월 4일 화요일 수업시간에 시청했던 OT영상에서 사용한 Homework자료를 첨부합니다. 학생들은 9월 11일 화요일까지 Team-Up 및 팀별 주제에 대한 PPT발표를 준비해오시기 바랍니다.(팀이 정해지지 않은 인원들은 개인별로 PPT를 준비해주시기 바라며 제한시간은 똑같이 유지됩니다.)";
        h.memo = "총 6문제, 고운이한테 물어보기";


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
    public String getStartDate(){
        return startDate;
    }
    public String getFinishDate() {
        return finishDate;
    }
    public String getContents(){
        return contents;
    }
    public double getScore() {
        return score;
    }
    public String getFeedback() {
        return feedback;
    }
    public String getMemo(){return memo; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setHanded(Boolean handed) {
        isHanded = handed;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public void setMemo(String memo){ this.memo = memo; }

}
