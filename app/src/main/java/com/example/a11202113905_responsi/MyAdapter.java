package com.example.a11202113905_responsi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
//    private ArrayList kode_id, barang_id, satuan_id , harga_id, stok_id , gambar_id;
    ArrayList<modelBarangDB> objectModelClassList;
//    private ActivityResultLauncher<Intent> resultLauncher;

    public MyAdapter(Context context , ArrayList<modelBarangDB> objectModelClassList) {
        this.objectModelClassList = objectModelClassList;
        this.context = context;
//        this.resultLauncher = resultLauncher;

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
        View v = LayoutInflater.from(context).inflate(R.layout.format_barang_list,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        modelBarangDB objectModelClass = objectModelClassList.get(position);
        holder.kode_id.setText(objectModelClass.kode_barang);
        holder.barang_id.setText(objectModelClass.nama_barang);
        holder.satuan_id.setText(objectModelClass.satuan_barang);
        holder.harga_id.setText(objectModelClass.harga_barang);
        holder.stok_id.setText(objectModelClass.stok_barang);
        holder.gambar_id.setImageBitmap(objectModelClass.gambar_barang);


//        holder.kode_id.setText(String.valueOf(kode_id.get(position)));
//        holder.barang_id.setText(String.valueOf(barang_id.get(position)));
//        holder.satuan_id.setText(String.valueOf(satuan_id.get(position)));
//        holder.harga_id.setText(String.valueOf(harga_id.get(position)));
//        holder.stok_id.setText(String.valueOf(stok_id.get(position)));


        //holder.gambar_id.setText(String.valueOf(gambar_id.get(position)));

//        holder.gambar_id.setImageResource((Integer) gambar_id.get(position));
        holder.Relatiview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, "Anda Pilih \t" + arrayList.get(position).nama_menu,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(view.getContext(),DetailBarangDB.class);
                modelBarangDB objectModelClass = objectModelClassList.get(position);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                objectModelClass.gambar_barang.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                intent.putExtra("kode",objectModelClass.kode_barang);
                intent.putExtra("nama",objectModelClass.nama_barang);
                intent.putExtra("satuan",objectModelClass.satuan_barang);
                intent.putExtra("harga",objectModelClass.harga_barang);
                intent.putExtra("stok",objectModelClass.stok_barang);

//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                objectModelClass.gambar_barang.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//                byte[] byteArray = stream.toByteArray();
//                String result = Base64.encodeToString(byteArray, Base64.DEFAULT);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(Base64.decode(String.valueOf(objectModelClass.gambar_barang), Base64.DEFAULT), 0, Base64.decode(String.valueOf(objectModelClass.gambar_barang), Base64.DEFAULT).length);
                intent.putExtra("gambar",byteArray);
                //intent.putExtra("jmlpesan",)
                view.getContext().startActivity(intent);
//                resultLauncher.launch(intent);
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
            Relatiview=itemView.findViewById(R.id.relatif01);
        }
    }
}

