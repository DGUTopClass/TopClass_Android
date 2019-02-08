package com.example.chloechoi.test.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.fragment.TodoAddFragment;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;
import java.util.Calendar;

public class TodoAddPickerActivity extends AppCompatActivity implements View.OnClickListener {


    // TODO
    // numberpicker unfocusing text color change
    // this activity background color change

    TextView startText;
    TextView endText;
    View startBack;
    View endBack;
    // 월 일 시간 분 순서로 들어있음
    ArrayList<String> dateStart = new ArrayList<>();
    ArrayList<String> dateEnd = new ArrayList<>();
    NumberPicker npMonth;
    NumberPicker npDay;
    NumberPicker npHour;
    NumberPicker npMinute;
    Intent intent;
    int isStartFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picker);
        intent = new Intent(this, TodoAddFragment.class);


        // initialize View
        startText = findViewById(R.id.add_start_text);
        endText = findViewById(R.id.add_end_text);
        startBack = findViewById(R.id.add_start_background);
        endBack = findViewById(R.id.add_end_background);
        npMonth = findViewById(R.id.add_picker_month);
        npDay = findViewById(R.id.add_picker_day);
        npHour = findViewById(R.id.add_picker_hour);
        npMinute = findViewById(R.id.add_picker_minute);
        TextView cancelBtn = findViewById(R.id.add_picker_cancel);
        TextView doneBtn = findViewById(R.id.add_picker_done);


        // initialize number picker
        npMonth.setMinValue(1);
        npMonth.setMaxValue(12);

        Calendar cal = Calendar.getInstance();
        npDay.setMinValue(1);
        npDay.setMaxValue(cal.getActualMaximum(Calendar.DATE));

        npHour.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        npHour.setMinValue(0);
        npHour.setMaxValue(23);

        npMinute.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", i);
            }
        });
        npMinute.setMinValue(0);
        npMinute.setMaxValue(59);

        isStartFirst = getIntent().getIntExtra("isStart", 3);
        if(isStartFirst == 3){
            Log.e("intent error","isStart getIntent error");
        }
        ArrayList<String> datas = getIntent().getStringArrayListExtra("datas");

        if(isStartFirst == Constants.TYPE_START){
            dateStart = splitDate(datas.get(0),datas.get(1));
            dateEnd = splitDate(datas.get(2),datas.get(3));
            clearPicker(npMonth,npDay,npHour,npMinute, Integer.parseInt(dateStart.get(0)),Integer.parseInt(dateStart.get(1)),Integer.parseInt(dateStart.get(2)),Integer.parseInt(dateStart.get(3)));
            activateTab(Constants.TYPE_START);
        }
        else if(isStartFirst == Constants.TYPE_END){
            dateStart = splitDate(datas.get(0),datas.get(1));
            dateEnd = splitDate(datas.get(2),datas.get(3));
            clearPicker(npMonth,npDay,npHour,npMinute, Integer.parseInt(dateEnd.get(0)),Integer.parseInt(dateEnd.get(1)),Integer.parseInt(dateEnd.get(2)),Integer.parseInt(dateEnd.get(3)));
            activateTab(Constants.TYPE_END);
        }


        // setOnClickListener
        startText.setOnClickListener(this);
        endText.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        doneBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_start_text :
                storeChangedStartDate(Constants.TYPE_END);
                clearPicker(npMonth,npDay,npHour,npMinute, Integer.parseInt(dateStart.get(0)),Integer.parseInt(dateStart.get(1)),Integer.parseInt(dateStart.get(2)),Integer.parseInt(dateStart.get(3)));
                activateTab(Constants.TYPE_START);
                break;
            case R.id.add_end_text :
                storeChangedStartDate(Constants.TYPE_START);
                clearPicker(npMonth,npDay,npHour,npMinute, Integer.parseInt(dateEnd.get(0)),Integer.parseInt(dateEnd.get(1)),Integer.parseInt(dateEnd.get(2)),Integer.parseInt(dateEnd.get(3)));
                activateTab(Constants.TYPE_END);
                break;
            case R.id.add_picker_cancel :
                setResult(Constants.RESULT_CODE);
                finish();
                break;
            case R.id.add_picker_done:
                if(isStartFirst == Constants.TYPE_START){
                    storeChangedStartDate(Constants.TYPE_START);
                }
                else if(isStartFirst == Constants.TYPE_END){
                    storeChangedStartDate(Constants.TYPE_END);
                }
                intent.putExtra("startDate",dateStart);
                intent.putExtra("endDate",dateEnd);
                setResult(Constants.RESULT_CODE, intent);
                finish();
                break;
        }
    }

    void clearPicker(NumberPicker npMonth, NumberPicker npDate, NumberPicker npHour, NumberPicker npMinute, int month, int date, int hour, int minute){
        npMonth.setValue(month);
        npDate.setValue(date);
        npHour.setValue(hour);
        npMinute.setValue(minute);
    }

    ArrayList<String> splitDate(String date, String time){
        String month;
        String day;
        // 한자리
        if(date.charAt(1)=='월'){
            month = date.substring(0,1);
            // 한자리
            if(date.charAt(4)=='일'){
                day = date.substring(3,4);
            }
            //두자리
            else{
                day = date.substring(3,5);
            }
        }
        //두자리
        else{
            month = date.substring(0,2);
            // 한자리
            if(date.charAt(5)=='일'){
                day = date.substring(4,5);
            }
            //두자리
            else{
                day = date.substring(4,6);
            }
        }

        String hour = time.substring(0,2);
        String minute = time.substring(3,5);

        ArrayList<String> splitData = new ArrayList<>();
        splitData.add(month);
        splitData.add(day);
        splitData.add(hour);
        splitData.add(minute);

        return splitData;
    }

    void activateTab(int isStart){
        if(isStart == Constants.TYPE_START){
            startText.setTextColor(getResources().getColor(R.color.mainColor));
            startBack.setVisibility(View.VISIBLE);
            endText.setTextColor(getResources().getColor(R.color.black));
            endBack.setVisibility(View.INVISIBLE);
        }
        else if(isStart == Constants.TYPE_END){
            startText.setTextColor(getResources().getColor(R.color.black));
            startBack.setVisibility(View.INVISIBLE);
            endText.setTextColor(getResources().getColor(R.color.mainColor));
            endBack.setVisibility(View.VISIBLE);
        }
    }

    void storeChangedStartDate(int isStart){
        int month = npMonth.getValue();
        int day = npDay.getValue();
        int hour = npHour.getValue();
        int minute = npMinute.getValue();

        if(isStart == Constants.TYPE_START){
            dateStart.add(0, String.valueOf(month));
            dateStart.add(1,String.valueOf(day));
            dateStart.add(2,String.valueOf(hour));
            dateStart.add(3,String.valueOf(minute));
        }
        else if(isStart == Constants.TYPE_END){
            dateEnd.add(0, String.valueOf(month));
            dateEnd.add(1,String.valueOf(day));
            dateEnd.add(2,String.valueOf(hour));
            dateEnd.add(3,String.valueOf(minute));
        }
    }

}
