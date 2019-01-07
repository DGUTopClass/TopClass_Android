package com.example.chloechoi.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    HomeworkAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_homework);

        ArrayList<HomeworkData> item = new ArrayList<HomeworkData>();
        for(int i=0; i<5; i++){
            item.add(new HomeworkData().getDummy());
            if(i == 3) item.get(i).isHanded = true;

        }

        mAdapter = new HomeworkAdapter(item);
        mRecyclerView.setAdapter(mAdapter);
    }
}