package com.example.jenong.test.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jenong.test.Model.Product;
import com.example.jenong.test.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.R.layout.activity_list_item;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RootObjectViewHolder> {


    private List<Product> ResultList;
    private Product product;
    public OnClickItem itemClick;
    Context c;

    public MyAdapter(OnClickItem itemClick) {
        this.itemClick = itemClick;
        ResultList = new ArrayList<>();
    }

    public interface OnClickItem {
        public void OnClick(Product result);
    }

    public MyAdapter() {
        ResultList = new ArrayList<>();
    }
//    private void add(RootObject item) {
//        ResultList.add(item);
//        notifyItemInserted(ResultList.size() - 1);
//    }

    public void addAll(List<Product> r) {
        //  ResultList.removeAll(r);
        ResultList.addAll(r);
    }


    public void removeAll(List<Product> r) {
        ResultList.clear();
//        ResultList.removeAll(r);
    }

    public Product getItem(int position) {
        return ResultList.get(position);
    }

    @Override
    public RootObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        RootObjectViewHolder rootObjectViewHolder = new RootObjectViewHolder(view);
        c = parent.getContext();
        return rootObjectViewHolder;
    }

    @Override
    public void onBindViewHolder(RootObjectViewHolder holder, int position) {
        final Product object = ResultList.get(position);
        Picasso.with(c).load(object.getUrl_foto()).into(holder.imageProduk);
        holder.namaProduk.setText(object.getNama());
        holder.banyakDiskon.setText(object.getDiskon());
        holder.harga.setText(object.getHarga());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(c, DetailActivity.class);
                pindah.putExtra(DetailActivity.KEY_MEMBER, object);
                c.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ResultList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    static class RootObjectViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.imageProduk)
        ImageView imageProduk;
        @InjectView(R.id.namaProduk)
        TextView namaProduk;
        @InjectView(R.id.banyakDiskon)
        TextView banyakDiskon;
        @InjectView(R.id.harga)
        TextView harga;
        View v;

        public RootObjectViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            ButterKnife.inject(this, itemView);
        }
    }

    public void sortByLowHigh() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                Double p = Double.parseDouble(product.getHarga());
                Double t = Double.parseDouble(t1.getHarga());
                return Double.compare(p, t);
            }
        };
        Collections.sort(ResultList, comparator);
        notifyDataSetChanged();
    }

    public void sortByHighLow() {
        Comparator<Product> compa = new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
                Double p = Double.parseDouble(product.getHarga());
                Double t = Double.parseDouble(t1.getHarga());
                return Double.compare(t, p);
            }
        };
        Collections.sort(ResultList, compa);
        notifyDataSetChanged();
    }

    public void filters(int filter, String id) {
        if (filter != 0) {
            List<Product> dataFilter = new ArrayList<>();
            for (int i = 0; i < ResultList.size(); i++) {
                if (TextUtils.equals(ResultList.get(i).jenis, id)) {
                    dataFilter.add(ResultList.get(i));
                }
            }
            notifyDataSetChanged();
        }

//    public void filterShirt(){
//        int s = Integer.parseInt(product.getId());
//        for (Product c : ResultList) {
//            if (c.getId() <= points) {
//                add(c);
//            }
//    }

//    public void filterShirt(){
//        List<Product> courseList = new ArrayList<Product>((Collection<? extends Product>) Arrays.asList(ResultList));
//        final ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this, activity_list_item, courseList);
//
//// this code inside the Button's onClick
//        int points = Integer.parseInt(editText.getText().toString());
//        for (Course c : courses) {
//            if (c.getPoints() <= points) {
//                adapter.add(c);
//            }
//        }
//    }
    }
}