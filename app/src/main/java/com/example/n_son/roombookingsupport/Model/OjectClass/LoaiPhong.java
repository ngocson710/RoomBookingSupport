package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/10/2017.
 */

public class LoaiPhong {
    int IDLoaiPhong;
    String TenLoaiPhong;

    public LoaiPhong(int IDLoaiPhong, String tenLoaiPhong) {
        this.IDLoaiPhong = IDLoaiPhong;
        TenLoaiPhong = tenLoaiPhong;
    }

    public int getIDLoaiPhong() {
        return IDLoaiPhong;
    }

    public void setIDLoaiPhong(int IDLoaiPhong) {
        this.IDLoaiPhong = IDLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return TenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        TenLoaiPhong = tenLoaiPhong;
    }
}
