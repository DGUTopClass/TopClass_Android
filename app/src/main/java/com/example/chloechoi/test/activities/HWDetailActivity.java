package com.example.chloechoi.test.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;


public class HWDetailActivity extends AppCompatActivity {

    RelativeLayout contentsCollapse;
    RelativeLayout contentsConcrete;
    Button btnContents;
    TextView tvMemo;
    EditText etMemo;

    int contentsViewIndex = 0;


    @Override
    protected void onCreate(Bundle savedInsatanceState) {
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_hw_detail);

        contentsCollapse = (RelativeLayout) findViewById(R.id.rl_hw_detail_contents_collapse);
        contentsConcrete = (RelativeLayout) findViewById(R.id.rl_hw_detail_contents_concrete);
        btnContents = (Button)findViewById(R.id.btn_hw_detail_contents);


        btnContents.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView();
            }
        });

        tvMemo = (TextView)findViewById(R.id.tv_memo);
        etMemo = (EditText)findViewById(R.id.et_memo);
        tvMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                changeToEditText();
            }
        });

        changeView();
    }

    public void changeView(){
        if(contentsViewIndex == 0){
            contentsCollapse.setVisibility(View.VISIBLE);
            contentsConcrete.setVisibility(View.GONE);

            contentsViewIndex = 1;
            btnContents.setText("+ 더보기");

        } else if(contentsViewIndex == 1){
            contentsCollapse.setVisibility(View.GONE);
            contentsConcrete.setVisibility(View.VISIBLE);

            contentsViewIndex = 0;
            btnContents.setText("- 숨기기");
        }
    }

    public void changeToEditText(){
        etMemo.setVisibility(View.VISIBLE);
        tvMemo.setVisibility(View.INVISIBLE);
    }
}
