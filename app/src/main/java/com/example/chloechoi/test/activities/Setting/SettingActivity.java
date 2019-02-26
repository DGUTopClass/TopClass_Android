package com.example.chloechoi.test.activities.Setting;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.fragment.TodoAddFragment;


public class SettingActivity extends Activity {

    RelativeLayout profilelayout;
    RelativeLayout themelayout;

    Switch alarmswitch;

    Intent profileIntent;
    Intent themeIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        
        fragmentTransaction.commit();

        super.onCreate(savedInstanceState);
    }

   /* @Override
    public void onClick(View v) {
        if(v == profilelayout){  //학번 및 비밀번호 수정 시  -> 프레그먼트 및 헤더 교체


        }else if(v==themelayout){  //테마 수정 시 -> 프레그먼트 및 헤더 교체


        }
    }
   */
    /*@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            Log.v("sylee","in oncreateview");
            // Inflate the layout for this fragment

            View view = inflater.inflate(R.layout.fragment_setting, container, false);

            fm = getFragmentManager();
            fragmentTransaction = fm.beginTransaction();


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
    */


/*
    @Override  //알람 on off 스위치 용 메서드
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked == true){
            //alarm on
            Toast.makeText(this.getContext(),"alarm on",Toast.LENGTH_SHORT).show();

        }else if(isChecked == false){
            //alarm off
            Toast.makeText(this.getContext(),"alarm off",Toast.LENGTH_SHORT).show();
        }
    }*/
}
