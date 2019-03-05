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
import android.widget.Toast;
import com.example.chloechoi.test.R;



public class SettingFragment extends Fragment implements  CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    RelativeLayout profilelayout;
    RelativeLayout themelayout;

    Switch alarmswitch;

    FragmentManager fm;
    FragmentTransaction fragmentTransaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        Log.v("~~~", "log check 1 ");

        // Inflate the layout for this fragment
        View settingfragment = inflater.inflate(R.layout.fragment_setting, container, false);
        /*View settingactivity = inflater.inflate(R.layout.activity_setting, container, false);

        fragment_body = settingactivity.findViewById(R.id.main_body);*/

        fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();

        profilelayout = settingfragment.findViewById(R.id.setting_profile_layout);
        Log.v("~~~", "log check 2 ");
        themelayout = settingfragment.findViewById(R.id.setting_theme_layout);
        Log.v("~~~", "log check 3 ");


        //themelayout.setOnClickListener(LayoutClickListener);
        themelayout.setOnClickListener(this);

        Log.v("~~~", "log check 4 ");


        alarmswitch = settingfragment.findViewById(R.id.setting_alarm_switch);
        alarmswitch.setOnCheckedChangeListener(this);



        return settingfragment;

    }


    //--------------------알람 on off----------------------
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

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
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
