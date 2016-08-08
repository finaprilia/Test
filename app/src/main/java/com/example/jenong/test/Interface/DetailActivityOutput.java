package com.example.jenong.test.Interface;

import com.example.jenong.test.Model.DATADETAIL;
import com.example.jenong.test.Model.DetailActivityModel;
import com.example.jenong.test.Model.RootObjectDetail;
import com.example.jenong.test.Model.Ukuran;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface DetailActivityOutput {
    void displaySomething(DetailActivityModel response);
    void displayError(String error);
    void displayDetail(DATADETAIL dataDetail);


}