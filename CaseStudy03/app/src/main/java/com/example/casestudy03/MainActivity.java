package com.example.casestudy03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv_KQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_KQ= findViewById(R.id.tv_KetQua);
        Button bt_NhapThongTin= findViewById(R.id.button_Nhapthongtin);
        bt_NhapThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent,9999);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9999 && resultCode == RESULT_OK){
            String hoten= data.getExtras().getString("ht").toString();
            String namsinh= data.getExtras().getString("ns").toString();
            int namSinh= Integer.parseInt(namsinh);
            Calendar calendar= Calendar.getInstance();

            int namHienTai= calendar.get(Calendar.YEAR);
            int tuoi= namHienTai -namSinh;
            String st= "";
            st += "Ho va ten: " +hoten;
            st += "\nNam sinh: " +namsinh;
            st += "\nTuoi: " +(namHienTai - namSinh);

            tv_KQ.setText(st);


        }


    }
}