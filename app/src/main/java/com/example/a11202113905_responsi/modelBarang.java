package com.example.a11202113905_responsi;

public class modelBarang {
    String kode_barang;
    String nama_barang;
    String harga_barang;
    String satuan_barang;
    int gambar_barang;

    public modelBarang(String kode_barang, String nama_barang, String harga_barang, String satuan_barang, int gambar_barang) {
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
        this.satuan_barang = satuan_barang;
        this.gambar_barang = gambar_barang;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(String harga_barang) {
        this.harga_barang = harga_barang;
    }

    public String getSatuan_barang() {
        return satuan_barang;
    }

    public void setSatuan_barang(String satuan_barang) {
        this.satuan_barang = satuan_barang;
    }

    public int getGambar_barang() {
        return gambar_barang;
    }

    public void setGambar_barang(int gambar_barang) {
        this.gambar_barang = gambar_barang;
    }

}
