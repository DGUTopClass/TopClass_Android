package com.example.chloechoi.test.activities.Setting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chloechoi.test.R;


//todo 테마 뷰페이저로 바꿔야 함!

public class SettingThemeFragment extends Fragment{

    TextView nowtheme;
    ViewPager themeviewpager;

    int MAX_PAGE=3;
    Fragment currentFragment =new Fragment();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.v("~~~","settingthemefragment oncreateview 들어와라~~");

        View view = inflater.inflate(R.layout.fragment_setting_theme, container, false);


        nowtheme = view.findViewById(R.id.setting_theme_nowthemetxt);
        themeviewpager = view.findViewById(R.id.setting_theme_viewpager);

        return view;


    }

    private class adapter extends FragmentPagerAdapter {                    //adapter클래스
        public adapter(FragmentManager fm) {
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
