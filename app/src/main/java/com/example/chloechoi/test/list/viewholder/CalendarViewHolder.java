package com.example.chloechoi.test.list.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.chloechoi.test.R;

import java.util.ArrayList;

public class CalendarViewHolder extends RecyclerView.ViewHolder{
    ArrayList<View> liDays;

    public CalendarViewHolder(@NonNull View itemView) {
        super(itemView);

        liDays = new ArrayList<View>();
        liDays.add((View) itemView.findViewById(R.id.li_day0));
        liDays.add((View) itemView.findViewById(R.id.li_day1));
        liDays.add((View) itemView.findViewById(R.id.li_day2));
        liDays.add((View) itemView.findViewById(R.id.li_day3));
        liDays.add((View) itemView.findViewById(R.id.li_day4));
        liDays.add((View) itemView.findViewById(R.id.li_day5));
        liDays.add((View) itemView.findViewById(R.id.li_day6));
    }
}
