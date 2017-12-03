package com.example.n_son.roombookingsupport.View.ShowPhongTimKiem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Adapter.DanhSachPhongAdapter;
import com.example.n_son.roombookingsupport.Model.OjectClass.DatPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.Facility;
import com.example.n_son.roombookingsupport.Model.OjectClass.Phong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresentLogicDatPhong;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresenterLogicTimPhong;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;
import com.example.n_son.roombookingsupport.View.DatPhong.DatPhongActivity;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;
import com.example.n_son.roombookingsupport.View.YeuCauDatPhong.YeuCauDatPhongActivity;

import java.util.ArrayList;
import java.util.List;

public class ShowPhongTKMainActivity extends AppCompatActivity implements ViewShowPhong{

    ImageButton imgThongTin, imgDatPhong;
    TextView txtTenPhong, txtTenCoSo, txtNgayDat, txtThoiGian;
    DatPhongActivity datPhongActivity;
    PresentLogicDatPhong presentLogicDatPhong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_phong_searched);
        AnhXa();
        // lấy giá trị đối tượng datPhong
        datPhongActivity= new DatPhongActivity();


        txtTenPhong.setText("Phòng "+datPhongActivity.coSo().getTenPhong());
        txtTenCoSo.setText(datPhongActivity.coSo().getTenCoSo());
        txtNgayDat.setText(datPhongActivity.datPhong().getDATE_REGISTER());
        txtThoiGian.setText(datPhongActivity.datPhong().getHOUR_SUGGEST_START()+" - "
                + datPhongActivity.datPhong().getHOUR_SUGGEST_END());

        imgThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(thongTinPhong());
            }
        });

        imgDatPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogDatPhong();
            }
        });

        presentLogicDatPhong= new PresentLogicDatPhong(this);
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

    protected void showCustomDialog(ThongTinPhong phong) {
        final Dialog dialog = new Dialog(ShowPhongTKMainActivity.this);
        dialog.setTitle("Thông Tin Phòng");
        dialog.setContentView(R.layout.custom_dialog_thongtinphong);
        TextView TenCoSo = dialog.findViewById(R.id.txt_CScoso);
        TextView tenphong = dialog.findViewById(R.id.txt_CSTenPhong);
        TextView ngayDK = dialog.findViewById(R.id.txt_CSngayDangKy);
        TextView ngayMon = dialog.findViewById(R.id.txt_CSngayMuon);
        TextView giomuon = dialog.findViewById(R.id.txt_CSgioMuon);
        TextView gioTra = dialog.findViewById(R.id.txt_CSgioTra);
        TextView loaiphong = dialog.findViewById(R.id.txt_CSLoaiPhong);
        TextView succhua = dialog.findViewById(R.id.txt_CSsucChua);
        TextView thietbi = dialog.findViewById(R.id.txt_CSthietBi);
        TextView yeucauthem = dialog.findViewById(R.id.txt_CSyeuCau);

        TenCoSo.setText(phong.getTenCoSo());
        tenphong.setText(phong.getTenPhong());
        ngayDK.setText(phong.getNgayDk());
        ngayMon.setText(phong.getNgayMuon());
        giomuon.setText(phong.getGioMuon());
        gioTra.setText(phong.getGioTra());
        loaiphong.setText(phong.getTenLoaiPhong());
        succhua.setText(phong.getSucChua());
        thietbi.setText(phong.getThietBi());
        yeucauthem.setText(phong.getYeuCau());
        dialog.show();
    }

    private Phong phong(){
        String tenPhong= "Phòng "+datPhongActivity.coSo().getTenPhong();
        String tenCoSo= datPhongActivity.coSo().getTenCoSo();
        String ngayDat= datPhongActivity.datPhong().getDATE_SUGGEST_ROOM();
        String gioMuon= datPhongActivity.datPhong().getHOUR_SUGGEST_START();
        String gioTra= datPhongActivity.datPhong().getHOUR_SUGGEST_END();
        Log.i("KiemtraShowPhong", "tenPhong= "+tenPhong+" tencoso= "+tenCoSo+" ngaydat= "
                +ngayDat+" giomuon= "+gioMuon+ " giotra= "+gioTra);
        Phong phong= new Phong(R.color.bgtoolbar, tenPhong, tenCoSo, ngayDat, gioMuon, gioTra);
        return phong;
    }

    private void AnhXa(){
        txtTenPhong= (TextView) findViewById(R.id.txtTenPhong);
        txtTenCoSo= (TextView) findViewById(R.id.txtTenCoSo);
        txtNgayDat= (TextView) findViewById(R.id.txtNgayDat);
        txtThoiGian= (TextView) findViewById(R.id.txtThoiGian);

        imgThongTin= (ImageButton) findViewById(R.id.img_thongtin);
        imgDatPhong = (ImageButton) findViewById(R.id.img_datphong);
    }

    private void alertDialogDatPhong(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Đặt Phòng");
        builder.setIcon(R.drawable.ic_informationbutton_blue);
        builder.setMessage("Bạn có muốn thêm yêu cầu cho phòng không?");
        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(ShowPhongTKMainActivity.this, YeuCauDatPhongActivity.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Đặt Phòng Ngay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatPhongActivity datPhongActivity = new DatPhongActivity();
                presentLogicDatPhong.xuLyDatPhong(datPhongActivity.datPhong());
                Intent intent= new Intent(ShowPhongTKMainActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
                Thread thread= new Thread();
                try {
                    thread.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent= new Intent(ShowPhongTKMainActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    //////////////////
    @Override
    public void datPhongThanhCong() {
        alertDialogThanhCong();
    }

    @Override
    public void datPhongThatBai() {
        Toast.makeText(ShowPhongTKMainActivity.this, "đặt phòng thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoiKetNoiInternet() {

        Toast.makeText(this, "Vui lòng kiểm tra kết nối Internet", Toast.LENGTH_SHORT).show();
    }
}
