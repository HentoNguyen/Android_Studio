package com.example.casestudy02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        String hoten= getIntent().getExtras().getString("ht");
        String namsinh= getIntent().getExtras().getString("ns");
        String namsinh1= Calendar.getInstance().toString();

        String st= "";
        st= "Họ và tên: " +hoten;
        st += "\nNăm sinh: " +namsinh1;


        TextView tv_ketqua= findViewById(R.id.textview_ketQua);
        tv_ketqua.setText(st);
    }
}