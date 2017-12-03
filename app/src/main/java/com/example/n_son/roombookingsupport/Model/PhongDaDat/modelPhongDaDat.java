package com.example.n_son.roombookingsupport.Model.PhongDaDat;

import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by NSON on 11/22/2017.
 */

public class modelPhongDaDat {
    public String layDuLieuPhongChoDuyet(String RegisterID){
        String data= "";
        String duongdan= DangNhapActivity.SERVERNAME+ "api/History/"+RegisterID;
        DownloadJSon downloadJSon= new DownloadJSon(duongdan);
        downloadJSon.execute();
        try {
            data= downloadJSon.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.i("KiemtraPDD", data);
        return data;
    }
    public String xoaPhong(String IdRegister){
        String dulieu="";
        String duongdan= "http://10.0.3.2/WebSite/api/Delete/"+IdRegister;

        DownloadJSon downloadJSon= new DownloadJSon(duongdan);
        downloadJSon.execute();
        try {
            dulieu= downloadJSon.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return dulieu;
    }
}
