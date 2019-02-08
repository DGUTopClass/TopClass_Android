package com.example.chloechoi.test.activities.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.utility.Constants;

import java.util.Calendar;

public class TodoAddPickerActivity extends AppCompatActivity {

    // TODO finishActivity()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picker);


        // initialize number picker
        // TODO unselected text color 수정이 안돼....... 좀 더 찾아보고 안되는 거면 라이브러리 써야쥐......라이브러리는 많던뒈...흐아...
        NumberPicker npMonth = findViewById(R.id.add_picker_month);
        npMonth.setMinValue(1);
        npMonth.setMaxValue(12);
//        int month = npMonth.getValue();

        Calendar cal = Calendar.getInstance();
        NumberPicker npDay = findViewById(R.id.add_picker_day);
        npDay.setMinValue(1);
        npDay.setMaxValue(cal.getActualMaximum(Calendar.DATE));

        NumberPicker npHour = findViewById(R.id.add_picker_hour);
        npHour.setMinValue(0);
        npHour.setMaxValue(23);

        NumberPicker npMinute = findViewById(R.id.add_picker_minute);
        npMinute.setMinValue(0);
        npMinute.setMaxValue(59);


        // TODO LIST
        // 시작 및 종료 시간 받아오기
        // 받아온 값으로 clear picker 수정 -> 여기에다가 탭 정보도 넣기
        // 취소 누르면 finishActivity 할 때 값 안 넘겨줌
        // 확인 누르면 finishActivity 할 때 값 넘겨줌

        //git push from local/master to origin/dev_goun testing

        //isStart 임의 지정
        clearPicker(npMonth,npDay,npHour,npMinute,0);
    }

    // TODO 현재 날짜로 할 게 아니고 받아온 값으로 해야 해 !
    void clearPicker(NumberPicker npMonth, NumberPicker npDate, NumberPicker npHour, NumberPicker npMinute, int isStart){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);

        npMonth.setValue(month);
        npDate.setValue(date);

        if(isStart == Constants.TYPE_START){
            npHour.setValue(0);
            npMinute.setValue(0);
        }
        else if(isStart == Constants.TYPE_END){
            npHour.setValue(23);
            npHour.setValue(59);
        }
    }
}
