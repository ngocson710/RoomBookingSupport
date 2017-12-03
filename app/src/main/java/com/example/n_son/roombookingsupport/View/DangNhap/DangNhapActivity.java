package com.example.n_son.roombookingsupport.View.DangNhap;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.CustomView.PasswordEditext;
import com.example.n_son.roombookingsupport.Model.OjectClass.User;
import com.example.n_son.roombookingsupport.Presenter.DangNhap.PresenterLogicDangNhap;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;

public class DangNhapActivity extends AppCompatActivity implements ViewXuLyDangNhap{
    Button btnDangNhap;
    EditText edtUserName;
    EditText pwedtMatKhau;
    CheckBox cbkiemtra;
    String tendangnhap, matkhau;
    SharedPreferences sharedPreferences;
    PresenterLogicDangNhap presenterLogicDangNhap;
    public static User user = null;
    private ProgressDialog progressDialog;
//     Real device
//    public static final String SERVERNAME= "http://192.168.1.4/";
    // Genymotion
    public static final String SERVERNAME= "http://10.0.3.2/WebSite/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);
        btnDangNhap= (Button) findViewById(R.id.btn_dangnhap);
        edtUserName= (EditText) findViewById(R.id.edt_tentaikhoan);
        pwedtMatKhau= (EditText) findViewById(R.id.edt_matkhau);
        cbkiemtra= (CheckBox) findViewById(R.id.ck_ghinhomatkhau);
        edtUserName.requestFocus();

        //tạo đối tượng sharedPreferences
        sharedPreferences = getSharedPreferences("dangnhap", Context.MODE_PRIVATE);
        // lấy giá trị từ sharedPreferences với ten "dangnhap"
        edtUserName.setText(sharedPreferences.getString("username",""));
        pwedtMatKhau.setText(sharedPreferences.getString("password",""));
        cbkiemtra.setChecked(sharedPreferences.getBoolean("checked",false));

        presenterLogicDangNhap = new PresenterLogicDangNhap(this);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog= new ProgressDialog(DangNhapActivity.this);
                progressDialog.setMessage("Đang Kiểm Tra...");
                progressDialog.setTitle("Đăng nhập");
                progressDialog.setCancelable(false);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tendangnhap = edtUserName.getText().toString();
                        matkhau = pwedtMatKhau.getText().toString();
                        presenterLogicDangNhap.KiemTraDangNhap(tendangnhap, matkhau);
                    }
                }).start();
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Nhấn lần nữa để thoát ứng dụng", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
//                System.exit(0);
                finish();
            }
        }, 2000);
    }

    @Override
    public void DangNhapThanhCong() {
        if(cbkiemtra.isChecked()){
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            // lưu giá trị vào sharedPreferences
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString("username", tendangnhap);
            editor.putString("password", matkhau);
            editor.putBoolean("checked", true);
            editor.commit();
        }
        else{
            //xóa khỏi sharedPreferences
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.remove("username");
            editor.remove("password");
            editor.remove("checked");
            editor.commit();
        }

        Intent itDangNhap = new Intent(DangNhapActivity.this, TrangChuActivity.class);
        user = presenterLogicDangNhap.thongTinUser();
        Log.i("thongTinUser1", user.getUserId() +" "+user.getUserName()
                +" - "+ user.getEmail()+ " - "+user.getTypeUser());
        startActivity(itDangNhap);
    }

    @Override
    public void DangNhapThatBai() {
        progressDialog.dismiss();
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(DangNhapActivity.this, "Sai UserName hoặc password ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void khongCoKetNoi() {
        progressDialog.dismiss();
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(DangNhapActivity.this, "Vui lòng kiểm tra kết nối Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static User thongTinUser(){
        return user;
    }

}
