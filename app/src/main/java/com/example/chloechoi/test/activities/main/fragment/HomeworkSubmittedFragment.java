package com.example.chloechoi.test.activities.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.adapter.HomeworkAdapter;
import com.example.chloechoi.test.model.Homework;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;

public class HomeworkSubmittedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private HomeworkAdapter mAdapter;
    private ArrayList<Homework> item = new ArrayList<Homework>();

    public HomeworkSubmittedFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_summited_hw, container, false);

        initDataset();

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_summited_hw);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new HomeworkAdapter(item, Constants.TYPE_SUMMITED_HW);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void initDataset(){

        if(item.size() > 4)
            item.clear();

        for (int i = 0; i < 5; i++) {
            item.add(new Homework().getSummitedDummy());
        }
    }
}
