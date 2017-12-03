package com.example.n_son.roombookingsupport.Model.DangNhap;

import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.Model.OjectClass.User;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by N-SON on 19/10/2017.
 */

public class ModelXuLyDangNhap {

    public String layThongTinDangNhap(String username, String password){
        String data= "";
        String duongDan= DangNhapActivity.SERVERNAME + "api/Login?username="+username+"&password="+password;
//        String duongDan= "http://192.168.1.4/WebSite/api/Login?username="+username+"&password="+password;
        DownloadJSon downloadJSon = new DownloadJSon(duongDan);
        downloadJSon.execute();
        try {
            data = downloadJSon.get();
            Log.i("dulieuLogin", data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return data;
    }
}
