package com.example.chloechoi.test.activities.Setting;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.chloechoi.test.R;


public class SettingActivity extends AppCompatActivity  {

    FragmentManager fm;
    FragmentTransaction fragmentTransaction;

    FragmentManager fm2;
    FragmentTransaction fragmentTransaction2;

    SettingHeaderFragment headerfragment = new SettingHeaderFragment();
    SettingFragment bodyfragment = new SettingFragment();


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        fm = getSupportFragmentManager();
        fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.add(R.id.setting_header, headerfragment);

        fragmentTransaction.add(R.id.setting_body, bodyfragment);
        fragmentTransaction.addToBackStack("basefragment");

        fragmentTransaction.commit();


    }

    public void changeHeaderTitle (String newtitle){

        Log.v("~~~","change header text");

        headerfragment.headerTitle.setText(newtitle);
    }

    public void replaceBodyFragment(Fragment newfragment){


        Log.v("~~~","replace body fragment");
        Log.v("~~~", newfragment.toString());

        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.setting_body, newfragment);
        fragmentTransaction.commit();



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
/*
    @Override
    public void onClick(View v) {
        if(v == headerfragment.backBtn){
            Log.v("~~~","액티비티에서 백버튼 처리");
            onBackPressed();
        }
    }*/
}
