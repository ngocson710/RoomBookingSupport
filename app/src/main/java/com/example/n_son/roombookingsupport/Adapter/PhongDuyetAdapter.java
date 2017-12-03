package com.example.n_son.roombookingsupport.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Model.OjectClass.Phong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Presenter.PhongDangDuyet.PresentLogicPhongDangDuyet;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDangDuyet.PhongDuyetActivity;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDangDuyet.ViewPhongDangDuyet;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;

import java.util.List;

/**
 * Created by NSON on 11/22/2017.
 */

public class PhongDuyetAdapter extends RecyclerView.Adapter<PhongDuyetAdapter.ViewHolder> {
    Context context;
    int resource;
    List<ThongTinPhong> list;

    ImageView imgHinh;
    TextView txtTenPhong, txtTenCoSo, txtNgayDat, txtThoiGian;
    ImageButton imgbThongTin, imgbXoa;
    PresentLogicPhongDangDuyet presentLogicPhongDangDuyet;

    public PhongDuyetAdapter(Context context, int resource, List<ThongTinPhong> list) {
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout_phongduyet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        txtTenPhong.setText("Phòng "+list.get(position).getTenPhong());
        txtTenCoSo.setText(list.get(position).getTenCoSo());
        txtNgayDat.setText(list.get(position).getNgayMuon().substring(0,9));
        txtThoiGian.setText(list.get(position).getGioMuon().substring(0,5)+" - "+list.get(position).getGioTra().substring(0,5));
        imgbThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(list.get(position));
            }
        });
        imgbXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("kiemtraPhongDuyet", list.get(position).getIdDangKy()+"");
                final String idRegister= list.get(position).getIdDangKy()+"";

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
                builder.setTitle("Xóa Phòng");
                builder.setIcon(R.drawable.ic_informationbutton_blue);
                builder.setMessage("Bạn có muốn xóa phòng không?");
                builder.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("kiemtraIdregister", idRegister+"");
                        presentLogicPhongDangDuyet= new PresentLogicPhongDangDuyet((ViewPhongDangDuyet) context);
                        presentLogicPhongDangDuyet.XuLyXoaPhong(idRegister);
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                android.app.AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    protected void showCustomDialog(ThongTinPhong phong) {
        final Dialog dialog = new Dialog(context);
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
        tenphong.setText("Phòng "+phong.getTenPhong());
        ngayDK.setText(phong.getNgayDk().substring(0,9));
        ngayMon.setText(phong.getNgayMuon().substring(0,9));
        giomuon.setText(phong.getGioMuon().substring(0,5));
        gioTra.setText(phong.getGioTra().substring(0,5));
        loaiphong.setText(phong.getTenLoaiPhong());
        succhua.setText(phong.getSucChua());
        thietbi.setText(phong.getThietBi());
        yeucauthem.setText(phong.getYeuCau());
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            imgHinh= itemView.findViewById(R.id.img_pd_Hinh);
            txtTenPhong= itemView.findViewById(R.id.txt_pd_TenPhong);
            txtNgayDat= itemView.findViewById(R.id.txt_pd_NgayDat);
            txtTenCoSo= itemView.findViewById(R.id.txt_pd_TenCoSo);
            txtThoiGian= itemView.findViewById(R.id.txt_pd_ThoiGian);
            imgbThongTin= itemView.findViewById(R.id.img_pd_thongtin);
            imgbXoa= itemView.findViewById(R.id.img_pd_xoaphong);
        }
    }
}
