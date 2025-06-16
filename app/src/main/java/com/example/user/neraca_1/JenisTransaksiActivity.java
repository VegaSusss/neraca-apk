package com.example.user.neraca_1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.user.test.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class JenisTransaksiActivity extends AppCompatActivity {
    Button date;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.jenis_transaksi);

        Spinner jenisSpinner = findViewById(R.id.jenisTransaksiSpinner);
        ArrayAdapter<CharSequence> jenisAdapter = ArrayAdapter.createFromResource(this, R.array.list_transaksi, android.R.layout.simple_spinner_item);
        jenisAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenisSpinner.setAdapter(jenisAdapter);

        ArrayAdapter<CharSequence> objekAdapter = ArrayAdapter.createFromResource(this, R.array.list_objek, android.R.layout.simple_spinner_item);
        objekAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        date = findViewById(R.id.waktuTransaksiButton);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("d/M/yyyy", Locale.US);
        String formattedDate = df.format(c.getTime());
        date.setText(formattedDate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(JenisTransaksiActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String the_date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                date.setText(the_date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    public void goToObjekTransaksi(View view){
        Spinner jenisSpinner = findViewById(R.id.jenisTransaksiSpinner);
        Button waktuButton = findViewById(R.id.waktuTransaksiButton);
        TextView keteranganTextView = findViewById(R.id.keteranganTransaksiInput);

        String jenisTransaksi = jenisSpinner.getSelectedItem().toString();
        String waktuTransaksi = waktuButton.getText().toString();
        String keterangan = keteranganTextView.getText().toString();

        Intent intent;
        if (jenisTransaksi.equals("Penjualan")) {
            intent = new Intent(this, ObjekTransaksiActivity.class);
        } else {
            intent = new Intent(this, PembelianActivity.class);
        }

        intent.putExtra("jenis", jenisTransaksi);
        intent.putExtra("waktu", waktuTransaksi);
        intent.putExtra("keterangan", keterangan);

        startActivity(intent);
    }
}
