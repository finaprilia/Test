package com.example.jenong.test.Model;

import java.util.List;

/**
 * Created by jenong on 01/08/2016.
 */
public class DATADETAIL {
    public String nama;
    public String harga;
    public String diskon;
    public String deskripsi;
    public Object spesifikasi;
    public List<Ukuran> ukuran;

    public List<Ukuran> getUkuran() {
        return ukuran;
    }

    public void setUkuran(List<Ukuran> ukuran) {
        this.ukuran = ukuran;
    }

    public Object getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(Object spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


}
