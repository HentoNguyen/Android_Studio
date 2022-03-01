package com.example.casestudy02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_hoten= findViewById(R.id.editText_HoTen);
        EditText et_namsinh= findViewById(R.id.editText_NamSinh);
        Button bt_submit= findViewById(R.id.button_Submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("ht", et_hoten.getText().toString() );
                intent.putExtra("ns", et_namsinh.getText().toString() );
                startActivity(intent);
            }
        });



    }
}