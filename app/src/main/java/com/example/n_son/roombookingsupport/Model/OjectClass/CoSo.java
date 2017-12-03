package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/10/2017.
 */

public class CoSo {

    int IdCoSo;
    String TenLoaiPhong;
    String TenPhong;
    String TenCoSo;
    String SucChua;

    public CoSo(int idCoSo, String tenLoaiPhong, String tenPhong, String tenCoSo, String sucChua) {
        IdCoSo = idCoSo;
        TenLoaiPhong = tenLoaiPhong;
        TenPhong = tenPhong;
        TenCoSo = tenCoSo;
        SucChua = sucChua;
    }

    public int getIdCoSo() {
        return IdCoSo;
    }

    public void setIdCoSo(int idCoSo) {
        IdCoSo = idCoSo;
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

    public String getSucChua() {
        return SucChua;
    }

    public void setSucChua(String sucChua) {
        SucChua = sucChua;
    }
}
