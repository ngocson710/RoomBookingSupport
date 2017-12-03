package com.example.n_son.roombookingsupport.Presenter.PhongDangDuyet;

import android.util.Log;

import com.example.n_son.roombookingsupport.Model.OjectClass.Phong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Model.PhongDaDat.modelPhongDaDat;
import com.example.n_son.roombookingsupport.Model.PhongDangDuyet.modelPhongChoDuyet;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDangDuyet.ViewPhongDangDuyet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NSON on 11/21/2017.
 */

public class PresentLogicPhongDangDuyet implements PresentImpPhongDangDuyet {
    ViewPhongDangDuyet viewPhongDangDuyet;
    ArrayList<ThongTinPhong> arrayList;
    modelPhongChoDuyet modelPhongChoDuyet;

    public ArrayList<ThongTinPhong> getArrayList() {
        return arrayList;
    }

    public PresentLogicPhongDangDuyet(ViewPhongDangDuyet viewPhongDangDuyet) {
        this.viewPhongDangDuyet = viewPhongDangDuyet;
    }

    @Override
    public void xuLyDanhSachPhong(String userId) {
        modelPhongChoDuyet= new modelPhongChoDuyet();
        String data= modelPhongChoDuyet.layDuLieuPhongChoDuyet(userId);
        Log.i("PrPhongDuyet1", data);
        arrayList= parseDuLieuPhong(data);
        Log.i("PrPhongDuyet2", arrayList.toString());
        //nếu có dữ liệu
        if(!data.equalsIgnoreCase("[]")){
            Log.i("PrPhongDuyet3", arrayList.get(0).getIdDangKy()+"");
            viewPhongDangDuyet.hienThiPhong();
        }
        // nếu ko có dữ liệu
        else{
            Log.i("LoiHienThiPD", "Hiện Tại Không Có Phòng nào");
            viewPhongDangDuyet.loiHienThiPhong();
        }
    }
    @Override
    public void XuLyXoaPhong(String IdRegister){
        Log.i("dataPhongDuyet", IdRegister+"");
        modelPhongChoDuyet= new modelPhongChoDuyet();
        String data= modelPhongChoDuyet.xoaPhong(IdRegister);
        Log.i("dataPhongDuyet", data+"");
        if(data.equalsIgnoreCase("true")){
            viewPhongDangDuyet.xoaThanhCong();
        }
        else {
            viewPhongDangDuyet.XoaThatBai();
        }
    }

    @Override
    public void kiemtraDuyet(String IdRegister){
        String data= modelPhongChoDuyet.xoaPhong(IdRegister);
        if(data.equalsIgnoreCase("true")){
            viewPhongDangDuyet.daDuyet();
        }
        else {
            viewPhongDangDuyet.chuaDuyet();
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
