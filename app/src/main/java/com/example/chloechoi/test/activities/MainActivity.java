package com.example.chloechoi.test.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.example.chloechoi.test.R;
import com.example.chloechoi.test.activities.main.fragment.HomeworkListFragment;
import com.example.chloechoi.test.list.adapter.HomeworkAdapter;
import com.example.chloechoi.test.model.HomeworkData;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    HomeworkListFragment hwListFragement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hwListFragement = new HomeworkListFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, hwListFragement).commit();

    }
}