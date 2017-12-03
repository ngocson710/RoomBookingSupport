package com.example.n_son.roombookingsupport.Model.DatPhong;

import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.Model.OjectClass.Facility;
import com.example.n_son.roombookingsupport.Model.OjectClass.TimKiemPhong;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by NSON on 11/15/2017.
 */

public class modelTimKiemPhong {
    public String LayDSPhong(TimKiemPhong timKiemPhong){
        String data="";
        String duongdan= DangNhapActivity.SERVERNAME+"api/Search?IDbranch="+timKiemPhong.getIdCoso()+ "&IDtype="+timKiemPhong.getIdLoaiPhong()
                +"&Namefacility="+timKiemPhong.getMaPhong()+"&DateBorrow="+timKiemPhong.getNgayMuon()+"&timeStart="+timKiemPhong.getGioMuon()+"&timeEnd="+timKiemPhong.getGioTra();
        Log.i("kiemtraduongdan", duongdan);
        DownloadJSon downloadJSon= new DownloadJSon(duongdan);
        downloadJSon.execute();
        try {
            data= downloadJSon.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.i("kiemtra456", data);
        return data;
    }
}
