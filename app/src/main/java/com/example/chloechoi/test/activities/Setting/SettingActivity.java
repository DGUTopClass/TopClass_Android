package com.example.chloechoi.test.activities.Setting;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.chloechoi.test.R;


public class SettingActivity extends AppCompatActivity {

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

/*        fm2 = getSupportFragmentManager();
        fragmentTransaction2 = fm2.beginTransaction();*/

        Log.v("~~~","replace body fragment");
        Log.v("~~~", newfragment.toString());
//        fragmentTransaction.add(R.id.setting_body, newfragment);

        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.setting_body, newfragment);
        fragmentTransaction.commit();



    }

}
