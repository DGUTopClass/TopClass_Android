/*
package com.example.chloechoi.test.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.fragment.SettingFragment;


public class TestSettingActivity_sy extends Activity implements View.OnClickListener {

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState) {
        Log.d("sylee","oncreate in?");

        setContentView(R.layout.activity_test_setting_sy);

        final Button testBtn  = findViewById(R.id.testBtn);
        final Intent moveIntent = new Intent(this, SettingFragment.class);

        Button.OnClickListener btnclickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.d("sylee","click 되나? 1" );
                if(v == testBtn){
                    startActivity(moveIntent);
                }
            }
        };
        testBtn.setOnClickListener(btnclickListener);
        */
/*movetofragment.setOnClickListener(this);
*//*

        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        Log.d("sylee","click 되나? 2" );

    }
}
*/


package com.example.chloechoi.test.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.TestHeaderFragment;
import com.example.chloechoi.test.activities.main.fragment.SettingFragment;


public class TestSettingActivity_sy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workbox);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.main_header, new TestHeaderFragment());
        fragmentTransaction.add(R.id.main_body, new SettingFragment());
        fragmentTransaction.commit();
    }

}
