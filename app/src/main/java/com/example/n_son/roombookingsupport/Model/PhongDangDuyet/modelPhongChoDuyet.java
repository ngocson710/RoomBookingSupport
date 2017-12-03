package com.example.n_son.roombookingsupport.Model.PhongDangDuyet;

import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by NSON on 11/21/2017.
 */

public class modelPhongChoDuyet {

    public String layDuLieuPhongChoDuyet(String userID){
        String data= "";
        String duongdan= DangNhapActivity.SERVERNAME + "api/GetBookingNotApprove/"+userID;
        DownloadJSon downloadJSon= new DownloadJSon(duongdan);
        downloadJSon.execute();
        try {
            data= downloadJSon.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.i("KiemtraPD", "UserId: "+duongdan+" -- "+data);
        return data;
    }

    public String xoaPhong(String IdRegister){
        String dulieu="";
        String duongdan= DangNhapActivity.SERVERNAME+"api/Delete/"+IdRegister;
        Log.i("modelPhongDuyet",""+duongdan);
        DownloadJSon downloadJSon= new DownloadJSon(duongdan);
        downloadJSon.execute();
        try {
            Log.i("modelPhongDuyet",""+dulieu);
            dulieu= downloadJSon.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return dulieu;
    }

    public String kiemTraDuyet(int IdRoom){
        String dulieu="";
        String duongdan= DangNhapActivity.SERVERNAME+"api/CheckApprove/"+IdRoom;
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
