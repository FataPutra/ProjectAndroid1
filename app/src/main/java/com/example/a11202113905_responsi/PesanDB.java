package com.example.a11202113905_responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PesanDB extends AppCompatActivity {

    EditText nmpsn , almtpsn , pkrjnpsn;
    Button btnpsn , btnklr;

    String nm_brg = "nama";
    String hrg_brg = "harga";
    String jmlh_psn = "jumlah pesan";
    String hrg_psn = "harga pesan";
    String ppn_psn = "ppn";
    String byr_psn = "bayar";
    String stok_akhir = "stok akhir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        nmpsn = (EditText) findViewById(R.id.editNama);
        almtpsn = (EditText) findViewById(R.id.editAlamat);
        pkrjnpsn = (EditText) findViewById(R.id.editPekerjaan);
        btnpsn = (Button) findViewById(R.id.buttonPesan);
        btnklr = (Button) findViewById(R.id.buttonKeluar);

        Bundle bundle = getIntent().getExtras();
        nm_brg = bundle.getString(nm_brg);
        hrg_brg = bundle.getString(hrg_brg);
        jmlh_psn = bundle.getString(jmlh_psn);
        hrg_psn = bundle.getString(hrg_psn);
        ppn_psn = bundle.getString(ppn_psn);
        byr_psn = bundle.getString(byr_psn);
        stok_akhir=bundle.getString(stok_akhir);
        btnpsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nmpemesan = nmpsn.getText().toString();
                String almtpemesan = almtpsn.getText().toString();
                String pkrjnpemesan = pkrjnpsn.getText().toString();
                Intent intent = new Intent(PesanDB.this , NotaDB.class);
                intent.putExtra("nama pemesan" , nmpemesan);
                intent.putExtra("alamat pemesan" , almtpemesan);
                intent.putExtra("pekerjaan pemesan" , pkrjnpemesan);
                intent.putExtra("nama" , nm_brg);
                intent.putExtra("harga" , hrg_brg);
                intent.putExtra("jumlah pesan" , jmlh_psn);
                intent.putExtra("stok akhir" , stok_akhir);
                intent.putExtra("harga pesan", hrg_brg);
                intent.putExtra("ppn" , ppn_psn);
                intent.putExtra("bayar" , byr_psn);
                startActivity(intent);
            }
        });

        btnklr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PesanDB.this,MainActivityDB.class);
                startActivity(intent);
            }
        });
    }


}