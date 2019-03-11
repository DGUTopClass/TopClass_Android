package com.example.chloechoi.test.activities.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chloechoi.test.R;


public class HomeworkListFragment extends Fragment {

    HomeworkToBeSubmittedFragment toBeSubmittedFragement;
    HomeworkSubmittedFragment submittedFragment;

    int position = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_hw_list, container, false);


        toBeSubmittedFragement = new HomeworkToBeSubmittedFragment();
        submittedFragment = new HomeworkSubmittedFragment();

        TabLayout hwTab = (TabLayout) rootView.findViewById(R.id.tl_hw);
        hwTab.addTab(hwTab.newTab().setText("제출예정"));
        hwTab.addTab(hwTab.newTab().setText("지난과제"));

        getFragmentManager().beginTransaction().add(R.id.rl_list_content, toBeSubmittedFragement).commit();


        hwTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();

                Fragment selected = null;

                if(position == 0){
                    selected = toBeSubmittedFragement;
                } else if(position == 1){
                    selected = submittedFragment;
                  }

                getFragmentManager().beginTransaction().replace(R.id.rl_list_content, selected).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

    public int getPosition(){
        return position;
    }

}
