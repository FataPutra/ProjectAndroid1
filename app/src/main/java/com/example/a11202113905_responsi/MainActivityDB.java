package com.example.a11202113905_responsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Blob;
import java.util.ArrayList;

public class MainActivityDB extends AppCompatActivity {
    RecyclerView recyclerView;
//    ArrayList<String> kode,barang,satuan,harga,stok,gambar;
    DBHelper DB;
    MyAdapter adapter;
    Button btntambah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_db);
        btntambah=findViewById(R.id.btnTambah);

        DB = new DBHelper(this);
//        kode = new ArrayList<>();
//        barang = new ArrayList<>();
//        satuan = new ArrayList<>();
//        harga = new ArrayList<>();
//        stok = new ArrayList<>();
//        gambar = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);

        tampil_listview();

       // displaydata();



        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityDB.this,InputBarang.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menupil,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item1){
            //Toast.makeText(this, "Anda memilih List View", Toast.LENGTH_SHORT).show();
            tampil_listview();
        }else{
            //Toast.makeText(this,"Anda memilih Grid View", Toast.LENGTH_SHORT).show();
            tampil_gridview();
        }

        return super.onOptionsItemSelected(item);
    }

    private void tampil_gridview() {
        GridAdapterDB gridAdapterDB = new GridAdapterDB(this,DB.getAllImageData());
        recyclerView.setAdapter(gridAdapterDB);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }


    private void tampil_listview() {
        adapter = new MyAdapter(this,DB.getAllImageData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


//    private void displaydata() {
//        Cursor cursor = DB.getdata();
//        if (cursor.getCount() == 0) {
//            Toast.makeText(MainActivityDB.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            while (cursor.moveToNext()) {
//                kode.add(cursor.getString(0));
//                barang.add(cursor.getString(1));
//                satuan.add(cursor.getString(2));
//                harga.add(cursor.getString(3));
//                stok.add(cursor.getString(4));
//                gambar.add(cursor.getString(5));
//            }
//        }
    }




//    private void displaydata2() {
//        Cursor cursor2 = DB.getdata2();
//        if(cursor2.getCount()==0)
//        {
//            Toast.makeText(MainActivityDB.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else {
//            while (cursor2.moveToNext()) {
//                kode.add(cursor2.getString(0));
//                barang.add(cursor2.getString(1));
//                satuan.add(cursor2.getString(2));
//                harga.add(cursor2.getString(3));
//                stok.add(String.valueOf(cursor2.getInt(7)));
//                gambar.add(cursor2.getString(5));
//            }
//        }
    //}

//}