package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


        // TODO finishActivity()로 돌아왔을 때 설정된 값으로 다시 설정해줘야 하는데 어케 하징
//        setDate();


        // setOnClickListener
        startArea.setOnClickListener(this);
        endArea.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_start){
            intent = new Intent(getActivity(),TodoAddPickerActivity.class);
            intent.putExtra("isStart",Constants.TYPE_START);
            intent.putExtra("dates",getDate());
        }
        else if(v.getId() == R.id.add_end){
            intent = new Intent(getActivity(),TodoAddPickerActivity.class);
            intent.putExtra("isStart",Constants.TYPE_END);
            intent.putExtra("dates",getDate());
        }
        startActivity(intent);
    }


    void setDefaultDate(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        String dayKor = "";
        switch (cal.get(Calendar.DAY_OF_WEEK)){
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
        startDate.setText(month + "월 " + date + "일");
        startTime.setText(Constants.DEFAULT_START_TIME);
        endDate.setText(month + "월 " + date + "일");
        endTime.setText(Constants.DEFAULT_END_TIME);
    }


    // index 순서 : 시작날짜 시작시간 종료날짜 종료시간
    ArrayList<String> getDate(){
        ArrayList<String> dates = new ArrayList<>();
        dates.add(startDate.getText().toString());
        dates.add(startTime.getText().toString());
        dates.add(endDate.getText().toString());
        dates.add(endTime.getText().toString());

        return dates;
    }


    // 매개변수 arr로 할까?
    // data format : mm dd hh mm (int 두자리로)
    void setDate(int monthS, int dayS, int hourS, int minuteS, int monthE, int dayE, int hourE, int minuteE){
        startDate.setText(monthS + "월 " + dayS + "일");
        startTime.setText(hourS + ":" + minuteS);
        endDate.setText(monthE + "월 " + dayE + "일");
        endTime.setText(hourE + ":" + minuteE);
    }

}
