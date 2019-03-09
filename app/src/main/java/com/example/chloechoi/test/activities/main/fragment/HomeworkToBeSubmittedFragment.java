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

public class HomeworkToBeSubmittedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private HomeworkAdapter mAdapter;
    private ArrayList<Homework> item = new ArrayList<Homework>();

    public HomeworkToBeSubmittedFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){


        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_to_be_summited_hw, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_to_be_submmited_hw);
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new HomeworkAdapter(item, Constants.TYPE_TO_BE_SUMMITED_HW);
        mRecyclerView.setAdapter(mAdapter);

        initDataset();

        return rootView;
    }

    private void initDataset(){
        if(item.size() > 3)
            item.clear();

        for (int i = 0; i < 4; i++) {
            item.add(new Homework().getToBeSummitedDummy());
        }
        for(int i = 0; i < 4; i++){
            item.add(new Homework().getToBeSummitedDummy2());
        }
    }
}
