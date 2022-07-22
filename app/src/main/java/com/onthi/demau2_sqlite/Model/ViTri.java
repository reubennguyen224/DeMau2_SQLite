package com.onthi.demau2_sqlite.Model;

import java.io.Serializable;

public class ViTri implements Serializable {

    private int maVT;
    private String tenVT;
    private String motaVT;

    public ViTri(int maVT, String tenVT, String motaVT) {
        this.maVT = maVT;
        this.tenVT = tenVT;
        this.motaVT = motaVT;
    }

    public ViTri() {
    }

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public String getMotaVT() {
        return motaVT;
    }

    public void setMotaVT(String motaVT) {
        this.motaVT = motaVT;
    }
}
