package com.example.chloechoi.test.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.TestHeaderFragment;
import com.example.chloechoi.test.list.adapter.PagerAdapter;
import com.pm10.library.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private TestHeaderFragment mHeader;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeader = new TestHeaderFragment();
        Bundle bundle = new Bundle(1);
        bundle.putInt("header_num", 1);
        mHeader.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_header, mHeader);
        ft.commit();

        mViewPager = (ViewPager) findViewById(R.id.vp_main_page);
        mPagerAdapter = new PagerAdapter(fm);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);

        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.circle_indicator);
        circleIndicator.setupWithViewPager(mViewPager);

    }
}