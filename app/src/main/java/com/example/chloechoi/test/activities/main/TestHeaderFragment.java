package com.example.chloechoi.test.activities.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chloechoi.test.R;

public class TestHeaderFragment extends Fragment {

    // 각 이벤트에 따라서 붙여줄 헤더를 지정해주는 변수
    public int header_num = 0;

    // main
    private TextView tvLogo;
    private ImageView ivAddHW;
    private TextView tvSubject;
    private ImageView ivMenu;


    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView;

        header_num = getArguments().getInt("header_num");
        switch (header_num){
            case 1: // 제출 예정
            case 2: // 지난 과제
                rootView = (ViewGroup) inflater.inflate(R.layout.header_main, container, false);
                mainHeader(rootView);
                return rootView;

            case 3:
                return inflater.inflate(R.layout.header_todolist_add, container, false);
            default:
                return inflater.inflate(R.layout.header_setting_notice, container, false);
        }
    }

    public void mainHeader(ViewGroup rootView){
        tvLogo = (TextView) rootView.findViewById(R.id.tv_main_logo);
        tvLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 메인화면으로
            }
        });

        ivMenu = (ImageView) rootView.findViewById(R.id.iv_main_more);
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // navigation drawer
            }
        });

        ivAddHW = (ImageView) rootView.findViewById(R.id.iv_main_add_hw);
        ivAddHW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TodoAdd 화면으로 전환
            }

        });

        tvSubject = (TextView) rootView.findViewById(R.id.tv_main_subject);
        tvSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 과목별로,,
            }
        });
        if(header_num == 1){
            ivAddHW.setVisibility(View.VISIBLE);
            tvSubject.setVisibility(View.INVISIBLE);
        } else if(header_num == 2){
            ivAddHW.setVisibility(View.INVISIBLE);
            tvSubject.setVisibility(View.VISIBLE);
        }
    }
}
