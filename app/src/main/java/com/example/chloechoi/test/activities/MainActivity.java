package com.example.chloechoi.test.activities;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.list.adapter.PagerAdapter;
import com.pm10.library.CircleIndicator;
//import com.pm10.library.CircleIndicator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.act_main_vp);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(0);

        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.act_main_ci);
        circleIndicator.setupWithViewPager(mViewPager);

        ivMenu = (ImageView)findViewById(R.id.act_main_iv_menu);
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(getApplicationContext(), v);
                popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId() == R.id.menu_main_notice) {
                            Toast.makeText(getApplicationContext(), "공지사항", Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.menu_main_setting) {
                            Toast.makeText(getApplicationContext(), "설정", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });

    }
}