package com.onthi.demau2_sqlite.Model;

import java.io.Serializable;

public class NhanVien implements Serializable {

    private int maNV;
    private String tenNV;
    private int namsinh;
    private String quequan;
    private String trinhdo;

    public NhanVien() {
    }

    public NhanVien(int id, String tenNV, int namsinh, String quequan, String trinhdo) {
        this.maNV = id;
        this.tenNV = tenNV;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.trinhdo = trinhdo;
    }

    public NhanVien(int maNV, String tenNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
