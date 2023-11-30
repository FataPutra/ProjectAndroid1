package com.example.a11202113905_responsi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class GridAdapterDB extends RecyclerView.Adapter<GridAdapterDB.MyViewHolder> {
    Context context;
//    private ArrayList kode_id, barang_id, satuan_id , harga_id, stok_id , gambar_id;
    ArrayList<modelBarangDB> objectModelClassList;

    public GridAdapterDB(Context context, ArrayList<modelBarangDB> objectModelClassList) {
        this.context = context;
        this.objectModelClassList = objectModelClassList;

//        this.kode_id = kode_id;
//        this.barang_id=barang_id;
//        this.satuan_id = satuan_id;
//        this.harga_id = harga_id;
//        this.stok_id=stok_id;
//        this.gambar_id=gambar_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.format_barang_grid,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        modelBarangDB objectModelClass = objectModelClassList.get(position);
        holder.kode_id.setText(objectModelClass.getKode_barang());
        holder.barang_id.setText(objectModelClass.getNama_barang());
        holder.satuan_id.setText(objectModelClass.getSatuan_barang());
        holder.harga_id.setText(objectModelClass.getHarga_barang());
        holder.stok_id.setText(objectModelClass.getStok_barang());
        holder.gambar_id.setImageBitmap(objectModelClass.getGambar_barang());

//        holder.kode_id.setText(String.valueOf(kode_id.get(position)));
//        holder.barang_id.setText(String.valueOf(barang_id.get(position)));
//        holder.satuan_id.setText(String.valueOf(satuan_id.get(position)));
//        holder.harga_id.setText(String.valueOf(harga_id.get(position)));
//        holder.stok_id.setText(String.valueOf(stok_id.get(position)));
//        //holder.gambar_id.setText(String.valueOf(gambar_id.get(position)));
//        holder.gambar_id.setImageResource((Integer) gambar_id.get(position));
        holder.Relatiview.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            // Toast.makeText(context, "Anda Pilih \t" + arrayList.get(position).nama_menu,Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(view.getContext(),DetailBarangDB.class);
            modelBarangDB objectModelClass = objectModelClassList.get(position);
            intent.putExtra("kode",(objectModelClass.getKode_barang()));
            intent.putExtra("nama",(objectModelClass.getNama_barang()));
            intent.putExtra("satuan",(objectModelClass.getSatuan_barang()));
            intent.putExtra("harga",(objectModelClass.getHarga_barang()));
            intent.putExtra("stok",(objectModelClass.getStok_barang()));
//            intent.putExtra("gambar",(objectModelClass.getGambar_barang()));


            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            objectModelClass.gambar_barang.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra("gambar",byteArray);

//            intent.putExtra("kode",(String.valueOf(kode_id.get(position))));
//            intent.putExtra("nama",(String.valueOf(barang_id.get(position))));
//            intent.putExtra("satuan",(String.valueOf(satuan_id.get(position))));
//            intent.putExtra("harga",(String.valueOf(harga_id.get(position))));
//            intent.putExtra("stok",(String.valueOf(stok_id.get(position))));
//            intent.putExtra("gambar",(String.valueOf(gambar_id.get(position))));
            //intent.putExtra("jmlpesan",)

            view.getContext().startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return objectModelClassList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView kode_id, barang_id, satuan_id,harga_id,stok_id, gambar_idd ;
        ImageView gambar_id;
        RelativeLayout Relatiview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            kode_id = itemView.findViewById(R.id.kodebarang);
            barang_id = itemView.findViewById(R.id.namabarang);
            satuan_id = itemView.findViewById(R.id.satuanbarang);
            harga_id = itemView.findViewById(R.id.hargabarang);
            stok_id = itemView.findViewById(R.id.stokbarang);
            gambar_id = itemView.findViewById(R.id.gambarbarang);
            Relatiview=itemView.findViewById(R.id.relatif02);

        }
    }
}

