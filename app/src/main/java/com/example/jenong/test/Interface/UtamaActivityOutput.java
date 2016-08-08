package com.example.jenong.test.Interface;

import com.example.jenong.test.Model.DATA;
import com.example.jenong.test.Model.RootObject;
import com.example.jenong.test.Model.UtamaActivityModel;

/**
 * Created by gits on VIP
 * Output For Response Processs
 */
public interface UtamaActivityOutput {
    void displaySomething(UtamaActivityModel response);
    void displayError(String error);
    void displayUtama(DATA data);
//    void displayFilter(DATA dataFilter);
}