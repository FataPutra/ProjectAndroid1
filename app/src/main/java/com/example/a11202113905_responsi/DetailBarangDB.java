package com.example.a11202113905_responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DetailBarangDB extends AppCompatActivity {
    ImageView gambare;
    TextView gambaree,kdbrg,nmbrg,hrgbrg,satbrg,totbrg,stokbrg;
    EditText jmlpesan ;
    Button btnpsnbrg, btnbck;
    DBHelper DB;

    String xkd = "kode";
    String xnm= "nama";
    String xhrg="harga";
    String xsat="satuan";
    String xstok="stok";
//    String xgmbr="gambar";

    int total;
    int ppn;
    int gambarbarang;
    int jumlah_pesan;
    int hrg_brg;
    int hrgpsn=0;
    int htgstok;
    int stokakhir=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang_db);

        kdbrg = findViewById(R.id.kode_barang);
        nmbrg = findViewById(R.id.nama_barang);
        hrgbrg = findViewById(R.id.harga_barang);
        satbrg = findViewById(R.id.satuan_barang);
        stokbrg = findViewById(R.id.stok_barang);
        jmlpesan = (EditText) findViewById(R.id.jumlah_beli);
        totbrg = findViewById(R.id.total_pesan);
        gambare = findViewById(R.id.gambar_barang);
        btnpsnbrg = (Button)  findViewById(R.id.tblpesanmenu);
        btnbck = (Button) findViewById(R.id.tblkembali);

        DB = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();

        xkd = bundle.getString(xkd);
        xnm = bundle.getString(xnm);
        xhrg = bundle.getString(xhrg);
        xsat = bundle.getString(xsat);
        xstok = bundle.getString(xstok);

        byte[] byteArray = bundle.getByteArray("gambar");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


//        gambarbarang = bundle.getInt(String.valueOf(xgmbr));
//        xgmbr = bundle.getString(xgmbr);
//        byte [] encodeByte = Base64.decode(xgmbr,Base64.DEFAULT);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);

//        byte[] byteArr = Base64.decode(xgmbr, 0);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArr, 0, byteArr.length);



        kdbrg.setText(xkd);
        nmbrg.setText(xnm);
        hrgbrg.setText(xhrg);
        satbrg.setText(xsat);
        stokbrg.setText(xstok);
        gambare.setImageBitmap(bmp);

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
                Intent intent = new Intent(DetailBarangDB.this, PesanDB.class);
                if (jmlpesan.getText().toString().isEmpty()){
                    jumlah_pesan =0;
                }else{
                    jumlah_pesan = Integer.parseInt(jmlpesan.getText().toString());
                }
                hrg_brg = Integer.parseInt(hrgbrg.getText().toString());
                hrgpsn = hrg_brg * jumlah_pesan;
                ppn = hrgpsn * 10/100;
                total = hrgpsn + ppn;
                htgstok = Integer.parseInt(stokbrg.getText().toString());
                stokakhir = htgstok-jumlah_pesan;
                String kodeTXTDB2 = xkd;
                String namaTXTDB2 = xnm;
                String satuanTXTDB2 =xsat;
                String hargaTXTDB2 =xhrg;
                String stokTXTDB2 = xstok;
                //String gambarTXTDB2 = xgmbr;
                int gmbr1 = gambarbarang;
                int terjual = jumlah_pesan;
                int sisa = stokakhir;
                String sisa2 = String.valueOf(sisa);

                DB.update_data(new modelBarangDB(kodeTXTDB2,namaTXTDB2,satuanTXTDB2,hargaTXTDB2,sisa2,bmp));

//                Bitmap gambarTxtt=((BitmapDrawable)gambare.getDrawable()).getBitmap();
//                byte[] gambarBytee = Utils.getBytes(gambarTxtt);

//                //DB.update_data(kodeTXTDB2, namaTXTDB2, satuanTXTDB2, hargaTXTDB2, sisa2, gambarBytee);
//                Boolean checkinsertdata  = DB.insertdatapenjualan(kodeTXTDB2, namaTXTDB2, satuanTXTDB2,hargaTXTDB2,stokTXTDB2,gambarBytee,terjual,sisa);
                Boolean checkinsertdata  = DB.insertdatapenjualan(new modelPenjualanDB(bmp,kodeTXTDB2,namaTXTDB2,satuanTXTDB2,hargaTXTDB2,stokTXTDB2,terjual,sisa));
                    if (checkinsertdata == true) {
                        //Data masuk
                    }else{
                        DB.update_data2(new modelPenjualanDB(bmp,kodeTXTDB2,namaTXTDB2,satuanTXTDB2,hargaTXTDB2,stokTXTDB2,terjual,sisa));
                    }
                //DB.insertdatapenjualan(kodeTXTDB2, namaTXTDB2, satuanTXTDB2,hargaTXTDB2,stokTXTDB2,gambarTXTDB2,terjual,sisa);

                intent.putExtra("nama" , xnm);
                intent.putExtra("harga" , xhrg);
                intent.putExtra("jumlah pesan" , Integer.toString(jumlah_pesan));
                intent.putExtra("stok akhir" , Integer.toString(stokakhir));
                intent.putExtra("harga pesan", Integer.toString(hrgpsn));
                intent.putExtra("ppn" , Integer.toString(ppn));
                intent.putExtra("bayar" , Integer.toString(total));
                startActivity(intent);
            }
        });

        btnbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailBarangDB.this,MainActivityDB.class);
                startActivity(intent);
            }
        });
    }

}