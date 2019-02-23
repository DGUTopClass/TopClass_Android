package com.example.chloechoi.test.activities.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chloechoi.test.R;

public class TestHeaderFragment extends Fragment {

    // 각 이벤트에 따라서 붙여줄 헤더를 지정해주는 변수
    public int header_num = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        // test용 임의 지정
        header_num = 2;

        switch (header_num){
            case 1:
                return inflater.inflate(R.layout.header_main, container, false);
            case 2:
                return inflater.inflate(R.layout.header_setting_notice, container, false);
            case 3:
                return inflater.inflate(R.layout.header_todolist_add, container, false);
            default:
                return inflater.inflate(R.layout.header_setting_notice, container, false);
        }
    }
}
