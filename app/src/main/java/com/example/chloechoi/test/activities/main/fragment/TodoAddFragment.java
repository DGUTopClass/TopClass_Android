package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.TodoAddPickerActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TodoAddFragment extends Fragment {

    // TODO 아니 배경 투명하게 어찌 했더라....할애 찾아보기... 했던 것도 못하면 어떠케 바보야....
    int eventIdx;
    Intent intent;
    String startTimeContent;
    String endTimeContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todolist_add, container, false);

        TextView startTime = view.findViewById(R.id.tv_add_start);
        TextView endTime = view.findViewById(R.id.tv_add_end);

        // 시작, 종료 날짜 기본 값 오늘 날짜로 설정하기
        startTimeContent = setDefaultDate()+ "       00:00";
        endTimeContent = setDefaultDate()+ "       23:59";

        startTime.setText(startTimeContent);
        endTime.setText(endTimeContent);

        TextView.OnClickListener onClickListener = new TextView.OnClickListener(){
            @Override
            public void onClick(View timeView){
                switch (timeView.getId()){
                    case R.id.tv_add_start :
                        eventIdx = 0;
                        break;
                    case R.id.tv_add_end:
                        eventIdx = 1;
                        break;
                }
                if(eventIdx==0){
                    intent = new Intent(getActivity(),TodoAddPickerActivity.class);
                    // TODO 시작이라고,getText intent에 같이 보내기
                }
                else if(eventIdx==1){
                    intent = new Intent(getActivity(),TodoAddPickerActivity.class);
                    // TODO 종료라고,getText intent에 같이 보내기
                }
                startActivity(intent);
            }
        };

        startTime.setOnClickListener(onClickListener);
        endTime.setOnClickListener(onClickListener);
        return view;
    }

    String setDefaultDate(){
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
        String format = month + "월 " + date + "일 (" + dayKor + ")";
        return format;
    }
}
