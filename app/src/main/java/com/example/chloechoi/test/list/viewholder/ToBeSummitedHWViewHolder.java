package com.example.chloechoi.test.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.interfaces.HomeworkViewHolder;

public class ToBeSummitedHWViewHolder extends RecyclerView.ViewHolder {
    public View vPriority;
    public TextView tvTitle;
    public TextView tvSubject;
    public TextView tvDeadLine;

    public LinearLayout lyToDoGroup;

    public ToBeSummitedHWViewHolder(View itemView) {
        super(itemView);
        vPriority = (View) itemView.findViewById(R.id.v_priority);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvSubject = (TextView) itemView.findViewById(R.id.tv_subject);
        tvDeadLine = (TextView) itemView.findViewById(R.id.tv_deadline);
        lyToDoGroup = (LinearLayout) itemView.findViewById(R.id.ly_to_do_hw_group);
    }
}
