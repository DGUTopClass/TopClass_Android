package com.example.chloechoi.test.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.interfaces.HomeworkViewHolder;

public class EndHomeworkViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public TextView tvSubject;
    public TextView tvIsSummited;
    public Button btnScore;
    public TextView tvFeedback;

    public LinearLayout lyFeedback;

    public EndHomeworkViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.item_end_hw_tv_title);
        tvSubject = (TextView) itemView.findViewById(R.id.item_end_hw_tv_subject);
        tvIsSummited = (TextView) itemView.findViewById(R.id.item_end_hw_tv_is_summited);
        btnScore = (Button) itemView.findViewById(R.id.item_end_hw_bt_score);
        tvFeedback = (TextView) itemView.findViewById(R.id.item_end_hw_tv_feedback);

        lyFeedback = (LinearLayout) itemView.findViewById(R.id.item_end_hw_ll_feedback);
    }
}
