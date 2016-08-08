package com.example.jenong.test.View;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jenong.test.Configure.UtamaActivityConfigure;
import com.example.jenong.test.Interface.UtamaActivityInput;
import com.example.jenong.test.Interface.UtamaActivityOutput;
import com.example.jenong.test.Model.DATA;
import com.example.jenong.test.Model.UtamaActivityModel;
import com.example.jenong.test.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class UtamaActivity extends AppCompatActivity implements UtamaActivityOutput {

    public UtamaActivityInput input;
    @InjectView(R.id.btnSort)
    Button btnSort;
    @InjectView(R.id.btnFilter)
    Button btnFilter;
    @InjectView(R.id.rec)
    RecyclerView rec;


    private MyAdapter adapter = new MyAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
        ButterKnife.inject(this);
        UtamaActivityConfigure.getInstance().config(this);

        rec.setLayoutManager(new GridLayoutManager(UtamaActivity.this, 2));
        rec.setAdapter(adapter);

        input.makeJsonSatu();

        doSomething();
    }

    private void doSomething() {
        input.doSomething("this", "input");
    }

    @Override
    public void displaySomething(UtamaActivityModel response) {
        Log.d("RESULT", "RESULT");
    }

    @OnClick({R.id.btnSort, R.id.btnFilter})
    public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnSort:
                        final AlertDialog.Builder builder = new AlertDialog.Builder(UtamaActivity.this);
                        builder.setTitle("Sort")
                                .setItems(R.array.sort, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        switch (i) {
                                            case 0:
                                                input.makeJsonSatu();
                                                break;
                                            case 1:
                                                adapter.sortByLowHigh();
                                                break;
                                            case 2:
                                                adapter.sortByHighLow();

                                        }
                                    }
                                });
                        builder.show();
                        break;
                    case R.id.btnFilter:
                        final AlertDialog.Builder build = new AlertDialog.Builder(UtamaActivity.this);
                        build.setTitle("Filter")
                                .setItems(R.array.filter, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        switch (i) {
                                            case 0:
                                                input.makeJsonSatu();
                                                break;

                                        }
                                    }
                                });
                        build.show();
                        break;
                }

    }

    @Override
    public void displayError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayUtama(DATA data) {
        adapter.removeAll(data.getProducts());
        adapter.addAll(data.getProducts());
        adapter.notifyDataSetChanged();
    }

}

