package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;

public class SettingProfileFragment extends Fragment implements View.OnClickListener {

    TextView studentnumtxt;
    TextView passwordtxt;

    RelativeLayout modifyprofilebtn;

    Intent tomodifyInent = new Intent(this.getContext(), SettingProfileModifyFragment.class);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initialUI();

        return inflater.inflate(R.layout.fragment_setting_profile, container, false);

    }

    void initialUI(){
        studentnumtxt.findViewById(R.id.setting_profile_studentnum);
        passwordtxt.findViewById(R.id.setting_profile_passwordnum);

        modifyprofilebtn.findViewById(R.id.setting_profile_modify_btn);
        modifyprofilebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == modifyprofilebtn){
            startActivity(tomodifyInent);
        }

    }
}
