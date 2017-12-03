package com.example.n_son.roombookingsupport.Model.DatPhong;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.Model.OjectClass.LoaiPhong;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by NSON on 11/10/2017.
 */

public class modelLoadLoaiPhong {
    String layDanhSachLoaiPhong(){
        String data="";
        String duongdan= DangNhapActivity.SERVERNAME+"api/GetFacilitiType";
        DownloadJSon downloadJSon= new DownloadJSon(duongdan);
        downloadJSon.execute();

        try {
            data= downloadJSon.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<LoaiPhong> ParseJsonLoaiPhong(){
        ArrayList<LoaiPhong> listLoaiPhong= new ArrayList<>();
        String data= layDanhSachLoaiPhong();
        try {
            JSONArray jsonRoot= new JSONArray(data);
            for(int i=1; i<jsonRoot.length(); i++){
                JSONObject jsonObject= jsonRoot.getJSONObject(i);
                int FACILITY_TYPE_ID= jsonObject.getInt("FACILITY_TYPE_ID");
                String FACILITY_NAME= jsonObject.getString("FACILITY_NAME");
                LoaiPhong loaiPhong= new LoaiPhong(FACILITY_TYPE_ID, FACILITY_NAME);
                listLoaiPhong.add(loaiPhong);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listLoaiPhong;
    }
}
