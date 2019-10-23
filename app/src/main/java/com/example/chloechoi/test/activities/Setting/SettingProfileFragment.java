package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.HeaderFragment;

public class SettingProfileFragment extends Fragment implements View.OnClickListener {

    TextView studentnumtxt;
    TextView passwordtxt;

    RelativeLayout modifyprofilebtn;

    FragmentManager fm;
    FragmentTransaction fragmentTransaction;


    //Intent tomodifyInent = new Intent(this.getContext(), SettingProfileModifyFragment.class);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting_profile, container, false);

        fm = getFragmentManager();
        fragmentTransaction = fm.beginTransaction();


        studentnumtxt = view.findViewById(R.id.setting_profile_studentnum);
        passwordtxt = view.findViewById(R.id.setting_profile_passwordnum);
        modifyprofilebtn = view.findViewById(R.id.setting_profile_modify_btn);
        modifyprofilebtn.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
/*
        if(v == modifyprofilebtn){
            fragmentTransaction.replace(R.id.main_header, new HeaderFragment());
            fragmentTransaction.replace(R.id.main_body, new SettingProfileModifyFragment());
            fragmentTransaction.commit();
        }
*/
    }
}
