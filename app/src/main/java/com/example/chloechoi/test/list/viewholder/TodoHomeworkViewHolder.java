package com.example.chloechoi.test.list.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.interfaces.HomeworkViewHolder;

public class TodoHomeworkViewHolder extends RecyclerView.ViewHolder {
    public View vPriority;
    public TextView tvTitle;
    public TextView tvSubject;
    public TextView tvDeadLine;

    public TodoHomeworkViewHolder(View itemView) {
        super(itemView);
        vPriority = (View) itemView.findViewById(R.id.item_todo_hw_v_priority);
        tvTitle = (TextView) itemView.findViewById(R.id.item_todo_hw_tv_title);
        tvSubject = (TextView) itemView.findViewById(R.id.item_todo_hw_tv_subject);
        tvDeadLine = (TextView) itemView.findViewById(R.id.item_todo_hw_tv_deadline);
    }
}
