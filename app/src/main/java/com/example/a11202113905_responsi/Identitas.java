package com.example.a11202113905_responsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Identitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas);
    }
    public void masuk (View view){
        Intent intent=new Intent(Identitas.this,MainActivityDB.class);
        startActivity(intent);
    }
}