package com.example.user.neraca_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity; // pakai AppCompatActivity modern

import com.example.user.test.R;

public class JurnalTransaksiActivity extends AppCompatActivity {

    String[] barang = {"Uang", "Mie Kuning", "Daging Sapi", "Kerupuk", "Bakso"};
    String[] jumlah = {"Rp100.000", "1 kg", "1 kg", "15 buah", "Habis"};

    TextView nama;
    TextView nominal;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.jurnal_transaksi);

        nama = findViewById(R.id.nama_barang);
        nominal = findViewById(R.id.nominal_barang);

        updateData();
    }

    public void GeserKanan(View view) {
        i = (i + 1) % barang.length;
        updateData();
    }

    public void GeserKiri(View view) {
        i = (i - 1 + barang.length) % barang.length;
        updateData();
    }

    private void updateData() {
        nama.setText(barang[i]);
        nominal.setText(jumlah[i]);

        if ("Habis".equals(jumlah[i])) {
            nominal.setTextColor(Color.BLACK);
        } else {
            nominal.setTextColor(Color.argb(255, 11, 159, 38));
        }
    }
}
