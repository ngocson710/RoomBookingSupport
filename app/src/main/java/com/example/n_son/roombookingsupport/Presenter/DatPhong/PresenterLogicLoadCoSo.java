package com.example.n_son.roombookingsupport.Presenter.DatPhong;

import android.content.Context;
import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.CheckInternet;
import com.example.n_son.roombookingsupport.Model.DatPhong.modelLoadCoSo;
import com.example.n_son.roombookingsupport.Model.OjectClass.CoSo;
import com.example.n_son.roombookingsupport.View.DatPhong.ViewLoadSpinerCoSo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by N-SON on 20/10/2017.
 */

public class PresenterLogicLoadCoSo implements PresenterImpLoadCoSo {
    modelLoadCoSo modelLoadCoSo = new modelLoadCoSo();
    ViewLoadSpinerCoSo viewLoadCoSo;
    public PresenterLogicLoadCoSo(ViewLoadSpinerCoSo viewLoadCoSo){
        this.viewLoadCoSo= viewLoadCoSo;
    }

    @Override
    public void KiemTraDuLieuCoSo(){
        ArrayList<CoSo> dulieuCoso;
        dulieuCoso = parseJsonCoSo();
        if(new CheckInternet().checknetwork((Context) viewLoadCoSo)){
            if(dulieuCoso!=null){
                viewLoadCoSo.HienThiDuLieu_CoSo(dulieuCoso);
            }
            else {
                viewLoadCoSo.LoiHienThi_CoSo();
            }
        }
        else {
            viewLoadCoSo.LoiKetNoiInternet();
        }
    }

    public ArrayList<CoSo> parseJsonCoSo(){
        String dulieu = modelLoadCoSo.LayDanhSachCoSo();
        ArrayList<CoSo> listcoso= new ArrayList<>();
        try {
            JSONArray jsonArray= new JSONArray(dulieu);
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject value= jsonArray.getJSONObject(i);
                int FACILITY_ID= value.getInt("FACILITY_ID");
                String FACILITY_NAME= value.getString("FACILITY_NAME");
                String FACILITY_ADDRESS= value.getString("FACILITY_ADDRESS");
                String MAX_NUMBER_OF_PEOPLE = String.valueOf(value.getInt("MAX_NUMBER_OF_PEOPLE"));
                CoSo coSo= new CoSo(FACILITY_ID,"", FACILITY_NAME, FACILITY_ADDRESS, MAX_NUMBER_OF_PEOPLE);
                listcoso.add(coSo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listcoso;
    }
}
