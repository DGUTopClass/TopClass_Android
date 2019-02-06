package com.example.chloechoi.test.activities.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.fragment.TodoAddFragment;


public class WorkboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workbox);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.main_header, new HeaderFragment());
        fragmentTransaction.add(R.id.main_body, new TodoAddFragment());
        fragmentTransaction.commit();
    }

}
