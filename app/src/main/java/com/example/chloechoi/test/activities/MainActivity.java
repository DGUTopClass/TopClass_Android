package com.example.chloechoi.test.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.adapter.HomeworkAdapter;
import com.example.chloechoi.test.model.HomeworkData;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    HomeworkAdapter mAdapter;

    Constants constants =  new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_homework);

        ArrayList<HomeworkData> item = new ArrayList<HomeworkData>();
        for(int i=0; i<5; i++){
            item.add(new HomeworkData().getSummitedDummy());
            if(i == 3) item.get(i).isHanded = true;

        }

        mAdapter = new HomeworkAdapter(item, Constants.TYPE_SUMMITED_HW);
        mRecyclerView.setAdapter(mAdapter);
    }
}