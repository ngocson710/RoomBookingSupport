package com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDangDuyet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Adapter.PhongDuyetAdapter;
import com.example.n_son.roombookingsupport.Model.OjectClass.Phong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.User;
import com.example.n_son.roombookingsupport.Presenter.PhongDangDuyet.PresentLogicPhongDangDuyet;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;
import com.example.n_son.roombookingsupport.View.GoiYPhong.PhongGoiYMainActivity;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhongDuyetActivity extends AppCompatActivity implements ViewPhongDangDuyet{
    PhongDuyetAdapter phongDuyetAdapter;
    RecyclerView recyclerView;
    List<ThongTinPhong> thongTinPhongs;
    PresentLogicPhongDangDuyet presentLogicPhongDangDuyet;
    DangNhapActivity dangNhapActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_phong_duyet);
        recyclerView= (RecyclerView) findViewById(R.id.rcl_phongduyet);
        presentLogicPhongDangDuyet= new PresentLogicPhongDangDuyet(this);

        String UserID= dangNhapActivity.thongTinUser().getUserId()+"";
        Log.i("PDUserID ",": "+UserID);
        presentLogicPhongDangDuyet.xuLyDanhSachPhong(UserID);
    }

    @Override
    public void hienThiPhong() {
        thongTinPhongs = presentLogicPhongDangDuyet.getArrayList();
        Collections.reverse(thongTinPhongs);
        Log.i("HienThi: ", thongTinPhongs.get(0).getIdDangKy()+"--"+ thongTinPhongs.get(0).getIdLoaiPhong()+"- Ten "+ thongTinPhongs.get(0).getTenPhong());
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        phongDuyetAdapter= new PhongDuyetAdapter(this, R.layout.custom_layout_phongduyet, thongTinPhongs);
        recyclerView.setAdapter(phongDuyetAdapter);
        phongDuyetAdapter.notifyDataSetChanged();
    }

    @Override
    public void loiHienThiPhong() {
        alertDialogThongBao();
        Toast.makeText(this, "Hiện tại không có phòng nào", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void xoaThanhCong() {
        Toast.makeText(PhongDuyetActivity.this, "Xóa phòng thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void XoaThatBai() {
        Toast.makeText(PhongDuyetActivity.this, "Xóa phòng thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void chuaDuyet() {
    }

    @Override
    public void daDuyet() {

    }

    private void alertDialogThongBao(){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Không Có Phòng");
        builder.setIcon(R.drawable.ic_informationbutton_blue);
        builder.setMessage("Không có phòng nào được chờ duyệt");
        builder.setPositiveButton("Trở Lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(PhongDuyetActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}