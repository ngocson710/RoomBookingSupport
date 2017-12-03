package com.example.n_son.roombookingsupport.Presenter.DatPhong;

import android.content.Context;
import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.CheckInternet;
import com.example.n_son.roombookingsupport.Model.DatPhong.modelLoadLoaiPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.LoaiPhong;
import com.example.n_son.roombookingsupport.View.DatPhong.ViewLoadSpinerLoaiPhong;

import java.util.ArrayList;

/**
 * Created by NSON on 11/10/2017.
 */

public class PresenterLoginLoadLoaiPhong implements PresenterImpLoadLoaiphong {
    ViewLoadSpinerLoaiPhong viewLoadSpinerLoaiPhong;
    public PresenterLoginLoadLoaiPhong(ViewLoadSpinerLoaiPhong viewLoadSpinerLoaiPhong) {
        this.viewLoadSpinerLoaiPhong= viewLoadSpinerLoaiPhong;
    }

    @Override
    public void KiemTraDuLieuLoaiPhong() {
        modelLoadLoaiPhong modelLoadLoaiPhong= new modelLoadLoaiPhong();
        ArrayList<LoaiPhong> arrayList = modelLoadLoaiPhong.ParseJsonLoaiPhong();

        Log.i("SSS", arrayList.get(1).getTenLoaiPhong());
        if(new CheckInternet().checknetwork((Context) viewLoadSpinerLoaiPhong)){
            if(arrayList==null){
                viewLoadSpinerLoaiPhong.LoiHienThi_LoaiPhong();
            }
            else{
                viewLoadSpinerLoaiPhong.HienThiDuLieu_LoaiPhong(arrayList);
            }
        }
        else {
            viewLoadSpinerLoaiPhong.LoiKetNoiInternet();
        }

    }
}
