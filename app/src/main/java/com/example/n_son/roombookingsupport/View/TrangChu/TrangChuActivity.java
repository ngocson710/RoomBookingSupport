package com.example.n_son.roombookingsupport.View.TrangChu;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.User;
import com.example.n_son.roombookingsupport.Presenter.DangNhap.PresenterLogicDangNhap;
import com.example.n_son.roombookingsupport.Presenter.PhongDaDat.PresentLogicPhongDaDat;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;
import com.example.n_son.roombookingsupport.View.DangNhap.ViewXuLyDangNhap;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDaDat.PhongDaDatActivity;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDangDuyet.PhongDuyetActivity;
import com.example.n_son.roombookingsupport.View.DatPhong.DatPhongActivity;
import com.example.n_son.roombookingsupport.View.GoiYPhong.PhongGoiYMainActivity;
import com.example.n_son.roombookingsupport.View.ThongBao.ThongBaotivity;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by N-SON on 30/09/2017.
 */

public class TrangChuActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    Button btnDatPhongMoi, btnPhongChoDuyet, btnLichSuPhong;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    User user = null;
    NavigationView navigationView;
    int gioihan=0;
    ImageView imgProfile;
    TextView txtName, txtEmail;
    PresentLogicPhongDaDat presentLogicPhongDaDat;
    LinearLayout lnHinh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trang_chu);
        gioihan = PhongGoiYMainActivity.GIOIHAN;
        Log.i("kiemtraGioiHan", String.valueOf(gioihan));
        presentLogicPhongDaDat = new PresentLogicPhongDaDat();
//        ArrayList<ThongTinPhong> thongTinPhongs= presentLogicPhongDaDat.getArrayList();
//        GioHanDatPhong= thongTinPhongs.size();

        navigationView= (NavigationView) findViewById(R.id.navigationView);
        View view =  navigationView.getHeaderView(0);
        imgProfile= view.findViewById(R.id.imgProfile);
        txtName= view.findViewById(R.id.txtName);
        txtEmail= view.findViewById(R.id.txtEmail);

        Random rd= new Random();
        int i=  0+ rd.nextInt(6);
        ArrayList<Integer> listHinh= new ArrayList<>();
        listHinh.add(R.drawable.paper1);
        listHinh.add(R.drawable.paper2);
        listHinh.add(R.drawable.paper3);
        listHinh.add(R.drawable.paper4);
        listHinh.add(R.drawable.paper5);
        listHinh.add(R.drawable.paper6);
        lnHinh= (LinearLayout) findViewById(R.id.hinh);
        lnHinh.setBackgroundResource(listHinh.get(i));

        anhxa();
        user = DangNhapActivity.thongTinUser();
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        btnDatPhongMoi.setOnClickListener(this);
        btnPhongChoDuyet.setOnClickListener(this);
        btnLichSuPhong.setOnClickListener(this);

        Log.i("checkUser",user.getGender()+"--"+ user.getUserName()+"--"+ user.getEmail());
        if(user.getGender().equalsIgnoreCase("nam")){
            imgProfile.setImageResource(R.drawable.man);
            txtName.setText("Hello, Mr "+user.getUserName());
        }
        else{
            imgProfile.setImageResource(R.drawable.woman);
            txtName.setText("Hello, Ms "+user.getUserName());
        }
        txtEmail.setText(user.getEmail());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                switch (id){
                    case R.id.iTimPhong:
                        Intent intentDatPhong= new Intent(TrangChuActivity.this, DatPhongActivity.class);
                        startActivity(intentDatPhong);
                        break;
                    case R.id.itThongBao:
                        Intent intentitThongBao= new Intent(TrangChuActivity.this, ThongBaotivity.class);
                        startActivity(intentitThongBao);
                        break;
                    case R.id.itDSPhongDuyet:
                        Intent itDSPhongDuyet= new Intent(TrangChuActivity.this, PhongDuyetActivity.class);
                        startActivity(itDSPhongDuyet);
                        break;
                    case R.id.itLichSuPhong:
                        Intent itLichSuPhong= new Intent(TrangChuActivity.this, PhongDaDatActivity.class);
                        startActivity(itLichSuPhong);
                        break;
                    case R.id.itDangXuat:
                        Intent itDangXuat= new Intent(TrangChuActivity.this, DangNhapActivity.class);
                        startActivity(itDangXuat);
                        break;
                }
                return false;
            }
        });
    }

    private void anhxa(){
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        btnDatPhongMoi= (Button) findViewById(R.id.btn_datphongmoi);
        btnLichSuPhong= (Button) findViewById(R.id.btn_lichsudatphong);
        btnPhongChoDuyet= (Button) findViewById(R.id.btn_phongchoduyet);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Nhấn lần nữa để thoát ứng dụng", Toast.LENGTH_SHORT).show();
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
    public void onClick(View view) {
        int id= view.getId();
        switch(id){
            case R.id.btn_datphongmoi:
                if(gioihan>2){
                    Toast.makeText(this, "Bạn không thể đặt hơn 2 phòng", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent itDatPhongMoi = new Intent(TrangChuActivity.this, DatPhongActivity.class);
                    startActivity(itDatPhongMoi);
                }
                break;
            case R.id.btn_lichsudatphong:
                Intent itLichSu= new Intent(TrangChuActivity.this, PhongDaDatActivity.class);
                startActivity(itLichSu);
                break;
            case R.id.btn_phongchoduyet:
                Intent itPhongDuyet= new Intent(TrangChuActivity.this, PhongDuyetActivity.class);
                startActivity(itPhongDuyet);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu, menu);
        final MenuItem item= menu.findItem(R.id.itthongbao);
        item.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TrangChuActivity.this, "thông báo mới", Toast.LENGTH_SHORT).show();
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        int id= item.getItemId();
        switch (id){
        }
        return super.onOptionsItemSelected(item);
    }
}
