package com.example.chloechoi.test.list.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chloechoi.test.activities.main.fragment.Calendar.CalendarFragment;
import com.example.chloechoi.test.activities.main.fragment.HomeworkListFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {


    private int MAX_PAGE = 2;
    private Fragment curFragment = new Fragment();

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){

        if(position<0 || MAX_PAGE<=position)
            return null;
        switch (position) {
            case 0:
                curFragment = new HomeworkListFragment();
                break;
            case 1:
                curFragment = new CalendarFragment();
                break;
        }
        return curFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
