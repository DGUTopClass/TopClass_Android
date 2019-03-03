package com.example.chloechoi.test.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.model.Homework;
import com.example.chloechoi.test.utility.Constants;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class HWDetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvSubject;
    TextView tvDate;
    RelativeLayout contentsCollapse;
    RelativeLayout contentsConcrete;
    TextView tvContentCollpase;
    TextView tvContentConcrete;
    Button btnContents;
    TextView tvMemo;
    EditText etMemo;

    TextView tvHeader;
    ImageView ivBack;


    Homework homework;
    Constants constants = new Constants();

    int contentsViewIndex = 0;


    @Override
    protected void onCreate(Bundle savedInsatanceState) {
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_hw_detail);

        Intent intent = new Intent(this.getIntent());

        initialUI();

        setData();

        changeView();
    }

    public void initialUI(){

        tvTitle = (TextView)findViewById(R.id.tv_detail_title);
        tvSubject = (TextView)findViewById(R.id.tv_detail_subject);
        tvSubject.setPaintFlags(tvSubject.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvDate = (TextView)findViewById(R.id.tv_detail_date);

        contentsCollapse = (RelativeLayout) findViewById(R.id.rl_hw_detail_contents_collapse);
        tvContentCollpase = (TextView)findViewById(R.id.tv_contents_collapse);
        contentsConcrete = (RelativeLayout) findViewById(R.id.rl_hw_detail_contents_concrete);
        tvContentConcrete = (TextView)findViewById(R.id.tv_contents_concrete);
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

        tvHeader = (TextView)findViewById(R.id.tv_setting_title);
        tvHeader.setText("");
        ivBack = (ImageView)findViewById(R.id.iv_setting_back);
        ivBack.setImageResource(R.drawable.header_back_btn_with_color);

    }

    public void setData(){

        homework = new Homework().getDetailDummy();

        tvTitle.setText(homework.getTitle());
        tvSubject.setText(homework.getSubject());
        tvDate.setText(homework.toShowStartDate() + " ~ " +  homework.toShowFinishDate(constants.TYPE_HW_DETAIL));
        tvContentCollpase.setText(homework.getContents());
        tvContentConcrete.setText(homework.getContents());

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
