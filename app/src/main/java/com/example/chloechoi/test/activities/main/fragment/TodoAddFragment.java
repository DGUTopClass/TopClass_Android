package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.TodoAddPickerActivity;

public class TodoAddFragment extends Fragment {

    int eventIdx;
    Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todolist_add, container, false);

        TextView startTime = view.findViewById(R.id.tv_add_start);
        final TextView endTime = view.findViewById(R.id.tv_add_end);

        TextView.OnClickListener onClickListener = new TextView.OnClickListener(){
            @Override
            public void onClick(View timeView){
                switch (timeView.getId()){
                    case R.id.tv_add_start :
                        eventIdx = 0;
                        break;
                    case R.id.tv_add_end:
                        eventIdx = 0;
                        break;
                }
                if(eventIdx==0){
                    intent = new Intent(getActivity(),TodoAddPickerActivity.class);
                }
                startActivity(intent);
            }
        };

        startTime.setOnClickListener(onClickListener);
        endTime.setOnClickListener(onClickListener);
        return view;
    }
}
