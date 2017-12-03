package com.example.n_son.roombookingsupport.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresentLogicDatPhong;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DatPhong.DatPhongActivity;
import com.example.n_son.roombookingsupport.View.ShowPhongTimKiem.ViewShowPhong;
import com.example.n_son.roombookingsupport.View.YeuCauDatPhong.YeuCauDatPhongActivity;

import java.util.List;

/**
 * Created by NSON on 11/20/2017.
 */

public class DanhSachPhongAdapter extends RecyclerView.Adapter<DanhSachPhongAdapter.ViewHolder>{

    Context context;
    int resource;
    List<ThongTinPhong> list;

    ImageView imgHinh;
    TextView txtTenPhong, txtTenCoSo, txtNgayDat, txtThoiGian;
    ImageButton imgbThongTin, imgbDatPhong;
    PresentLogicDatPhong presentLogicDatPhong;


    public DanhSachPhongAdapter(Context context, int resource, List<ThongTinPhong> list) {
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        presentLogicDatPhong = new PresentLogicDatPhong((ViewShowPhong) context);
        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout_danhsachphong, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        txtTenPhong.setText(list.get(position).getTenPhong());
        txtTenCoSo.setText(list.get(position).getTenCoSo());
        txtNgayDat.setText(list.get(position).getNgayMuon());
        txtThoiGian.setText(list.get(position).getGioMuon()+" - "+list.get(position).getGioTra());

        imgbThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(list.get(position));
            }
        });


        imgbDatPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
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

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            imgHinh= itemView.findViewById(R.id.imgHinh);
            txtTenPhong= itemView.findViewById(R.id.txtTenPhong);
            txtNgayDat= itemView.findViewById(R.id.txtNgayDat);
            txtTenCoSo= itemView.findViewById(R.id.txtTenCoSo);
            txtThoiGian= itemView.findViewById(R.id.txtThoiGian);
            imgbThongTin= itemView.findViewById(R.id.img_thongtin);
            imgbDatPhong= itemView.findViewById(R.id.img_datphong);
        }

    }
    private void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Đặt Phòng");
        builder.setIcon(R.drawable.ic_informationbutton_blue);
        builder.setMessage("Bạn có muốn thêm yêu cầu cho phòng không?");
        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(context, YeuCauDatPhongActivity.class);
                context.startActivity(intent);
            }
        });

        builder.setNegativeButton("Đặt Phòng Ngay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatPhongActivity datPhongActivity = new DatPhongActivity();
                presentLogicDatPhong.xuLyDatPhong(datPhongActivity.datPhong());
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
