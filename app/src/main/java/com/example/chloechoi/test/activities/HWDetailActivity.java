package com.example.chloechoi.test.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.model.Homework;
import com.example.chloechoi.test.utility.Constants;



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

    ImageView ivBack;
    ImageView ivAttach;
    TextView tvSave;


    Homework homework = new Homework().getDetailDummy();
    Constants constants = new Constants();

    int contentsViewIndex = 0;


    @Override
    protected void onCreate(Bundle savedInsatanceState) {
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_hw_detail);

        Intent intent = new Intent(this.getIntent());

        initialUI();

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
        etMemo.requestFocus();
        tvMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                changeMemo();
            }
        });

        ivBack = (ImageView)findViewById(R.id.iv_back);
        ivBack.setImageResource(R.drawable.header_back_btn_with_color);

        ivAttach = (ImageView)findViewById(R.id.iv_memo_attach);
        ivAttach.setImageResource(R.drawable.homework_detail_attach_btn);
        ivAttach.setVisibility(View.INVISIBLE);

        tvSave = (TextView)findViewById(R.id.tv_save);
        tvSave.setText("저장");
        tvSave.setVisibility(View.INVISIBLE);

        setData();

    }


    // 지금은 이렇게 data를 불러오지만 통신할 때는 어떻게 불러와야 하지?
    public void setData(){

        tvTitle.setText(homework.getTitle());
        tvSubject.setText(homework.getSubject());
        tvDate.setText(homework.toShowStartDate() + " ~ " +  homework.toShowFinishDate(constants.TYPE_HW_DETAIL));
        tvContentCollpase.setText(homework.getContents());
        tvContentConcrete.setText(homework.getContents());
        if(homework.getMemo() != null) {
            tvMemo.setText(homework.getMemo());
            etMemo.setText(homework.getMemo());
        }

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

    public void changeMemo(){

        InputMethodManager imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm1.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        tvMemo.setVisibility(View.INVISIBLE);
        etMemo.setVisibility(View.VISIBLE);

        etMemo.setSelection(etMemo.getText().length());

        ivAttach.setVisibility(View.VISIBLE);
        tvSave.setVisibility(View.VISIBLE);

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memo = etMemo.getText().toString();
                homework.setMemo(memo);

                InputMethodManager imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm2.hideSoftInputFromWindow(v.getWindowToken(), 0);

                tvMemo.setVisibility(View.VISIBLE);
                etMemo.setVisibility(View.INVISIBLE);

                ivAttach.setVisibility(View.INVISIBLE);
                tvSave.setVisibility(View.INVISIBLE);

                setData();
            }
        });
    }

    public void saveMemo(){

    }


}
