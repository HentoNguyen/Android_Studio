package com.example.casestudy04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        EditText et_HeSoA= findViewById(R.id.editText_HeSoA);
        EditText et_HeSoB= findViewById(R.id.editText_HeSoB);
        EditText et_HeSoC= findViewById(R.id.editText_HeSoC);

        Button bt_Submit= findViewById(R.id.button_Submit);

        bt_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                int a= Integer.parseInt(et_HeSoA.getText().toString());
                int b= Integer.parseInt(et_HeSoB.getText().toString());
                int c= Integer.parseInt(et_HeSoC.getText().toString());

                PhuongTrinhBac2 hai= new PhuongTrinhBac2(a, b, c);
                intent.putExtra("nghiem", hai.nghiemPT());

                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}