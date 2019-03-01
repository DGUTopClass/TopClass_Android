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

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        SettingHeaderFragment headerfragment = new SettingHeaderFragment();
        SettingFragment bodyfragment = new SettingFragment();
        SettingThemeFragment themefragment = new SettingThemeFragment();

        fragmentTransaction.add(R.id.setting_header, headerfragment);
        fragmentTransaction.add(R.id.setting_body, themefragment);

        fragmentTransaction.commit();

        /*
        Log.v("~~~","start fragment check");
        if(isSafeFragment(headerfragment)){
            Log.v("~~~","header fragment destroyed check");
        }
        if(isSafeFragment(bodyfragment)){
            Log.v("~~~","body fragment destroyed check");
        }

        Log.v("~~~","log check 6"); */

        super.onCreate(savedInstanceState);
    }

    public static boolean isSafeFragment( Fragment frag )
    {
        return !(frag.isRemoving() || frag.getActivity() == null || frag.isDetached() || !frag.isAdded() || frag.getView() == null );
    }
}
