package com.onthi.demau2_sqlite.Model;

import java.io.Serializable;

public class NVVT implements Serializable {
    private int idNVVT;
    private int idNV;
    private int idVT;
    private String date;
    private String mta;

    public NVVT(int idNVVT, int idNV, int idVT, String date, String mta) {
        this.idNVVT = idNVVT;
        this.idNV = idNV;
        this.idVT = idVT;
        this.date = date;
        this.mta = mta;
    }

    public int getIdNVVT() {
        return idNVVT;
    }

    public void setIdNVVT(int idNVVT) {
        this.idNVVT = idNVVT;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdVT() {
        return idVT;
    }

    public void setIdVT(int idVT) {
        this.idVT = idVT;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMta() {
        return mta;
    }

    public void setMta(String mta) {
        this.mta = mta;
    }
}
