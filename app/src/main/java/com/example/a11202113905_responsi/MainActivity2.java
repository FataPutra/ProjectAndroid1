package com.example.a11202113905_responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView gambare;
    TextView kdbrg,nmbrg,hrgbrg,satbrg,totbrg;
    EditText jmlpesan ;
    Button btnpsnbrg, btnbck;

    String xkd = "kode";
    String xnm= "nama";
    String xhrg="harga";
    String xsat="satuan";

    int total;
    int ppn;
    int gambarbarang;
    int jumlah_pesan;
    int hrg_brg;
    int hrgpsn=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        kdbrg = findViewById(R.id.kode_barang);
        nmbrg = findViewById(R.id.nama_barang);
        hrgbrg = findViewById(R.id.harga_barang);
        satbrg = findViewById(R.id.satuan_barang);
        jmlpesan = (EditText) findViewById(R.id.jumlah_beli);
        totbrg = findViewById(R.id.total_pesan);
        gambare = findViewById(R.id.gambar_barang);
        btnpsnbrg = (Button)  findViewById(R.id.tblpesanmenu);
        btnbck = (Button) findViewById(R.id.tblkembali);


        Bundle bundle = getIntent().getExtras();

        xkd = bundle.getString(xkd);
        xnm = bundle.getString(xnm);
        xhrg = bundle.getString(xhrg);
        xsat = bundle.getString(xsat);
        gambarbarang = bundle.getInt(String.valueOf("gambar"));

        kdbrg.setText(xkd);
        nmbrg.setText(xnm);
        hrgbrg.setText(xhrg);
        satbrg.setText(xsat);
        gambare.setImageResource(gambarbarang);

        jmlpesan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (jmlpesan.getText().toString().isEmpty()){
                    jumlah_pesan =0;
                }else{
                    jumlah_pesan = Integer.parseInt(jmlpesan.getText().toString());
                }
                hrg_brg = Integer.parseInt(hrgbrg.getText().toString());
                hrgpsn = hrg_brg * jumlah_pesan;
                totbrg.setText(Integer.toString(hrgpsn));
            }
        });

        btnpsnbrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, Pesan.class);
                if (jmlpesan.getText().toString().isEmpty()){
                    jumlah_pesan =0;
                }else{
                    jumlah_pesan = Integer.parseInt(jmlpesan.getText().toString());
                }
                hrg_brg = Integer.parseInt(hrgbrg.getText().toString());
                hrgpsn = hrg_brg * jumlah_pesan;
                ppn = hrgpsn * 10/100;
                total = hrgpsn + ppn;
                intent.putExtra("nama" , xnm);
                intent.putExtra("harga" , xhrg);
                intent.putExtra("jumlah pesan" , Integer.toString(jumlah_pesan));
                intent.putExtra("harga pesan", Integer.toString(hrgpsn));
                intent.putExtra("ppn" , Integer.toString(ppn));
                intent.putExtra("bayar" , Integer.toString(total));
                startActivity(intent);
            }
        });

        btnbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}