package com.example.chloechoi.test.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.interfaces.HomeworkViewHolder;

public class ToBeSummitedHWViewHolder extends RecyclerView.ViewHolder implements HomeworkViewHolder {
    public View vPriority;
    public TextView tvTitle;
    public TextView tvSubject;
    public TextView tvDeadLine;

    public ToBeSummitedHWViewHolder(View itemView) {
        super(itemView);
        vPriority = (View) itemView.findViewById(R.id.v_priority);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        tvSubject = (TextView) itemView.findViewById(R.id.tv_subject);
        tvDeadLine = (TextView) itemView.findViewById(R.id.tv_deadline);
    }

    @Override
    public TextView getHWTitle() { return tvTitle; }

    @Override
    public TextView getSubjectTitle() { return tvSubject; }

    @Override
    public View getPriority() { return vPriority; }

    @Override
    public TextView getDeadLine() { return tvDeadLine; }

    @Override
    public Button getScore() { return null; }

    @Override
    public TextView getIsSummited() { return null; }

    @Override
    public TextView getFeedback() { return null; }
}
