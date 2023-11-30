package com.example.a11202113905_responsi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InputBarang extends AppCompatActivity {
    EditText kode,nama,satuan,harga,stok;
    ImageView gambar;
    Button insert, view, delete , selectimage;
    private Uri imageFilePath;
    private Bitmap imageToStore;
    private static final int PIC_IMAGE_REQUEST = 10;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_barang);

        kode = findViewById(R.id.kodebrg);
        nama = findViewById(R.id.namabrg);
        satuan = findViewById(R.id.satuanbrg);
        harga = findViewById(R.id.hargabrg);
        stok = findViewById(R.id.stokbrg);
        gambar = findViewById(R.id.gambarbrg);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);
        selectimage = findViewById(R.id.buttonselectimage);

        DB = new DBHelper(this);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputBarang.this, MainActivityDB.class);
                startActivity(intent);
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String kodeTXT = kode.getText().toString();
//                String namaTXT = nama.getText().toString();
//                String satuanTXT =satuan.getText().toString();
//                String hargaTXT =harga.getText().toString();
//                String stokTXT = stok.getText().toString();
//                Bitmap gambarTxt=((BitmapDrawable)gambar.getDrawable()).getBitmap();
//                byte[] gambarByte = Utils.getBytes(gambarTxt);

//                Boolean checkinsertdata  = DB.insertdatabarang(kodeTXT, namaTXT, satuanTXT,hargaTXT,stokTXT,gambarByte);
                Boolean checkinsertdata = DB.insertdatabarang(new modelBarangDB(kode.getText().toString(), nama.getText().toString(), satuan.getText().toString(), harga.getText().toString(), stok.getText().toString(), imageToStore));
                if (checkinsertdata == true) {
                    Toast.makeText(InputBarang.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InputBarang.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kodeTXT = kode.getText().toString();

                Boolean checkdeletedata = DB.deletedatabarang(kodeTXT);
                if (checkdeletedata == true) {
                    Toast.makeText(InputBarang.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InputBarang.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });

        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent objectIntent = new Intent();
                    objectIntent.setType("image/*");
                    objectIntent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(objectIntent, PIC_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PIC_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);
                gambar.setImageBitmap(imageToStore);
            }
        }catch (Exception e){
            Toast.makeText(this, "onActivityResult" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }




}