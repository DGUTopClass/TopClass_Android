package com.example.chloechoi.test.activities.Setting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chloechoi.test.R;

public class SettingHeaderFragment extends Fragment implements View.OnClickListener {

    ImageView backBtn;
    TextView headerTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.header_setting_notice, container, false);

        backBtn = view.findViewById(R.id.setting_back_btn);
        headerTitle = view.findViewById(R.id.setting_header_title);
        headerTitle.setText("설정");

        backBtn.setOnClickListener(this);

        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        //todo 백버튼 구현
        if(v == backBtn){

        }
    }
}
