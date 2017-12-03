package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/24/2017.
 */

public class DanhGia {
    int idNguoiDung;
    int idCoSo;
    String noiDung;
    String trangThai;
    int hinhAnh;

    public DanhGia(int idNguoiDung, int idCoSo, String noiDung, String trangThai, int hinhAnh) {
        this.idNguoiDung = idNguoiDung;
        this.idCoSo = idCoSo;
        this.noiDung = noiDung;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
    }

    public int getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(int idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public int getIdCoSo() {
        return idCoSo;
    }

    public void setIdCoSo(int idCoSo) {
        this.idCoSo = idCoSo;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
