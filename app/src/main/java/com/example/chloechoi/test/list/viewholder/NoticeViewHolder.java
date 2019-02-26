package com.example.chloechoi.test.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;

public class NoticeViewHolder extends RecyclerView.ViewHolder {

    public Button btnArrow;
    public TextView tvSubject;
    public TextView tvTitle;
    public TextView tvDate;
    public TextView tvContents;

    public LinearLayout lyContentsBox;
    public RelativeLayout rlGroup;

    public TextView tvNoticeTitle;

    public NoticeViewHolder(View itemView){
        super(itemView);

        btnArrow = (Button) itemView.findViewById(R.id.btn_arrow);
        tvSubject = (TextView) itemView.findViewById(R.id.tv_subject);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        tvContents = (TextView) itemView.findViewById(R.id.tv_contents);

        lyContentsBox = (LinearLayout) itemView.findViewById(R.id.ly_contents_box);
        rlGroup = (RelativeLayout) itemView.findViewById(R.id.rl_group);


    }

}
