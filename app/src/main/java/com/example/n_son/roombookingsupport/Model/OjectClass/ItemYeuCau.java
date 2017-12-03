package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/25/2017.
 */

public class ItemYeuCau {
    String tenThietBi;
    String GhiChu;

    public ItemYeuCau(String tenThietBi, String ghiChu) {
        this.tenThietBi = tenThietBi;
        GhiChu = ghiChu;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }
}
