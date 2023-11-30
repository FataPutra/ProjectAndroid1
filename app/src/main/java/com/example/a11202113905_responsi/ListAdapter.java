package com.example.a11202113905_responsi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.myViewHolder> {

    ArrayList<modelBarang> arrayList;
    Context context;

    public ListAdapter(ArrayList<modelBarang> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_barang,parent,false);
        return new ListAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.ckodebarang.setText(arrayList.get(position).kode_barang);
        holder.cnamabarang.setText(arrayList.get(position).nama_barang);
        holder.chargabarang.setText(arrayList.get(position).harga_barang);
        holder.csatuanbarang.setText(arrayList.get(position).satuan_barang);
        holder.cgambarbarang.setImageResource(arrayList.get(position).gambar_barang);
        holder.Relatiview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, "Anda Pilih \t" + arrayList.get(position).nama_menu,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(view.getContext(),MainActivity2.class);
                intent.putExtra("kode",arrayList.get(position).kode_barang);
                intent.putExtra("nama",arrayList.get(position).nama_barang);
                intent.putExtra("harga",arrayList.get(position).harga_barang);
                intent.putExtra("satuan",arrayList.get(position).satuan_barang);
                intent.putExtra("gambar",arrayList.get(position).gambar_barang);
                //intent.putExtra("jmlpesan",)
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView ckodebarang,cnamabarang,csatuanbarang,chargabarang;
        ImageView cgambarbarang;

        RelativeLayout Relatiview;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            ckodebarang=itemView.findViewById(R.id.kodebarang);
            cnamabarang=itemView.findViewById(R.id.namabarang);
            csatuanbarang=itemView.findViewById(R.id.satuanbarang);
            chargabarang=itemView.findViewById(R.id.hargabarang);
            cgambarbarang=itemView.findViewById(R.id.gambarbarang);
            Relatiview=itemView.findViewById(R.id.relatif01);
        }
    }
}
