package com.example.n_son.roombookingsupport.Presenter.PhongDaDat;

import android.content.Context;
import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.CheckInternet;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Model.PhongDaDat.modelPhongDaDat;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDaDat.ViewPhongDaDat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NSON on 11/22/2017.
 */

public class PresentLogicPhongDaDat implements PresentImpPhongDaDat{
    ViewPhongDaDat viewPhongDaDat;
    ArrayList<ThongTinPhong> arrayList;
    modelPhongDaDat modelPhongDaDat;

    public ArrayList<ThongTinPhong> getArrayList() {
        return arrayList;
    }

    public PresentLogicPhongDaDat() {
    }

    public PresentLogicPhongDaDat(ViewPhongDaDat viewPhongDaDat) {
        this.viewPhongDaDat = viewPhongDaDat;
    }

    @Override
    public void XuLyPhongDaDat(String userId) {
        modelPhongDaDat= new modelPhongDaDat();
        String data= modelPhongDaDat.layDuLieuPhongChoDuyet(userId);
        Log.i("PDPhongDat1", data);
        arrayList = parseDuLieuPhong(data);
        Log.i("PDPhongDat2", arrayList.toString());
        if(new CheckInternet().checknetwork((Context) viewPhongDaDat)){
            //nếu có dữ liệu
            if(!data.equalsIgnoreCase("[]")){
                Log.i("PDPhongDat3", arrayList.get(0).getIdDangKy()+"");
                viewPhongDaDat.hienThiPhong();
            }
            else{
                viewPhongDaDat.hienThiPhong();
            }
        }
        else {
            viewPhongDaDat.LoiKetNoiInternet();
        }


    }

    @Override
    public void XuLyXoaPhong(String IdRegister){
        String data= modelPhongDaDat.xoaPhong(IdRegister);
        if(data.equalsIgnoreCase("true")){
            viewPhongDaDat.xoaThanhCong();
        }
        else {
            viewPhongDaDat.XoaThatBai();
        }
    }



    private ArrayList<ThongTinPhong> parseDuLieuPhong(String data){
        ArrayList<ThongTinPhong> phongList= new ArrayList<>();
        try {
            JSONArray jsonArray= new JSONArray(data);
            for(int i=0;i<jsonArray.length(); i++){
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                int IdDangKy = jsonObject.getInt("USER_REGISTER_ROOM_ID");
                int IdLoaiPhong= jsonObject.getInt("FACILITY_ID");
                int IdLoaiCoSo= 0;
                String TenLoaiPhong= "";
                String TenPhong= jsonObject.getString("FACILITY_NAME");
                String TenCoSo= jsonObject.getString("FACILITY_ADDRESS");
                String NgayDk= jsonObject.getString("DATE_REGISTER");
                String NgayMuon= jsonObject.getString("DATE_SUGGEST_ROOM");
                String GioMuon= jsonObject.getString("HOUR_SUGGEST_START");
                String GioTra= jsonObject.getString("HOUR_SUGGEST_END");
                String SucChua= jsonObject.getString("MAX_NUMBER_OF_PEOPLE");
                String ThietBi= "";
                String yeuCau = jsonObject.getString("CONTENT_REQUEST");
                ThongTinPhong thongTinPhong= new ThongTinPhong(IdDangKy, IdLoaiPhong, IdLoaiCoSo, TenLoaiPhong, TenPhong
                        , TenCoSo, NgayDk, NgayMuon, GioMuon, GioTra, SucChua, ThietBi, yeuCau);
                phongList.add(thongTinPhong);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return phongList;
    }

}
