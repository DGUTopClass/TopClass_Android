package com.example.chloechoi.test.activities.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chloechoi.test.R;

public class SettingProfileModifyFragment extends Fragment implements View.OnClickListener {

    EditText studentnum;
    TextView nowpassword;
    EditText newpassword;
    EditText renewpassword;

    Button saveprofileBtn;

    Intent saveprofileIntent = new Intent(this.getContext(), SettingProfileFragment.class);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initialUI();

        return inflater.inflate(R.layout.fragment_setting_profile_modify, container, false);
    }

    void initialUI(){
        studentnum.findViewById(R.id.setting_profile_studentnum);
        nowpassword.findViewById(R.id.setting_profile_modify_nowpassword);
        newpassword.findViewById(R.id.setting_profile_modify_newpassword);
        renewpassword.findViewById(R.id.setting_profile_modify_renewpassword);

        saveprofileBtn.findViewById(R.id.setting_profile_modify_savebtn);
        saveprofileBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == saveprofileBtn){

            if(newpassword.getText().toString() == renewpassword.getText().toString()){  //비번 and 비번확인이 일치 하는지 확인

                saveprofileIntent.putExtra("studentnum", studentnum.getText().toString());
                saveprofileIntent.putExtra("newpassword", newpassword.getText().toString());

                startActivity(saveprofileIntent);
            }else{
                //todo 비밀번호 확인 일치 하지 않을 때 어떤식으로 처리 할지?
            }
        }

    }
}
