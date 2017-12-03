package com.example.n_son.roombookingsupport.View.GoiYPhong;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Adapter.DanhSachPhongAdapter;
import com.example.n_son.roombookingsupport.Model.OjectClass.DatPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.Facility;
import com.example.n_son.roombookingsupport.Model.OjectClass.Phong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresenterLogicTimPhong;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DatPhong.DatPhongActivity;
import com.example.n_son.roombookingsupport.View.ShowPhongTimKiem.ShowPhongTKMainActivity;
import com.example.n_son.roombookingsupport.View.ShowPhongTimKiem.ViewShowPhong;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;

import java.util.ArrayList;
import java.util.List;

public class PhongGoiYMainActivity extends AppCompatActivity implements ViewShowPhong {

    DanhSachPhongAdapter danhSachPhongAdapter;
    List<Facility> list;
    List<ThongTinPhong> phongList;
    RecyclerView rcView;
    RecyclerView.LayoutManager layoutManager1;
    public static int GIOIHAN =0;
    DatPhongActivity datPhongActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_phong_goi_y);

        rcView= (RecyclerView) findViewById(R.id.lv_dsphong);
        datPhongActivity = new DatPhongActivity();

        //lấy phongList
        list = datPhongActivity.arrayListPhong;
        Log.i("LoiPhonggoiy",list.size()+"");
        phongList= new ArrayList<>();
        for(int i=0; i< list.size(); i++){
            int idDk= 0;
            int idLoaiPhong= datPhongActivity.datPhong().getFACILITY_ID();
            int idLoaiCoSo= datPhongActivity.coSo().getIdCoSo();
            String tenLoaiPhong= datPhongActivity.coSo().getTenLoaiPhong();
            String tenPhong= "Phòng "+list.get(i).getFACILITY_NAME();
            String tenCoSo= datPhongActivity.coSo().getTenCoSo();
            String ngayDK= datPhongActivity.datPhong().getDATE_REGISTER();
            String ngayDat= datPhongActivity.datPhong().getDATE_SUGGEST_ROOM();
            String gioMuon= datPhongActivity.datPhong().getHOUR_SUGGEST_START();
            String gioTra= datPhongActivity.datPhong().getHOUR_SUGGEST_END();
            String SucChua= datPhongActivity.coSo().getSucChua();
            String thietBi= "";
            String yeucau= datPhongActivity.datPhong().getCONTENT_REQUEST();

            ThongTinPhong thongTinPhong = new ThongTinPhong(idDk, idLoaiPhong, idLoaiCoSo, tenLoaiPhong, tenPhong, tenCoSo
                    , ngayDK, ngayDat, gioMuon, gioTra, SucChua, thietBi, yeucau);

            phongList.add(thongTinPhong);
        }

        layoutManager1= new LinearLayoutManager(this);
        rcView.setLayoutManager(layoutManager1);

        danhSachPhongAdapter = new DanhSachPhongAdapter(this, R.layout.custom_layout_danhsachphong, phongList);
        rcView.setAdapter(danhSachPhongAdapter);
        danhSachPhongAdapter.notifyDataSetChanged();
    }

    private ThongTinPhong thongTinPhong(){
        int idDk= 0;
        int idLoaiPhong= datPhongActivity.datPhong().getFACILITY_ID();
        int idLoaiCoSo= datPhongActivity.coSo().getIdCoSo();
        String tenLoaiPhong= datPhongActivity.coSo().getTenLoaiPhong();
        String tenPhong= datPhongActivity.coSo().getTenPhong();
        String tenCoso= datPhongActivity.coSo().getTenCoSo();
        String ngayDK= datPhongActivity.datPhong().getDATE_REGISTER();
        String ngayDat= datPhongActivity.datPhong().getDATE_SUGGEST_ROOM();
        String gioMuon= datPhongActivity.datPhong().getHOUR_SUGGEST_START();
        String gioTra= datPhongActivity.datPhong().getHOUR_SUGGEST_END();
        String SucChua= datPhongActivity.coSo().getSucChua();
        String thietBi= "";
        String yeucau= datPhongActivity.datPhong().getCONTENT_REQUEST();

        ThongTinPhong thongTinPhong = new ThongTinPhong(idDk, idLoaiPhong, idLoaiCoSo, tenLoaiPhong, tenPhong, tenCoso
                , ngayDK, ngayDat, gioMuon, gioTra, SucChua, thietBi, yeucau);
        return thongTinPhong;
    }

    @Override
    public void datPhongThatBai() {
        Toast.makeText(this, "Đặt phòng thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void datPhongThanhCong() {
//        GIOIHAN++;
        Toast.makeText(this, "Bạn đã đặt phòng thành công", Toast.LENGTH_SHORT).show();
        alertDialogThanhCong();
    }

    private void alertDialogThanhCong(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thành Công");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_informationbutton_blue);
        builder.setMessage("Phòng của bạn đã được thêm vào danh sách duyệt phòng. Xin vui lòng chờ Admin phê duyệt!");
        builder.setPositiveButton("Xong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(PhongGoiYMainActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void LoiKetNoiInternet() {
        Toast.makeText(datPhongActivity, "Vui lòng kiểm tra kết nối Internet", Toast.LENGTH_SHORT).show();
    }
}
