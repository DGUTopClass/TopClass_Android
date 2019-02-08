package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.chloechoi.test.R;



public class SettingFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Button backbtn;


    RelativeLayout profilelayout;
    RelativeLayout themelayout;

    Switch alarmswitch;

    Intent profileIntent = new Intent(this.getActivity(), SettingProfileFragment.class);
    Intent themeIntent = new Intent(this.getActivity(), SettingThemeFragment.class);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        initialUI();

        return inflater.inflate(R.layout.fragment_setting, container, false);



    }
    void initialUI(){

        backbtn.findViewById(R.id.setting_back_btn);
        backbtn.setOnClickListener(this);

        profilelayout.findViewById(R.id.setting_profile_layout);
        profilelayout.setOnClickListener(this);

        themelayout.findViewById(R.id.setting_theme_layout);
        themelayout.setOnClickListener(this);

        alarmswitch.findViewById(R.id.setting_alarm_switch);
        alarmswitch.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == profilelayout){
            startActivity(profileIntent);
        }else if(v==themelayout){
            startActivity(themeIntent);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked == true){
            //alarm on
            Toast.makeText(this.getContext(),"alarm on",Toast.LENGTH_SHORT).show();

        }else if(isChecked == false){
            //alarm off
            Toast.makeText(this.getContext(),"alarm off",Toast.LENGTH_SHORT).show();
        }
    }
}
