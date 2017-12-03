package com.example.n_son.roombookingsupport.Presenter.DatPhong;

import android.content.Context;
import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.CheckInternet;
import com.example.n_son.roombookingsupport.Model.DatPhong.modelDatPhongMoi;
import com.example.n_son.roombookingsupport.Model.OjectClass.DatPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.Facility;
import com.example.n_son.roombookingsupport.View.ShowPhongTimKiem.ViewShowPhong;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NSON on 11/19/2017.
 */

public class PresentLogicDatPhong implements PresentImpDatPhong {
    ViewShowPhong viewShowPhong;
    public PresentLogicDatPhong(ViewShowPhong viewShowPhong) {
        this.viewShowPhong = viewShowPhong;
    }

    @Override
    public void xuLyDatPhong(DatPhong datPhong) {
        Log.i("datphong", datPhong.getDATE_REGISTER()+"--"+datPhong.getFACILITY_COMPONENT_ID_1()+"--"+datPhong.getFACILITY_COMPONENT_ID_2()+"--"
                +datPhong.getFACILITY_COMPONENT_ID_3());
        modelDatPhongMoi modelDatPhongMoi= new modelDatPhongMoi();
        boolean data = modelDatPhongMoi.datphong(datPhong);
        if(new CheckInternet().checknetwork((Context) viewShowPhong)){
            //nếu có dữ liệu
            if(data){
                viewShowPhong.datPhongThanhCong();
            }
            //nếu kết quả khác true
            else{
                viewShowPhong.datPhongThatBai();
            }
        }
        else {
            viewShowPhong.LoiKetNoiInternet();
        }
    }
}
