package com.example.chloechoi.test.activities.Setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.example.chloechoi.test.R;



public class SettingFragment extends Fragment
        implements  CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    RelativeLayout profilelayout;
    RelativeLayout themelayout;

    Switch alarmswitch;

    FragmentManager fm;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View settingfragment = inflater.inflate(R.layout.fragment_setting, container, false);

        fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();

        profilelayout = settingfragment.findViewById(R.id.setting_profile_layout);
        profilelayout.setOnClickListener(this);
        themelayout = settingfragment.findViewById(R.id.setting_theme_layout);
        themelayout.setOnClickListener(this);

        alarmswitch = settingfragment.findViewById(R.id.setting_alarm_switch);
        alarmswitch.setOnCheckedChangeListener(this);

        return settingfragment;

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //todo alarm on off 시 통신 필요
        if(isChecked == true){
            //alarm on
            Log.v("~~~", "alarm on");

        }else if(isChecked == false){
            //alarm off
            Log.v("~~~", "alarm off");
        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.setting_profile_layout:
                ((SettingActivity)getActivity()).changeHeaderTitle("학번 및 비밀번호");
                ((SettingActivity)getActivity()).replaceBodyFragment(new SettingProfileFragment());
                break;
            case R.id.setting_theme_layout:
                ((SettingActivity)getActivity()).changeHeaderTitle("테마");
                ((SettingActivity)getActivity()).replaceBodyFragment(new SettingThemeFragment());
                break;
        }

    }
    /*
    private RelativeLayout.OnClickListener LayoutClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.v("~~~", "log check 5 - onclicklistener ");

            switch(v.getId()) {
                case R.id.setting_theme_layout:
                    fragmentTransaction.replace(R.id.main_body, new SettingThemeFragment());
                    fragmentTransaction.commit();
                    break;
            }
        }
    };*/

}
