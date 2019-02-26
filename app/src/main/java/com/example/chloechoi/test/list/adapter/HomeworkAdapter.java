package com.example.chloechoi.test.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chloechoi.test.interfaces.HomeworkViewHolder;
import com.example.chloechoi.test.list.viewholder.ToBeSummitedHWViewHolder;
import com.example.chloechoi.test.model.Homework;
import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.viewholder.SummitedHWViewHolder;
import com.example.chloechoi.test.utility.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.view.View.GONE;

public class HomeworkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Homework> dataList;
    Context mContext;
    Constants constants = new Constants();

    int[] layouts = {R.layout.li_to_be_summited_hw, R.layout.li_summited_hw};

    int type;
    public HomeworkAdapter(ArrayList<Homework> itemList, int type) {
        dataList = itemList;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layout = layouts[type];
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        mContext = viewGroup.getContext();
        RecyclerView.ViewHolder holder = initViewHolder(v);
        return holder;
    }

    RecyclerView.ViewHolder initViewHolder(View v){
        if(type == 0) return new ToBeSummitedHWViewHolder(v);
        else return new SummitedHWViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int i) {
        if(type == constants.TYPE_TO_BE_SUMMITED_HW){
            ToBeSummitedHWViewHolder castedHolder = (ToBeSummitedHWViewHolder) holder;

            castedHolder.vPriority.setBackgroundColor(setPriority(dataList.get(i).getDeadline()));
            castedHolder.tvTitle.setText(dataList.get(i).getTitle());
            castedHolder.tvSubject.setText(dataList.get(i).getSubject());
            castedHolder.tvDeadLine.setText(dataList.get(i).getDeadline());
        }
        else{
            final SummitedHWViewHolder castedHolder = (SummitedHWViewHolder) holder;

            castedHolder.tvTitle.setText(dataList.get(i).getTitle());
            castedHolder.tvSubject.setText(dataList.get(i).getSubject());
            if(dataList.get(i).getHanded()) castedHolder.tvIsSummited.setVisibility(View.INVISIBLE);
            castedHolder.btnScore.setText(dataList.get(i).toTvScore());

            castedHolder.btnScore.setOnClickListener(
                    new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            if(castedHolder.lyFeedback.getVisibility() == GONE){
                                castedHolder.lyFeedback.setVisibility(View.VISIBLE);
                                castedHolder.btnScore.setBackgroundColor(mContext.getResources().getColor(R.color.btnSelected));
                            }
                            else{
                                castedHolder.lyFeedback.setVisibility(View.GONE);
                                castedHolder.btnScore.setBackgroundColor(mContext.getResources().getColor(R.color.btnDefault));
                            }
                        }
                    }
            );

            castedHolder.tvFeedback.setText(dataList.get(i).getFeedback());
        }

    }

    @Override
    public int getItemCount() {return dataList.size();}

    public int setPriority(String date) {

        int priorityColor = 0;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = format.format(Calendar.getInstance().getTime());

        try {

            Date todayDate = format.parse(today);
            Date hwDate = format.parse(date);

            long calDate = todayDate.getTime() - hwDate.getTime();
            long calDateDays = calDate / (24*60*60*1000);

            calDateDays = Math.abs(calDateDays);

            if(calDateDays >= 0 && calDateDays <3.0){
                priorityColor = mContext.getResources().getColor(R.color.hw_priority_1);
            } else if(calDateDays >= 3.0 && calDateDays < 6.0){
                priorityColor = mContext.getResources().getColor(R.color.hw_priority_2);
            } else {
                priorityColor = mContext.getResources().getColor(R.color.hw_priority_3);
            }

        } catch (ParseException e){
            priorityColor = mContext.getResources().getColor(R.color.black);
            Log.e("exception","parse exception at setPriority()");
        }

        return priorityColor;
    }
}
