package com.example.a11202113905_responsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<modelBarang> barangArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    String kd_brg[] = {
            "A1",
            "A2",
            "A3",
            "A4",
            "A5",
            "A6",
            "A7",
            "A8",
            "A9",
            "A10"
    };

    String nm_brg[] = {"Knalpot",
            "Ban",
            "Rem",
            "Tromol",
            "Cakram",
            "Gear",
            "Jok",
            "Stang",
            "Spedometer",
            "Spion"};

    String sat_brg[] = {"per Barang",
            "per Barang",
            "per Barang",
            "per Barang",
            "per Barang",
            "per Barang",
            "per Barang",
            "per Barang",
            "per Barang",
            "per Barang"};

    String hrg_brg[] = {
            "20000",
            "25000",
            "25000",
            "20000",
            "15000",
            "50000",
            "55000",
            "45000",
            "35000",
            "30000"
    };

    int image_brg[] = {R.drawable.knalpot,
            R.drawable.ban,
            R.drawable.rem,
            R.drawable.tromol,
            R.drawable.cakram,
            R.drawable.gear,
            R.drawable.jok,
            R.drawable.stang,
            R.drawable.spedometer,
            R.drawable.spion
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerviewbarang);

        bacadata_barang();
        tampil_listview();
    }


    private void bacadata_barang() {
        for (int i = 0; i < kd_brg.length; i++) {
            barangArrayList.add(new modelBarang(kd_brg[i],
                    nm_brg[i],
                    hrg_brg[i],
                    sat_brg[i],
                    image_brg[i]));
        }
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

    private void tampil_gridview(){
        GridAdapter gridAdapter =new GridAdapter(barangArrayList,this);
        recyclerView.setAdapter(gridAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

    }

    private void tampil_listview(){
        ListAdapter listAdapter=new ListAdapter(barangArrayList,this);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}