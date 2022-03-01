package com.example.casestudy04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PhuongTrinhBac2 {
        private int a;
        private int b;
        private int c;

        PhuongTrinhBac2(int a, int b, int c){
            this.a= a;
            this.b= b;
            this.c= c;

        }

    public String nghiemPT() {
        String st= "";
        float denta= b*b - 4*a*c;
        if (denta < 0){
            st ="Phung trinh v nghiem";
        }
        else  if (denta == 0){
            st = "Phung trinh c nghiem kep x = " + (-b*1.0/ (2*a));
        }
        else{
            st = "Phung trinh c 2 nghiem: ";
            st += "\n x1= " +  (-b + Math.sqrt(denta)) / (2*a);
            st += "\n x2= " +  (-b + Math.sqrt(denta)) / (2*a);
        }
        return st;
    }
}