package com.example.a11202113905_responsi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    public final static String nama_db="DB.UTS";
    public final static String nama_table1 = "Sparepart";
    public final static String nama_table2 = "Penjualan";
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageInByte;

    public DBHelper(Context context) {
        super(context, nama_db, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table " +nama_table1+ "(kode TEXT primary key, nama TEXT, satuan TEXT ,harga TEXT,stok TEXT , gambar BLOB)");
        DB.execSQL("create table " +nama_table2+ "(gambar BLOB , kode TEXT primary key, nama TEXT, satuan TEXT ,harga TEXT,stok TEXT , terjual  INT , sisa INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Sparepart");
        DB.execSQL("drop Table if exists Penjualan");
        onCreate(DB);
    }

//    public Boolean insertdatabarang(String kode, String nama, String satuan, String harga, String stok, byte[] gambar) {
//        try {
//            SQLiteDatabase DB = this.getWritableDatabase();
//            SQLiteDatabase objectSQLiteDatabase = this.getReadableDatabase();
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("kode", kode);
//            contentValues.put("nama", nama);
//            contentValues.put("satuan", satuan);
//            contentValues.put("harga", harga);
//            contentValues.put("stok", stok);
//            contentValues.put("gambar", gambar);
//            long result = DB.insert("Sparepart", null, contentValues);
//            if (result == -1) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//    }

    public Boolean insertdatabarang(modelBarangDB objectBarangDB) {
            SQLiteDatabase DB = this.getWritableDatabase();
            Bitmap imageToStoreBitmap = objectBarangDB.getGambar_barang();

            objectByteArrayOutputStream = new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100,objectByteArrayOutputStream);

            imageInByte=objectByteArrayOutputStream.toByteArray();
            ContentValues objectContentValues = new ContentValues();

            objectContentValues.put("kode", objectBarangDB.getKode_barang());
            objectContentValues.put("nama", objectBarangDB.getNama_barang());
            objectContentValues.put("satuan", objectBarangDB.getSatuan_barang());
            objectContentValues.put("harga", objectBarangDB.getHarga_barang());
            objectContentValues.put("stok", objectBarangDB.getStok_barang());
            objectContentValues.put("gambar", imageInByte);
            long result = DB.insert("Sparepart", null, objectContentValues);
            if (result == -1) {
                return false;
            } else {
                return true;
            }
    }


    public Boolean insertdatapenjualan(modelPenjualanDB objectPenjualan)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Bitmap imageToStoreBitmap = objectPenjualan.getGambar_barang();

        objectByteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100,objectByteArrayOutputStream);

        imageInByte=objectByteArrayOutputStream.toByteArray();
        ContentValues objectContentValues = new ContentValues();

        objectContentValues.put("gambar", imageInByte);
        objectContentValues.put("kode", objectPenjualan.getKode_barang());
        objectContentValues.put("nama", objectPenjualan.getNama_barang());
        objectContentValues.put("satuan", objectPenjualan.getSatuan_barang());
        objectContentValues.put("harga", objectPenjualan.getHarga_barang());
        objectContentValues.put("stok", objectPenjualan.getStok_barang());
        objectContentValues.put("terjual", objectPenjualan.getTerjual());
        objectContentValues.put("sisa", objectPenjualan.getSisa());

        long result = DB.insert("Penjualan", null, objectContentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select * from Sparepart", null);
        return cursor;
    }

    public Cursor getdata2()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor2  = DB.rawQuery("Select * from Penjualan", null);
        return cursor2;
    }

    public void update_data(modelBarangDB objectBarangDB){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Bitmap imageToStoreBitmap = objectBarangDB.getGambar_barang();

        objectByteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100,objectByteArrayOutputStream);

        imageInByte=objectByteArrayOutputStream.toByteArray();
        ContentValues objectContentValues = new ContentValues();

        objectContentValues.put("kode", objectBarangDB.getKode_barang());
        objectContentValues.put("nama", objectBarangDB.getNama_barang());
        objectContentValues.put("satuan", objectBarangDB.getSatuan_barang());
        objectContentValues.put("harga", objectBarangDB.getHarga_barang());
        objectContentValues.put("stok", objectBarangDB.getStok_barang());
        objectContentValues.put("gambar", imageInByte);

        db.update(nama_table1,objectContentValues,"kode=?",new String[] {objectBarangDB.getKode_barang()});
    }

    public void update_data2(modelPenjualanDB objectPenjualan){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Bitmap imageToStoreBitmap = objectPenjualan.getGambar_barang();

        objectByteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100,objectByteArrayOutputStream);

        imageInByte=objectByteArrayOutputStream.toByteArray();
        ContentValues objectContentValues = new ContentValues();
        objectContentValues.put("gambar", imageInByte);
        objectContentValues.put("kode", objectPenjualan.getKode_barang());
        objectContentValues.put("nama", objectPenjualan.getNama_barang());
        objectContentValues.put("satuan", objectPenjualan.getSatuan_barang());
        objectContentValues.put("harga", objectPenjualan.getHarga_barang());
        objectContentValues.put("stok", objectPenjualan.getStok_barang());
        objectContentValues.put("terjual", objectPenjualan.getTerjual());
        objectContentValues.put("sisa", objectPenjualan.getSisa());

        db.update(nama_table2,objectContentValues,"kode=?",new String[] {objectPenjualan.getKode_barang()});

    }

    public Boolean deletedatabarang(String kode)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Sparepart where kode = ?", new String[]{kode});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("Sparepart", "kode=?", new String[]{kode});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    public ArrayList<modelBarangDB> getAllImageData(){

        try{
            SQLiteDatabase objectSQLiteDatabase = this.getReadableDatabase();
            ArrayList<modelBarangDB> objectModelClassList = new ArrayList<>();
            Cursor objectCursor = objectSQLiteDatabase.rawQuery("select * from Sparepart",null);
            if (objectCursor.getCount()!=0){
                while(objectCursor.moveToNext()){
                    String kode = objectCursor.getString(0);
                    String nama = objectCursor.getString(1);
                    String satuan = objectCursor.getString(2);
                    String harga = objectCursor.getString(3);
                    String stok = objectCursor.getString(4);

                    byte [] imageBytes = objectCursor.getBlob(5);
                    Bitmap objectBitMap = BitmapFactory.decodeByteArray(imageBytes,0, imageBytes.length);
                    objectModelClassList.add(new modelBarangDB(kode,nama,satuan,harga,stok,objectBitMap));
                }
                return objectModelClassList;
            }
            else{
                Toast.makeText(context, "No Value Exit in Database", Toast.LENGTH_SHORT).show();
                return objectModelClassList;
            }
        }
        catch (Exception e){
            Toast.makeText(context, "getAllImageData" + e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }

    }

}