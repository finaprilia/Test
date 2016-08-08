package com.example.jenong.test.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jenong.test.Configure.DetailActivityConfigure;
import com.example.jenong.test.Interface.DetailActivityInput;
import com.example.jenong.test.Interface.DetailActivityOutput;
import com.example.jenong.test.Model.DATADETAIL;
import com.example.jenong.test.Model.DetailActivityModel;
import com.example.jenong.test.Model.Product;
import com.example.jenong.test.Model.Ukuran;
import com.example.jenong.test.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity implements DetailActivityOutput {

    public DetailActivityInput input;
    @InjectView(R.id.imageDetail)
    ImageView imageDetail;
    @InjectView(R.id.namaBarang)
    TextView namaBarang;
    @InjectView(R.id.diskonDetail)
    TextView diskonDetail;
    @InjectView(R.id.hargaAsli)
    TextView hargaAsli;
    @InjectView(R.id.stock)
    TextView stock;
    @InjectView(R.id.orenDeskripsi)
    RelativeLayout orenDeskripsi;
    @InjectView(R.id.deskripsi)
    TextView deskripsi;
    @InjectView(R.id.putihDeskripsi)
    LinearLayout putihDeskripsi;
    @InjectView(R.id.orenSpesifikasi)
    RelativeLayout orenSpesifikasi;
    @InjectView(R.id.txtSpesifikasi)
    TextView txtSpesifikasi;
    @InjectView(R.id.putihSpesifikasi)
    LinearLayout putihSpesifikasi;
    @InjectView(R.id.orenSize)
    RelativeLayout orenSize;
    @InjectView(R.id.putihSize)
    LinearLayout putihSize;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.klikOrenDes)
    ImageView klikOrenDes;
    @InjectView(R.id.klikOrenSpek)
    ImageView klikOrenSpek;
    @InjectView(R.id.klikOrenUku)
    ImageView klikOrenUku;


    private Product data;
    public boolean tampil;
    private String TAG = DetailActivity.class.getSimpleName();
    public final static String KEY_MEMBER = "keymember";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaill);
        ButterKnife.inject(this);
        DetailActivityConfigure.getInstance().config(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (getIntent().hasExtra(KEY_MEMBER)) {
            data = (Product) getIntent().getParcelableExtra(KEY_MEMBER);
            Log.e(TAG, "AAAAAAAAAAAAAAAAAAA : " + data.getUrl_foto());
            Log.e(TAG, "AAAAAAAAAAAAAAAAAAAAA:" + data.getId());
        } else {
            Toast.makeText(getApplicationContext(), "Maaf data tidak ditemukan", Toast.LENGTH_SHORT).show();
        }


        getSupportActionBar().setTitle(data.getNama());
        Picasso.with(getApplicationContext()).load(data.getUrl_foto()).into(imageDetail);
        stock.setText(data.getStok());

        input.makeJsonDetail(data.getId());


        doSomething();
    }

    private void doSomething() {
        input.doSomething("this", "input");
    }

    @Override
    public void displaySomething(DetailActivityModel response) {
        Log.d("RESULT", "RESULT");
    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this, "gabisa", Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayDetail(DATADETAIL dataDetail) {
        Log.e(TAG, "AAAAAAAAAAAAAAA: " + dataDetail.getNama());
        Log.e(TAG, "AAAAAAAAAAAAAAA: " + dataDetail.getDiskon());
        Log.e(TAG, "AAAAAAAAAAAAAAA: " + dataDetail.getHarga());
        Log.e(TAG, "AAAAAAAAAAAAAAA: " + dataDetail.getDeskripsi());
        Log.e(TAG, "AAAAAAAAAAAAAAA: " + dataDetail.getSpesifikasi());
        namaBarang.setText(dataDetail.getNama());
        diskonDetail.setText(dataDetail.getDiskon());
        hargaAsli.setText(dataDetail.getHarga());
        deskripsi.setText(dataDetail.getDeskripsi());
        if (data.getId().equals("2") || data.getId().equals("6")) {
            orenSpesifikasi.setVisibility(View.VISIBLE);
            txtSpesifikasi.setText(dataDetail.getSpesifikasi().toString());
        } else {
            orenSize.setVisibility(View.VISIBLE);
            for (Ukuran r : dataDetail.getUkuran()) {
                View v = getLayoutInflater().inflate(R.layout.itemsizes, putihSize, false);
                TextView t = ButterKnife.findById(v, R.id.txtSizes);
                t.setText(r.getAvailable());
                putihSize.addView(v);
            }
        }


    }

    @OnClick({R.id.orenSpesifikasi, R.id.orenSize, R.id.orenDeskripsi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.orenSpesifikasi:
                if (!tampil) {
                    tampil = true;
                    klikOrenSpek.setBackgroundResource(R.drawable.atas);
                    putihSpesifikasi.setVisibility(View.VISIBLE);
                } else {
                    tampil = false;
                    klikOrenSpek.setBackgroundResource(R.drawable.bawah);
                    putihSpesifikasi.setVisibility(View.GONE);
                }
                break;
            case R.id.orenSize:
                if (!tampil) {
                    tampil = true;
                    klikOrenUku.setBackgroundResource(R.drawable.atas);
                    putihSize.setVisibility(View.VISIBLE);
                } else {
                    tampil = false;
                    klikOrenUku.setBackgroundResource(R.drawable.bawah);
                    putihSize.setVisibility(View.GONE);
                }
                break;
            case R.id.orenDeskripsi:
                if (!tampil) {
                    tampil = true;
                    klikOrenDes.setBackgroundResource(R.drawable.bawah);
                    putihDeskripsi.setVisibility(View.GONE);
                } else {
                    tampil = false;
                    klikOrenDes.setBackgroundResource(R.drawable.atas);
                    putihDeskripsi.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, UtamaActivity.class));
            return true;
        } else {

        }
        return super.onOptionsItemSelected(item);
    }
}
