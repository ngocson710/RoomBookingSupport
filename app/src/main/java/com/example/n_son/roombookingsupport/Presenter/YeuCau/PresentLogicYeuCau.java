package com.example.n_son.roombookingsupport.Presenter.YeuCau;

import android.content.Context;
import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.CheckInternet;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThietBi;
import com.example.n_son.roombookingsupport.Model.YeuCau.modelYeuCau;
import com.example.n_son.roombookingsupport.View.YeuCauDatPhong.ViewYeuCau;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NSON on 11/25/2017.
 */

public class PresentLogicYeuCau implements PresentImpYeucau{
    ViewYeuCau viewYeuCau;
    ArrayList arrayList;
    public PresentLogicYeuCau(ViewYeuCau viewYeuCau) {
        this.viewYeuCau = viewYeuCau;
    }

    @Override
    public void xuLyDSThietBi() {
        modelYeuCau yeuCau= new modelYeuCau();
        String data= yeuCau.layDanhSachThietBi();
        arrayList = parseJsonThietBi(data);
        Log.i("yeuCau", data);
//        Log.i("yeuCau", arrayList.get(0)+"");
        CheckInternet checkInternet= new CheckInternet();
        if(checkInternet.checknetwork((Context) viewYeuCau)){
            if(!data.equalsIgnoreCase("[]")){
                if(arrayList.size()>=1){
                    viewYeuCau.loadThietBi(arrayList);
                }
                else {
                    viewYeuCau.khongCoThietBi();
                }
            }
            else {
                viewYeuCau.khongCoThietBi();
            }
        }
        else {
            viewYeuCau.LoiKetNoiInternet();
        }
    }

    private ArrayList<ThietBi> parseJsonThietBi(String data){
        ArrayList<ThietBi> arrayList= new ArrayList<>();
        try {
            JSONArray jsonArray= new JSONArray(data);
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1= jsonArray.getJSONObject(i);
                int idthietbi= jsonObject1.getInt("COMPONENT_TYPE_ID");
                String tenThietBi= jsonObject1.getString("COMPONENT_TYPE_NAME");
                arrayList.add(new ThietBi(idthietbi,tenThietBi));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
