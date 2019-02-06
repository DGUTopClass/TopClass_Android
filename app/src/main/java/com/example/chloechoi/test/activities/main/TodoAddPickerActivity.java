package com.example.chloechoi.test.activities.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;

import com.example.chloechoi.test.R;

public class TodoAddPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picker);

        //unfocusable text color 수정이 안돼....... 좀 더 찾아보고 안되는 거면 라이브러리 써야쥐......라이브러리는 많던뒈...흐아...
        NumberPicker npMonth = findViewById(R.id.add_picker_month);
        npMonth.setMinValue(1);
        npMonth.setMaxValue(12);
//        int month = npMonth.getValue();

        //if문으로 맥스 다르게 해줄 수는 있는데 뭔가 2월은 4년에 한 번 다른데
        //이거를 어케 처리할 지 아마도 calendar 객체 이용하면 가능할 듯?
        NumberPicker npDay = findViewById(R.id.add_picker_day);
        npDay.setMinValue(1);
        npDay.setMaxValue(31);

        NumberPicker npHour = findViewById(R.id.add_picker_hour);
        npHour.setMinValue(0);
        npHour.setMaxValue(23);

        NumberPicker npMinute = findViewById(R.id.add_picker_minute);
        npMinute.setMinValue(0);
        npMinute.setMaxValue(59);


    }

}
