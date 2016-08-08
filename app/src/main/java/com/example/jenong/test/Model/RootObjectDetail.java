package com.example.jenong.test.Model;

/**
 * Created by jenong on 02/08/2016.
 */
public class RootObjectDetail {
    public boolean STATUS;
    public int STATUS_CODE;
    public MESSAGE MESSAGE;

    public DATADETAIL getDATA() {
        return DATA;
    }

    public void setDATA(DATADETAIL DATA) {
        this.DATA = DATA;
    }

    public DATADETAIL DATA;



    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public int getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public void setSTATUS_CODE(int STATUS_CODE) {
        this.STATUS_CODE = STATUS_CODE;
    }

    public com.example.jenong.test.Model.MESSAGE getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(com.example.jenong.test.Model.MESSAGE MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

}
