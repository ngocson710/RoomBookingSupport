package com.example.n_son.roombookingsupport.Model.OjectClass;

import android.widget.ImageView;

/**
 * Created by NSON on 11/20/2017.
 */

public class Phong {
    int hinh;
    String tenPhong, coSo, ngayDat, gioMuon, GioTra;

    public Phong(int hinh, String tenPhong, String coSo, String ngayDat, String gioMuon, String gioTra) {
        this.hinh = hinh;
        this.tenPhong = tenPhong;
        this.coSo = coSo;
        this.ngayDat = ngayDat;
        this.gioMuon = gioMuon;
        GioTra = gioTra;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getCoSo() {
        return coSo;
    }

    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getGioMuon() {
        return gioMuon;
    }

    public void setGioMuon(String gioMuon) {
        this.gioMuon = gioMuon;
    }

    public String getGioTra() {
        return GioTra;
    }

    public void setGioTra(String gioTra) {
        GioTra = gioTra;
    }
}
