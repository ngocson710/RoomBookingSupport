package com.example.n_son.roombookingsupport.Presenter.DangNhap;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.CheckInternet;
import com.example.n_son.roombookingsupport.Model.DangNhap.ModelXuLyDangNhap;
import com.example.n_son.roombookingsupport.Model.OjectClass.User;
import com.example.n_son.roombookingsupport.View.DangNhap.ViewXuLyDangNhap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by N-SON on 19/10/2017.
 */

public class PresenterLogicDangNhap implements PresenterImpDangNhap {
    ViewXuLyDangNhap viewXuLyDangNhap;
    private User user= null;
    public PresenterLogicDangNhap(ViewXuLyDangNhap viewXuLyDangNhap){
        this.viewXuLyDangNhap= viewXuLyDangNhap;
    }
    @Override
    public void KiemTraDangNhap(String tenDangNhap, String matKhau) {
        ModelXuLyDangNhap modelXuLyDangNhap= new ModelXuLyDangNhap();
        String data = modelXuLyDangNhap.layThongTinDangNhap(tenDangNhap, matKhau);

        //kiểm tra kết nối internet
        if(new CheckInternet().checknetwork((Context) viewXuLyDangNhap)){
            //lấy dữ liệu từ model về để so sánh
            Log.i("dangnhap", data);
            if(data.equals("[]")){
                viewXuLyDangNhap.DangNhapThatBai();
            }
            else{
                user = parseUser(data);
                viewXuLyDangNhap.DangNhapThanhCong();
            }
        }
        else{
            viewXuLyDangNhap.khongCoKetNoi();
        }

    }
    private User parseUser(String data){
        User user1 = null;
        try {
            JSONArray jsonRoot = new JSONArray(data);
            for(int i=0; i<jsonRoot.length(); i++){
                JSONObject jsonObject= jsonRoot.getJSONObject(i);
                int USER_ID= jsonObject.getInt("USER_ID");
                Log.i("USER_ID", USER_ID+"");
                String USER_NAME= jsonObject.getString("USER_NAME");
                String EMAIL= jsonObject.getString("EMAIL");
                String TYPE_USER= jsonObject.getString("TYPE_USER");
                String Gender= jsonObject.getString("GENDER");
                user1 = new User(USER_ID, USER_NAME, EMAIL, TYPE_USER, Gender);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user1;
    }

    public User thongTinUser(){
        return user;
    }

}
