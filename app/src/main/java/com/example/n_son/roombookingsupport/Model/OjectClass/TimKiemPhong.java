package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/10/2017.
 */

public class TimKiemPhong {
    int IdCoso;
    int IdLoaiPhong;
    String MaPhong;
    String NgayMuon;
    String GioMuon;
    String GioTra;

    public TimKiemPhong(int idCoso, int idLoaiPhong, String maPhong, String ngayMuon, String gioMuon, String gioTra) {
        IdCoso = idCoso;
        IdLoaiPhong = idLoaiPhong;
        MaPhong = maPhong;
        NgayMuon = ngayMuon;
        GioMuon = gioMuon;
        GioTra = gioTra;
    }

    public int getIdCoso() {
        return IdCoso;
    }

    public void setIdCoso(int idCoso) {
        IdCoso = idCoso;
    }

    public int getIdLoaiPhong() {
        return IdLoaiPhong;
    }

    public void setIdLoaiPhong(int idLoaiPhong) {
        IdLoaiPhong = idLoaiPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
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
}
