package com.example.a11202113905_responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView nmnt,almtnt,pkrjnnt,belint,hrgnt,jmlhnt,ttlnt,ppnnt,byrnt;

    String namant = "nama pemesan";
    String alamatnt = "alamat pemesan";
    String pekerjaannt = "pekerjaan pemesan";
    String belinota = "nama";
    String hargant = "harga";
    String jumlahnt = "jumlah pesan";
    String totalnt = "harga pesan";
    String ppnnota = "ppn";
    String bayarnt = "bayar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nmnt = findViewById(R.id.namanotaisi);
        almtnt = findViewById(R.id.alamatnotaisi);
        pkrjnnt = findViewById(R.id.pekerjaannotaisi);
        belint = findViewById(R.id.beliunitisi);
        hrgnt = findViewById(R.id.hargaunitisi);
        jmlhnt = findViewById(R.id.jumlahunitisi);
        ttlnt = findViewById(R.id.totalhrgunitisi);
        ppnnt = findViewById(R.id.ppnhrgisi);
        byrnt = findViewById(R.id.totalbyrisi);

        Bundle bundle = getIntent().getExtras();

        namant = bundle.getString(namant);
        alamatnt = bundle.getString(alamatnt);
        pekerjaannt = bundle.getString(pekerjaannt);
        belinota = bundle.getString(belinota);
        hargant = bundle.getString(hargant);
        jumlahnt = bundle.getString(jumlahnt);
        totalnt = bundle.getString(totalnt);
        ppnnota = bundle.getString(ppnnota);
        bayarnt = bundle.getString(bayarnt);

        nmnt.setText(namant);
        almtnt.setText(alamatnt);
        pkrjnnt.setText(pekerjaannt);
        belint.setText(belinota);
        hrgnt.setText("Rp " + hargant);
        jmlhnt.setText(jumlahnt);
        ttlnt.setText("Rp " + totalnt);
        ppnnt.setText("Rp " + ppnnota);
        byrnt.setText("Rp " + bayarnt);

    }
}