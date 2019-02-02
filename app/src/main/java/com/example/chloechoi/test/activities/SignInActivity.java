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

public class SignInActivity extends AppCompatActivity {

    TextView tvSignIn;
    List<EditText> edtList;

    List<String> strInputs;

    String[] msgs = {Constants.TYPE_STUDENT_ID, Constants.TYPE_PASSWORD};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        initialUI();

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInput();

                if(checkInputs()){
//                    TODO 모든 입력을 받음 > 서버에 유효한 학번 및 비번인지 확인
                }
            }
        });
    }

    void initialUI(){
        tvSignIn = (TextView)findViewById(R.id.tv_signin);

        edtList.add((EditText) findViewById(R.id.edt_student_id));
        edtList.add((EditText) findViewById(R.id.edt_password));

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
}
