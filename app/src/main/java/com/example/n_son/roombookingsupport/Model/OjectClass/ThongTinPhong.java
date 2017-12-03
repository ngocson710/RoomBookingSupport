package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/22/2017.
 */

public class ThongTinPhong {
    int IdDangKy;
    int IdLoaiPhong;
    int IdLoaiCoSo;
    String TenLoaiPhong;
    String TenPhong;
    String TenCoSo;
    String NgayDk;
    String NgayMuon;
    String GioMuon;
    String GioTra;
    String SucChua;
    String ThietBi;
    String yeuCau;

    public ThongTinPhong(int idDangKy, int idLoaiPhong, int idLoaiCoSo, String tenLoaiPhong, String tenPhong, String tenCoSo
            , String ngayDk, String ngayMuon, String gioMuon, String gioTra, String sucChua, String thietBi, String yeuCau) {
        IdDangKy = idDangKy;
        IdLoaiPhong = idLoaiPhong;
        IdLoaiCoSo = idLoaiCoSo;
        TenLoaiPhong = tenLoaiPhong;
        TenPhong = tenPhong;
        TenCoSo = tenCoSo;
        NgayDk = ngayDk;
        NgayMuon = ngayMuon;
        GioMuon = gioMuon;
        GioTra = gioTra;
        SucChua = sucChua;
        ThietBi = thietBi;
        this.yeuCau = yeuCau;
    }

    public int getIdDangKy() {
        return IdDangKy;
    }

    public void setIdDangKy(int idDangKy) {
        IdDangKy = idDangKy;
    }

    public int getIdLoaiPhong() {
        return IdLoaiPhong;
    }

    public void setIdLoaiPhong(int idLoaiPhong) {
        IdLoaiPhong = idLoaiPhong;
    }

    public int getIdLoaiCoSo() {
        return IdLoaiCoSo;
    }

    public void setIdLoaiCoSo(int idLoaiCoSo) {
        IdLoaiCoSo = idLoaiCoSo;
    }

    public String getTenLoaiPhong() {
        return TenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        TenLoaiPhong = tenLoaiPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }

    public String getTenCoSo() {
        return TenCoSo;
    }

    public void setTenCoSo(String tenCoSo) {
        TenCoSo = tenCoSo;
    }

    public String getNgayDk() {
        return NgayDk;
    }

    public void setNgayDk(String ngayDk) {
        NgayDk = ngayDk;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        NgayMuon = ngayMuon;
    }

    public String getGioMuon() {
        return GioMuon;
    }

    public void setGioMuon(String gioMuon) {
        GioMuon = gioMuon;
    }

    public String getGioTra() {
        return GioTra;
    }

    public void setGioTra(String gioTra) {
        GioTra = gioTra;
    }

    public String getSucChua() {
        return SucChua;
    }

    public void setSucChua(String sucChua) {
        SucChua = sucChua;
    }

    public String getThietBi() {
        return ThietBi;
    }

    public void setThietBi(String thietBi) {
        ThietBi = thietBi;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }
}
