package com.example.chloechoi.test.activities.Setting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.chloechoi.test.R;


//todo 테마 뷰페이저로 바꿔야 함!

public class SettingThemeFragment extends Fragment implements View.OnClickListener {

    TextView nowtheme;
    ViewPager themeviewpager;

    Button viewpagerbackBtn;
    Button viewpagernextBtn;

    int currentIndex;
    int tempIndex;

    int MAX_PAGE=3;

    Fragment currentFragment = new Fragment();
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_setting_theme, container, false);


        nowtheme = view.findViewById(R.id.setting_theme_nowthemetxt);
        themeviewpager = view.findViewById(R.id.setting_theme_viewpager);
        viewpagerbackBtn = view.findViewById(R.id.setting_theme_beforebtn);
        viewpagernextBtn = view.findViewById(R.id.setting_theme_afterbtn);

        viewpagerbackBtn.setOnClickListener(this);
        viewpagernextBtn.setOnClickListener(this);

        fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        themeviewpager.setAdapter(new viewpagerAdapter(fm));

        return view;

    }

    @Override
    public void onClick(View v) {
        if(v == viewpagerbackBtn){
            currentIndex = themeviewpager.getCurrentItem();
            Log.v("~~~", String.valueOf(themeviewpager.getCurrentItem()));

            if(currentIndex == 0){
                themeviewpager.setCurrentItem(2);
            }else{
                themeviewpager.setCurrentItem(currentIndex-1);
            }
            Log.v("~~~", String.valueOf(themeviewpager.getCurrentItem()));


        }else if(v == viewpagernextBtn){
            currentIndex = themeviewpager.getCurrentItem();
            Log.v("~~~", String.valueOf(themeviewpager.getCurrentItem()));

            if(currentIndex == 2){
                themeviewpager.setCurrentItem(0);
            }else{
                themeviewpager.setCurrentItem(currentIndex+1);
            }

            Log.v("~~~", String.valueOf(themeviewpager.getCurrentItem()));

        }

    }

    private class viewpagerAdapter extends FragmentPagerAdapter {                    //adapter클래스

        public viewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position<0 || MAX_PAGE<=position)        //가리키는 페이지가 0 이하거나 MAX_PAGE보다 많을 시 null로 리턴
                return null;
            switch (position){              //포지션에 맞는 Fragment찾아서 cur_fragment변수에 대입
                case 0:
                    currentFragment=new ThemeViewPagerFirstView();
                    break;

                case 1:
                    currentFragment=new ThemeViewPagerSecondView();
                    break;

                case 2:
                    currentFragment=new ThemeViewPagerThirdView();
                    break;
            }

            return currentFragment;
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }
}
