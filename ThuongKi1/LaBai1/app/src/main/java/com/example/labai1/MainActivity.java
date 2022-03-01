package com.example.labai1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int mangCacLaBai[] = {
            R.drawable.ch10, R.drawable.ch2, R.drawable.ch3, R.drawable.ch4, R.drawable.ch5,
            R.drawable.ch6, R.drawable.ch7, R.drawable.ch8, R.drawable.ch9, R.drawable.ch10,
            R.drawable.chj, R.drawable.chq, R.drawable.chk,
            R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5,
            R.drawable.r6, R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10,
            R.drawable.rj, R.drawable.rq, R.drawable.rk,
            R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.cj, R.drawable.cq, R.drawable.ck,
            R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5,
            R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10,
            R.drawable.bj, R.drawable.bq, R.drawable.bk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle("Kết Quả");

        myDialog.setPositiveButton("Chơi tiếp", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Lượt chơi mới", Toast.LENGTH_SHORT).show();
                recreate();
            }
        });

        myDialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Thoát khỏi chương trình", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        //Máy chơi
        ImageView imageViewMay1 = findViewById(R.id.imageViewMay1);
        ImageView imageViewMay2 = findViewById(R.id.imageViewMay2);
        ImageView imageViewMay3 = findViewById(R.id.imageViewMay3);

        //Người Chơi
        ImageView imageViewNguoi1 = findViewById(R.id.imageViewNguoi1);
        ImageView imageViewNguoi2 = findViewById(R.id.imageViewNguoi2);
        ImageView imageViewNguoi3 = findViewById(R.id.imageViewNguoi3);


        //Kết quả
        TextView ketQuaMay = findViewById(R.id.tvKQMay);
        TextView ketQuaNguoi = findViewById(R.id.tvKQNguoi);


        //Điểm cộng dồn
        TextView diemMay = findViewById(R.id.diemMay);
        TextView diemNguoi = findViewById(R.id.diemNguoi);


        //Số nút
        Button choi = findViewById(R.id.btnChoi);

        choi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Tính điểm cộng dồn
                int mayChoi = Integer.parseInt(diemMay.getText().toString().trim());
                int nguoiChoi = Integer.parseInt(diemNguoi.getText().toString().trim());

                //Số lần chơi
                if ((mayChoi + nguoiChoi) != 10) {

                    int chiabai[]=lay6SoNgauNhien(0,51);

                    int valueMay[]={chiabai[0],chiabai[2],chiabai[4]};
                    imageViewMay1.setImageResource(mangCacLaBai[valueMay[0]]);
                    imageViewMay2.setImageResource(mangCacLaBai[valueMay[1]]);
                    imageViewMay3.setImageResource(mangCacLaBai[valueMay[2]]);
                    ketQuaMay.setText(tinhKetQua(valueMay));


                    int valueNguoi[]={chiabai[1],chiabai[3],chiabai[5]};
                    imageViewNguoi1.setImageResource(mangCacLaBai[valueNguoi[0]]);
                    imageViewNguoi2.setImageResource(mangCacLaBai[valueNguoi[1]]);
                    imageViewNguoi3.setImageResource(mangCacLaBai[valueNguoi[2]]);
                    ketQuaNguoi.setText(tinhKetQua(valueNguoi));


                    int nutMay = tinhSoNut(valueMay);
                    int nutNguoi = tinhSoNut(valueNguoi);

                    if (nutMay > nutNguoi) {
                        mayChoi += 1;
                        diemMay.setText(String.valueOf(mayChoi));
                    } else if (nutMay < nutNguoi) {
                        nguoiChoi += 1;
                        diemNguoi.setText(String.valueOf(nguoiChoi));
                    }
                } else {
                    if (mayChoi > nguoiChoi){
                        String mess= "LOSE\n"+"Máy: "+mayChoi+"\n"+"Bạn: "+nguoiChoi;
                        myDialog.setMessage(mess);
                        AlertDialog dialog= myDialog.create();
                        dialog.show();
                    }
                    else  if (nguoiChoi > mayChoi){
                        String mess= "WIN\n"+"Bạn: "+nguoiChoi+"\n"+"Máy: "+mayChoi;
                        myDialog.setMessage(mess);
                        AlertDialog dialog= myDialog.create();
                        dialog.show();
                    }
                    else{
                        String mess= "HÒA\n"+"Bạn: "+nguoiChoi+"\n"+"Máy: "+mayChoi;
                        myDialog.setMessage(mess);
                        AlertDialog dialog= myDialog.create();
                        dialog.show();
                    }
                }

            }
        });
    }

    //Kiểm tra trùng
    private boolean ktTrung(int k, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == k)
                return true;
        return false;
    }


    //Chọn ngẫu nhiên trong khoảng xác định
    private int random(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }


    // Lấy 6 số ngẫu nhiên không trùng
    private int[] lay6SoNgauNhien(int min, int max) {
        int[] baso = new int[6];
        int i = 0;
        baso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!ktTrung(k, baso))
                baso[i++] = k;
        } while (i < 6);
        return baso;
    }


    //Tính số lá Tây
    private int tinhSoTay(int[] a) {
        int k = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] % 13 >= 10 && a[i] % 13 < 13)
                k++;
        return k;
    }


    //Tính kết quả của 3 lá bài rút đc
    private String tinhKetQua(int[] baso) {
        String KQ = "";
        if (tinhSoTay(baso) == 3)
            KQ = "Kết Quả: 3 tây";
        else {
            int tong = 0;
            for (int i = 0; i < baso.length; i++)
                if (baso[i] % 13 < 10)
                    tong += baso[i] % 13 + 1;
            if (tong % 10 == 0)
                KQ = "Bù! Trong đó có " + tinhSoTay(baso) + " tây";
            else
                KQ = "Kết quả là: " + tong % 10 + " nút, trong đó có " + tinhSoTay(baso) + " tây";
        }
        return KQ;
    }


    private int tinhSoNut(int[] baso) {
        if (tinhSoTay(baso) == 3) {
            return 10;
        } else {
            int tong = 0;
            for (int i = 0; i < baso.length; i++)
                if (baso[i] % 13 < 10)
                    tong += baso[i] % 13 + 1;
            if (tong % 10 == 0)
                return 0;
            else
                return tong % 10;
        }
    }








    // Test thử lấy 3 số ngẫu nhiên không trùng
    private int[] lay3SoNgauNhien(int min, int max) {
        int[] baso = new int[3];
        int i = 0;
        baso[i++] = random(min, max);
        do {
            int k = random(min, max);
            if (!ktTrung(k, baso))
                baso[i++] = k;
        } while (i < 3);
        return baso;
    }
}