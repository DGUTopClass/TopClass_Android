package com.example.chloechoi.test.list.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.viewholder.NoticeViewHolder;
import com.example.chloechoi.test.model.Notice;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;

import static android.view.View.GONE;

public class NoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Notice> datalist;

    Context mContext;

    public NoticeAdapter(ArrayList<Notice> itemList){
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

        mViewHolder.tvSubject.setText(datalist.get(i).getSubject());
        mViewHolder.tvTitle.setText(datalist.get(i).getTitle());
        mViewHolder.tvDate.setText(datalist.get(i).getDate());
        mViewHolder.tvContents.setText(datalist.get(i).getContents());

        mViewHolder.rlGroup.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        openContent(mViewHolder);
                    }
                });

        mViewHolder.btnArrow.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        openContent(mViewHolder);
                    }
                });


    }

    public int getItemCount(){
        return datalist.size();
    }

    public void openContent(NoticeViewHolder mViewHolder){

        if(mViewHolder.lyContentsBox.getVisibility() == GONE){
            mViewHolder.lyContentsBox.setVisibility(View.VISIBLE);
            mViewHolder.btnArrow.setBackground(mContext.getResources().getDrawable(R.drawable.notice_down_arrow_btn));
        }
        else{
            mViewHolder.lyContentsBox.setVisibility(View.GONE);
            mViewHolder.btnArrow.setBackground(mContext.getResources().getDrawable(R.drawable.notice_right_arrow_btn));
        }
    }

}
