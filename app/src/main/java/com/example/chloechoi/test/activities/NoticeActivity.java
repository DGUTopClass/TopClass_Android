package com.example.chloechoi.test.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.adapter.NoticeAdapter;
import com.example.chloechoi.test.model.Notice;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    TextView mNoticeHeader;

    @Override
    protected void onCreate(Bundle savedInsatanceState){
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_notice);

        mNoticeHeader = findViewById(R.id.tv_setting_title);
        mNoticeHeader.setText("공지사항");

        mRecyclerView = findViewById(R.id.rv_notice_body);
        mRecyclerView.setHasFixedSize(true);

        ArrayList<Notice> dataList = new ArrayList<>();
        for(int i = 0; i <3; i++){
            dataList.add(new Notice().getDummy());
        }

        NoticeAdapter mNoticeAdapter = new NoticeAdapter(dataList);

        mRecyclerView.setAdapter(mNoticeAdapter);
    }
}
