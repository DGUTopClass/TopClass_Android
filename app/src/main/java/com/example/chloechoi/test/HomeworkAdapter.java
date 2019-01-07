package com.example.chloechoi.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.view.View.GONE;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkViewHolder> {
    private ArrayList<HomeworkData> dataList;
    Context mContext;
    public HomeworkAdapter(ArrayList<HomeworkData> itemList) {
        dataList = itemList;
    }

    @NonNull
    @Override
    public HomeworkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.li_homework, viewGroup, false);
        mContext = viewGroup.getContext();
        HomeworkViewHolder holder = new HomeworkViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeworkViewHolder holder, int i) {
        holder.tvTitle.setText(dataList.get(i).title);
        holder.tvSubject.setText(dataList.get(i).subject);
//        holder.tvIsHanded.setText(dataList.get(i).isHanded);
        if(dataList.get(i).isHanded) holder.tvIsHanded.setVisibility(View.INVISIBLE);
        holder.btnScore.setText(dataList.get(i).toTvScore());

        holder.btnScore.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(holder.lyFeedback.getVisibility() == GONE){
                            holder.lyFeedback.setVisibility(View.VISIBLE);
                            holder.btnScore.setBackgroundColor(mContext.getResources().getColor(R.color.btnSelected));
                        }
                        else{
                            holder.lyFeedback.setVisibility(View.GONE);
                            holder.btnScore.setBackgroundColor(mContext.getResources().getColor(R.color.btnDefault));
                        }
                    }
                }
        );

        holder.tvFeedback.setText(dataList.get(i).feedback);
    }

    @Override
    public int getItemCount() {return dataList.size();}
}
