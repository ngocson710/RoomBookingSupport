package com.example.n_son.roombookingsupport.Model.DatPhong;

import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.Model.OjectClass.CoSo;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by N-SON on 27/10/2017.
 */

public class modelLoadCoSo {

    public String LayDanhSachCoSo(){
        String data="";
        String duongdan= DangNhapActivity.SERVERNAME+ "api/GetBranch";

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
}
