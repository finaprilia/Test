package com.example.jenong.test.Model;

public class RootObject
{
    public boolean STATUS;
    public int STATUS_CODE;
    public MESSAGE MESSAGE;
    public DATA DATA;

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

    public com.example.jenong.test.Model.DATA getDATA() {
        return DATA;
    }

    public void setDATA(com.example.jenong.test.Model.DATA DATA) {
        this.DATA = DATA;
    }
}