package com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDaDat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Adapter.PhongDatAdapter;
import com.example.n_son.roombookingsupport.Adapter.PhongDuyetAdapter;
import com.example.n_son.roombookingsupport.Model.OjectClass.Phong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Presenter.PhongDaDat.PresentLogicPhongDaDat;
import com.example.n_son.roombookingsupport.Presenter.PhongDangDuyet.PresentLogicPhongDangDuyet;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDangDuyet.PhongDuyetActivity;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;
import com.example.n_son.roombookingsupport.View.XemChiTet.XemChiTietMainActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

public class PhongDaDatActivity extends AppCompatActivity implements ViewPhongDaDat{
    RecyclerView recyclerView;
    PresentLogicPhongDaDat presentLogicPhongDaDat;
    PhongDatAdapter phongDatAdapter;
    public static ArrayList<ThongTinPhong> thongTinPhongs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lich_su_phong);
        recyclerView= (RecyclerView) findViewById(R.id.rcl_phongdadat);

        presentLogicPhongDaDat= new PresentLogicPhongDaDat(this);

        String userId= new DangNhapActivity().thongTinUser().getUserId()+"";
        Log.i("PDregisterId ",": "+userId);
        presentLogicPhongDaDat.XuLyPhongDaDat(userId);
    }

    @Override
    public void hienThiPhong() {
        thongTinPhongs= presentLogicPhongDaDat.getArrayList();
        Collections.reverse(thongTinPhongs);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        phongDatAdapter= new PhongDatAdapter(this, R.layout.custom_layout_phongdadat, thongTinPhongs);
        recyclerView.setAdapter(phongDatAdapter);
        phongDatAdapter.notifyDataSetChanged();

    }

    @Override
    public void loiHienThiPhong() {
        alertDialogThongBao();
        Toast.makeText(this, "Không có phòng", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoiKetNoiInternet() {
        Toast.makeText(this, "Lỗi Kết Nối Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void XoaThatBai() {
        Toast.makeText(this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void xoaThanhCong() {
        Toast.makeText(this, "Xóa Phòng Thành Công", Toast.LENGTH_SHORT).show();
    }

    private void alertDialogThongBao(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Không Có Phòng");
        builder.setIcon(R.drawable.ic_informationbutton_blue);
        builder.setMessage("Không có phòng nào trong lịch sử đặt phòng");
        builder.setPositiveButton("Trở Lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(PhongDaDatActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}


