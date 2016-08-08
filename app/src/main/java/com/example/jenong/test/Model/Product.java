package com.example.jenong.test.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable
{
    public String id;
    public String rating;
    public String nama;
    public String jenis;
    public String harga;
    public String diskon;
    public String stok;
    public String url_foto;

    protected Product(Parcel in) {
        id = in.readString();
        rating = in.readString();
        nama = in.readString();
        jenis = in.readString();
        harga = in.readString();
        diskon = in.readString();
        stok = in.readString();
        url_foto = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDiskon() {
        return diskon;
    }

    public void setDiskon(String diskon) {
        this.diskon = diskon;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(rating);
        parcel.writeString(nama);
        parcel.writeString(jenis);
        parcel.writeString(harga);
        parcel.writeString(diskon);
        parcel.writeString(stok);
        parcel.writeString(url_foto);
    }
}