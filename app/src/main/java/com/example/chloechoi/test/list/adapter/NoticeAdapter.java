package com.example.chloechoi.test.list.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.viewholder.NoticeViewHolder;
import com.example.chloechoi.test.model.NoticeData;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;

import static android.view.View.GONE;

public class NoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<NoticeData> datalist;

    Context mContext;

    public NoticeAdapter(ArrayList<NoticeData> itemList){
        datalist = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.li_notice, viewGroup, false);
        mContext = viewGroup.getContext();
        return new NoticeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i){
        final NoticeViewHolder mViewHolder = (NoticeViewHolder) holder;

        mViewHolder.tvSubject.setText(datalist.get(i).subject);
        mViewHolder.tvTitle.setText(datalist.get(i).title);
        mViewHolder.tvDate.setText(datalist.get(i).date);
        mViewHolder.tvContents.setText(datalist.get(i).contents);

        mViewHolder.btnArrow.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(mViewHolder.lyContentsBox.getVisibility() == GONE){
                            mViewHolder.lyContentsBox.setVisibility(View.VISIBLE);
                            mViewHolder.btnArrow.setBackgroundColor(mContext.getResources().getColor(R.color.btnSelected));
                        }
                        else{
                            mViewHolder.lyContentsBox.setVisibility(View.GONE);
                            mViewHolder.btnArrow.setBackgroundColor(mContext.getResources().getColor(R.color.btnDefault));
                        }
                    }
                });


    }

    public int getItemCount(){
        return datalist.size();
    }
}
