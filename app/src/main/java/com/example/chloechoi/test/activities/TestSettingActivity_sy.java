package com.example.chloechoi.test.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.fragment.SettingFragment;


public class TestSettingActivity_sy extends Activity implements View.OnClickListener {


    RelativeLayout movetofragment = new RelativeLayout(this);
    Intent moveIntent = new Intent(this, SettingFragment.class);

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {


        setContentView(R.layout.activity_test_setting_sy);

        movetofragment.findViewById(R.id.test_btn_layout);
        movetofragment.setOnClickListener(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

        if(v == movetofragment){
           startActivity(moveIntent);
        }

    }
}
