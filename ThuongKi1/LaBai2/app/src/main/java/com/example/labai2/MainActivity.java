package com.example.labai2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    CountDownTimer Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Máy 1
        ImageView imageView1May1 = findViewById(R.id.imageView1May1);
        ImageView imageView2May1 = findViewById(R.id.imageView2May1);
        ImageView imageView3May1 = findViewById(R.id.imageView3May1);


        //Máy 2
        ImageView imageView1May2 = findViewById(R.id.imageView1May2);
        ImageView imageView2May2 = findViewById(R.id.imageView2May2);
        ImageView imageView3May2 = findViewById(R.id.imageView3May2);


        //Kết quả
        TextView ketQuaMay1 = findViewById(R.id.tvKQMay1);
        TextView ketQuaMay2 = findViewById(R.id.tvKQMay2);


        //Điểm cộng dồn
        TextView diemMay1 = findViewById(R.id.diemMay1);
        TextView diemMay2 = findViewById(R.id.diemMay2);

        //Nút
        Button choi = findViewById(R.id.btnChoi);


        //Thời gian
        EditText thoiGian = findViewById(R.id.etTimeStart);
        EditText buocNhay = findViewById(R.id.etStep);


        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle("Kết Quả");

        myDialog.setPositiveButton("Chơi tiếp", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                thoiGian.setText("");
                buocNhay.setText("");
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



        AlertDialog.Builder thongBao = new AlertDialog.Builder(this);
        thongBao.setTitle("Thông Báo").setMessage("Bạn chưa nhập thời gian?");

        thongBao.setPositiveButton("Đặt Thời Gian", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });


        thongBao.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Thoát khỏi chương trình", Toast.LENGTH_SHORT).show();
                finish();
            }
        });



        //Cài đặt tgian chơi
        choi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thoiGian.length()==0 || buocNhay.length()==0) {
                    AlertDialog dialog = thongBao.create();
                    dialog.show();
                } else {
                    Timer = new CountDownTimer(Integer.parseInt(thoiGian.getText().toString()) * 1000,
                            Integer.parseInt(buocNhay.getText().toString()) * 1000) {

                        @Override
                        public void onTick(long l) {
                            int may1 = Integer.parseInt(diemMay1.getText().toString().trim());
                            int may2 = Integer.parseInt(diemMay2.getText().toString().trim());

                            int chiabai[] = lay6SoNgauNhien(0, 51);

                            int valueMay1[] = {chiabai[0], chiabai[2], chiabai[4]};
                            imageView1May1.setImageResource(mangCacLaBai[valueMay1[0]]);
                            imageView2May1.setImageResource(mangCacLaBai[valueMay1[1]]);
                            imageView3May1.setImageResource(mangCacLaBai[valueMay1[2]]);
                            ketQuaMay1.setText(tinhKetQua(valueMay1));

                            int valueMay2[] = {chiabai[1], chiabai[3], chiabai[5]};
                            imageView1May2.setImageResource(mangCacLaBai[valueMay2[0]]);
                            imageView2May2.setImageResource(mangCacLaBai[valueMay2[1]]);
                            imageView3May2.setImageResource(mangCacLaBai[valueMay2[2]]);
                            ketQuaMay2.setText(tinhKetQua(valueMay2));

                            int nutMay1 = tinhSoNut(valueMay1);
                            int nutMay2 = tinhSoNut(valueMay2);

                            if (nutMay1 > nutMay2) {
                                may1 += 1;
                                diemMay1.setText(String.valueOf(may1));
                            } else if (nutMay1 < nutMay2) {
                                may2 += 1;
                                diemMay2.setText(String.valueOf(may2));
                            }

                        }

                        @Override
                        public void onFinish() {
                            int may1 = Integer.parseInt(diemMay1.getText().toString().trim());
                            int may2 = Integer.parseInt(diemMay2.getText().toString().trim());

                            if (may1 > may2) {
                                String mess = "Máy 1 WIN\n" + "Máy 1: " + may1 + "\n" + "Máy 2: " + may2;
                                myDialog.setMessage(mess);
                                AlertDialog dialog = myDialog.create();
                                dialog.show();
                            } else if (may2 > may1) {
                                String mess = "Máy 2 WIN\n" + "Máy 2: " + may2 + "\n" + "Máy 1: " + may1;
                                myDialog.setMessage(mess);
                                AlertDialog dialog = myDialog.create();
                                dialog.show();
                            }
                            else{
                                String mess= "HÒA\n"+"Máy 2: "+may2+"\n"+"Máy 1: "+may1;
                                myDialog.setMessage(mess);
                                AlertDialog dialog= myDialog.create();
                                dialog.show();
                            }
                        }
                    }.start();

                }

            }
        });
    }




    //Chọn ngẫu nhiên trong khoảng xác định
    private int random(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }


    //Kiểm tra  trùng
    private boolean ktTrung(int k, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == k)
                return true;
        return false;
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
                KQ = "Bù, trong đó có " + tinhSoTay(baso) + " tây";
            else
                KQ = "Kết quả là " + tong % 10 + " nút, trong đó có " + tinhSoTay(baso) + " tây";
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
}