package com.example.chloechoi.test.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chloechoi.test.R;
import com.example.chloechoi.test.utility.Constants;

import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSignIn;
    List<EditText> edtList = new ArrayList<>();

    List<String> strInputs = new ArrayList<>();

    String[] msgs = {Constants.TYPE_STUDENT_ID, Constants.TYPE_PASSWORD};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        initialUI();
    }

    void initialUI(){
        tvSignIn = (TextView)findViewById(R.id.tv_signin);
        tvSignIn.setOnClickListener(this);

        edtList.add((EditText) findViewById(R.id.edt_student_id));
        edtList.get(0).setOnClickListener(this);
        edtList.add((EditText) findViewById(R.id.edt_password));
        edtList.get(1).setOnClickListener(this);

    }

    void getInput(){
        if(strInputs.size() > 0) strInputs.clear();

        for(EditText edt : edtList){
            strInputs.add(edt.getText().toString());
        }
    }

    boolean checkInputs(){
        int index = 0;
        for(String strInput : strInputs){
            if(strInput.equals("")){
                Toast.makeText(getApplicationContext(), msgs[index], Toast.LENGTH_LONG).show();
                return false;
            }
            else index++;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        if( v == tvSignIn){
            getInput();

            if(checkInputs()){
//                    TODO 모든 입력을 받음 > 서버에 유효한 학번 및 비번인지 확인
            }
        }

        else if( v == edtList.get(0)) edtList.get(0).setText("");
        else if( v == edtList.get(1)) edtList.get(1).setText("");

    }
}
