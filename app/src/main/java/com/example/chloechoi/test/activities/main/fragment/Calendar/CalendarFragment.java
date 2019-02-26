package com.example.chloechoi.test.activities.main.fragment.Calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.interfaces.OnItemClick;
import com.example.chloechoi.test.model.Calendar.Day;
import com.example.chloechoi.test.model.Calendar.RawSchedule;
import com.example.chloechoi.test.model.Calendar.Schedule;
import com.example.chloechoi.test.model.Calendar.Week;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarFragment extends Fragment implements OnItemClick {

    private ArrayList<RawSchedule> rawData;
    private ArrayList<Day> processedData;
    private ArrayList<Week> processedWeekData;

    private TextView tvMonth;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar, container, false);

        tvMonth = (TextView) rootView.findViewById(R.id.tv_month);

        return rootView;
    }

    void initialData(){
        SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);

        rawData = new ArrayList<RawSchedule>();
        rawData.add(new RawSchedule("abc", "12주차 보고서", "2019-02-11", "12:00", "2019-02-14", "17:00"));
        rawData.add(new RawSchedule("def", "화학 보고서 작성", "2019-02-11", "12:00", "2019-02-14", "17:00"));
        rawData.add(new RawSchedule("abc", "11주차 보고", "2019-02-04", "12:00", "2019-02-07", "17:00"));

        convertData(curYearFormat, curMonthFormat);
        makeWeekData();

    }

    void convertData(SimpleDateFormat yearFormat, SimpleDateFormat monthFormat){
        Calendar mCal = Calendar.getInstance();

        int year = Integer.parseInt(yearFormat.format(new Date()));
        int month = Integer.parseInt(monthFormat.format(new Date()));

        tvMonth.setText(Integer.toString(month)+"월");

        makeDayList(mCal, year, month);

        for(RawSchedule rawSchedule : rawData){
            String[] splitedStartDate = rawSchedule.getStartDate().split("-");
            String[] splitedFinishDate = rawSchedule.getFinishDate().split("-");

            int dateIdx = findStartDateIdx(Integer.parseInt(splitedStartDate[2]));
            int duration = Integer.parseInt(splitedFinishDate[2]) - Integer.parseInt(splitedStartDate[2]) +1;

            for(int i = dateIdx; i< dateIdx+duration; i++){
                Schedule newSchedule = new Schedule(rawSchedule.getId(), rawSchedule.getTitle());
                // 우선순위 설정?
                processedData.get(i).setSchedule(newSchedule);
            }
        }
    }

    void makeDayList(Calendar mCal, int year, int month){
        // TODO
        mCal.set(year, month, 1);

        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);
        for(int i=1; i<dayNum; i++) processedData.add(new Day(-1));

        mCal.set(Calendar.MONTH, month-1);
        for(int i=0; i<mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++)
            processedData.add(new Day(i+1));
    }

    int findStartDateIdx(int date){
        int idx = 0;

        for(Day day : processedData){
            if(day.getDay() == date) return idx;
            else idx++;
        }

        return -1;
    }

    void makeWeekData(){
        for(int i=0; i<processedData.size()-1; i++){
            if(i%7 == 0) processedWeekData.add(new Week());

            processedWeekData.get(processedWeekData.size()-1).setDay(processedData.get(i));
        }
    }

    @Override
    public void onItemClick(RecyclerView.Adapter<RecyclerView.ViewHolder> root, int info) {

    }
}
