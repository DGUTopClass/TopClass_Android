package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.TodoAddPickerActivity;
import com.example.chloechoi.test.utility.Constants;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class TodoAddFragment extends Fragment implements View.OnClickListener{

    // TODO 아니 배경 투명하게 어찌 했더라....할애 찾아보기... 했던 것도 못하면 어떠케 바보야....
    Intent intent;
    TextView startDate;
    TextView endDate;
    TextView startTime;
    TextView endTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todolist_add, container, false);


        // Initialize View
        startDate = view.findViewById(R.id.tv_add_start_date);
        endDate = view.findViewById(R.id.tv_add_end_date);
        startTime = view.findViewById(R.id.tv_add_start_time);
        endTime = view.findViewById(R.id.tv_add_end_time);

        LinearLayout startArea = view.findViewById(R.id.add_start);
        LinearLayout endArea = view.findViewById(R.id.add_end);


        // 시작, 종료 날짜 기본 값 오늘 날짜로 설정하기
        setDefaultDate();



        // setOnClickListener
        startArea.setOnClickListener(this);
        endArea.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);


        // get result data
        ArrayList<String> resultStartDate = new ArrayList<>();
        ArrayList<String> resultEndDate = new ArrayList<>();
        if(data != null){
            if (requestCode == Constants.REQUEST_CODE && resultCode == Constants.RESULT_CODE ){
                resultStartDate = data.getStringArrayListExtra("startDate");
                resultEndDate = data.getStringArrayListExtra("endDate");
            }
            else {
                // request code or result code is wrong
            }
            // set data on text view
            if(resultStartDate.get(2).length() == 1){
                resultStartDate.add(2,"0" + resultStartDate.get(2));
            }
            if(resultStartDate.get(3).length() == 1){
                resultStartDate.add(3,"0" + resultStartDate.get(3));
            }
            if(resultEndDate.get(2).length() == 1){
                resultEndDate.add(2,"0" + resultEndDate.get(2));
            }
            if(resultEndDate.get(3).length() == 1){
                resultEndDate.add(3,"0" + resultEndDate.get(3));
            }
            setDate(Integer.parseInt(resultStartDate.get(0)),Integer.parseInt(resultStartDate.get(1)),resultStartDate.get(2),resultStartDate.get(3),
                    Integer.parseInt(resultEndDate.get(0)),Integer.parseInt(resultEndDate.get(1)),resultEndDate.get(2),resultEndDate.get(3));
        }
        else {
            // data is null
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_start :
                intent = new Intent(getActivity(),TodoAddPickerActivity.class);
                intent.putExtra("isStart",Constants.TYPE_START);
                intent.putExtra("datas",getData());
                break;
            case R.id.add_end:
                intent = new Intent(getActivity(),TodoAddPickerActivity.class);
                intent.putExtra("isStart",Constants.TYPE_END);
                intent.putExtra("datas",getData());
                break;
        }
        startActivityForResult(intent,Constants.REQUEST_CODE);
    }

    String translateToKro(int dayNum){
        String dayKor = "";
        switch (dayNum){
            case 1:
                dayKor = "일";
                break;
            case 2:
                dayKor = "월";
                break;
            case 3:
                dayKor = "화";
                break;
            case 4:
                dayKor = "수";
                break;
            case 5:
                dayKor = "목";
                break;
            case 6:
                dayKor = "금";
                break;
            case 7:
                dayKor = "토";
                break;
        }
        return dayKor;
    }

    void setDefaultDate(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        String dayKor = translateToKro(cal.get(Calendar.DAY_OF_WEEK));
        startDate.setText(month + "월 " + date + "일" + " (" + dayKor + ")");
        startTime.setText(Constants.DEFAULT_START_TIME);
        endDate.setText(month + "월 " + date + "일" + " (" + dayKor + ")");
        endTime.setText(Constants.DEFAULT_END_TIME);
    }


    // index 순서 : 시작날짜 시작시간 종료날짜 종료시간
    ArrayList<String> getData(){
        ArrayList<String> dates = new ArrayList<>();
        dates.add(startDate.getText().toString());
        dates.add(startTime.getText().toString());
        dates.add(endDate.getText().toString());
        dates.add(endTime.getText().toString());

        return dates;
    }

    String getDayOfWeek(int year, int month, int day){
        Calendar cal = Calendar.getInstance();
        cal.set(year,month,day);
        return translateToKro(cal.get(Calendar.DAY_OF_WEEK));
    }

    // 매개변수 arr로 할까?
    // data format : mm dd hh mm (int 두자리로)
    void setDate(int monthS, int dayS, String hourS, String minuteS, int monthE, int dayE, String hourE, String minuteE){
        Calendar cal = Calendar.getInstance();

        startDate.setText(monthS + "월 " + dayS + "일" + " (" + getDayOfWeek(cal.get(Calendar.YEAR),monthS,dayS) +")");
        startTime.setText(hourS + ":" + minuteS);
        endDate.setText(monthE + "월 " + dayE + "일" + " (" + getDayOfWeek(cal.get(Calendar.YEAR),monthE,dayE) +")");
        endTime.setText(hourE + ":" + minuteE);
    }

}
