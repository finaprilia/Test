package com.example.jenong.test.Model;

import java.util.List;

public class DATA {
    public List<Filter> filter;

    public List<Filter> getFilter() {
        return filter;
    }

    public void setFilter(List<Filter> filter) {
        this.filter = filter;
    }

    public List<Product> getProducts() {

        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> products;
}