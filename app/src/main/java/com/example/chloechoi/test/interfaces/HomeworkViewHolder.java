package com.example.chloechoi.test.interfaces;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public interface HomeworkViewHolder {
    TextView getHWTitle();
    TextView getSubjectTitle();

    View getPriority();
    TextView getDeadLine();

    Button getScore();
    TextView getIsSummited();
    TextView getFeedback();
}
