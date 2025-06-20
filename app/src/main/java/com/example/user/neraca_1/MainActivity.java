package com.example.user.neraca_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity; // Ganti support.v7

import com.example.user.test.R;

public class MainActivity extends AppCompatActivity { // Ganti  AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void openTransaksi(View view) {
        Intent intent = new Intent(this, JenisTransaksiActivity.class);
        startActivity(intent);
    }

    public void openRekap(View view) {
        Intent intent = new Intent(this, JurnalTransaksiActivity.class);
        startActivity(intent);
    }

    public void openPengingat(View view) {
        Intent intent = new Intent(this, PengingatActivity.class);
        startActivity(intent);
    }

    public void openEkspor(View view) {
        Intent intent = new Intent(this, EksporDataActivity.class);
        startActivity(intent);
    }
}
