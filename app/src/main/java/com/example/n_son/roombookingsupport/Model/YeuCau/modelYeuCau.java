package com.example.n_son.roombookingsupport.Model.YeuCau;

import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import java.util.concurrent.ExecutionException;

/**
 * Created by NSON on 11/25/2017.
 */

public class modelYeuCau {
    public String layDanhSachThietBi(){
        String duongdan= DangNhapActivity.SERVERNAME+"api/GetTypeComponent";
        String data="";
        DownloadJSon downloadJSon= new DownloadJSon(duongdan);
        downloadJSon.execute();
        try {
            data = downloadJSon.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.i("yeuCau", data);
        return data;
    }
}
