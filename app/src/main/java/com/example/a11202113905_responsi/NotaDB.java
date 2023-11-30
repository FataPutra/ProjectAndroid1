package com.example.a11202113905_responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotaDB extends AppCompatActivity {

    TextView nmnt,almtnt,pkrjnnt,belint,hrgnt,jmlhnt,stknt,ttlnt,ppnnt,byrnt;
    Button btnback;
    DBHelper DB;

    String namant = "nama pemesan";
    String alamatnt = "alamat pemesan";
    String pekerjaannt = "pekerjaan pemesan";
    String belinota = "nama";
    String hargant = "harga";
    String jumlahnt = "jumlah pesan";
    String stokakhir = "stok akhir";
    String totalnt = "harga pesan";
    String ppnnota = "ppn";
    String bayarnt = "bayar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_db);

        nmnt = findViewById(R.id.namanotaisi);
        almtnt = findViewById(R.id.alamatnotaisi);
        pkrjnnt = findViewById(R.id.pekerjaannotaisi);
        belint = findViewById(R.id.beliunitisi);
        hrgnt = findViewById(R.id.hargaunitisi);
        jmlhnt = findViewById(R.id.jumlahunitisi);
        stknt = findViewById(R.id.stokunitisi);
        ttlnt = findViewById(R.id.totalhrgunitisi);
        ppnnt = findViewById(R.id.ppnhrgisi);
        byrnt = findViewById(R.id.totalbyrisi);
        btnback = findViewById(R.id.tombolback);

        Bundle bundle = getIntent().getExtras();

        namant = bundle.getString(namant);
        alamatnt = bundle.getString(alamatnt);
        pekerjaannt = bundle.getString(pekerjaannt);
        belinota = bundle.getString(belinota);
        hargant = bundle.getString(hargant);
        jumlahnt = bundle.getString(jumlahnt);
        stokakhir = bundle.getString(stokakhir);
        totalnt = bundle.getString(totalnt);
        ppnnota = bundle.getString(ppnnota);
        bayarnt = bundle.getString(bayarnt);

        nmnt.setText(namant);
        almtnt.setText(alamatnt);
        pkrjnnt.setText(pekerjaannt);
        belint.setText(belinota);
        hrgnt.setText("Rp " + hargant);
        jmlhnt.setText(jumlahnt);
        stknt.setText(stokakhir);
        ttlnt.setText("Rp " + totalnt);
        ppnnt.setText("Rp " + ppnnota);
        byrnt.setText("Rp " + bayarnt);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotaDB.this, MainActivityDB.class);
                startActivity(intent);;
            }
        });
    }

}