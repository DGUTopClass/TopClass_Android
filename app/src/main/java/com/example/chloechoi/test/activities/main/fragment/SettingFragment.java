package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.TestHeaderFragment;


public class SettingFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    RelativeLayout profilelayout;
    RelativeLayout themelayout;

    Switch alarmswitch;

    Intent profileIntent;
    Intent themeIntent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        profilelayout = view.findViewById(R.id.setting_profile_layout);
        profilelayout.setOnClickListener(this);

        themelayout = view.findViewById(R.id.setting_theme_layout);
        themelayout.setOnClickListener(this);

        alarmswitch = view.findViewById(R.id.setting_alarm_switch);
        alarmswitch.setOnCheckedChangeListener(this);

        profileIntent = new Intent(this.getActivity(), SettingProfileFragment.class);
        themeIntent = new Intent(this.getActivity(), SettingThemeFragment.class);

        return view;

    }

    @Override
    public void onClick(View v) {
        if(v == profilelayout){

        }else if(v==themelayout){

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
