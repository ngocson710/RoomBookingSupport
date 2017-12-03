package com.example.n_son.roombookingsupport.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Model.OjectClass.Phong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.XemChiTet.XemChiTietMainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NSON on 11/22/2017.
 */

public class PhongDatAdapter extends RecyclerView.Adapter<PhongDatAdapter.ViewHolder>{
    Context context;
    int resource;
    List<ThongTinPhong> list;



    ImageView imgHinh;
    TextView txtTenPhong, txtTenCoSo, txtNgayDat, txtThoiGian;
    ImageButton imgbThongTin, imgbXoa;

    public static int vitri;

    public List<ThongTinPhong> getList() {
        return list;
    }

    public PhongDatAdapter(XemChiTietMainActivity xemChiTietMainActivity) {
    }

    public PhongDatAdapter(Context context, int resource, ArrayList<ThongTinPhong> list) {
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public PhongDatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout_phongdadat, parent, false);
        return new PhongDatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhongDatAdapter.ViewHolder holder, final int position) {
        txtTenPhong.setText("Phòng "+list.get(position).getTenPhong());
        txtTenCoSo.setText(list.get(position).getTenCoSo());
        txtNgayDat.setText(list.get(position).getNgayMuon().substring(0,9));
        txtThoiGian.setText(list.get(position).getGioMuon().substring(0,5)+" - "+list.get(position).getGioTra().substring(0,5));

        imgbThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vitri= position;
                Intent intent= new Intent(context, XemChiTietMainActivity.class);
                context.startActivity(intent);
            }
        });

        imgbXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ViewHolder(View itemView) {
            super(itemView);
            imgHinh= itemView.findViewById(R.id.img__Hinh);
            txtTenPhong= itemView.findViewById(R.id.txt__TenPhong);
            txtNgayDat= itemView.findViewById(R.id.txt__NgayDat);
            txtTenCoSo= itemView.findViewById(R.id.txt__TenCoSo);
            txtThoiGian= itemView.findViewById(R.id.txt__ThoiGian);
            imgbThongTin= itemView.findViewById(R.id.img__thongtin);
            imgbXoa= itemView.findViewById(R.id.img__xoaphong);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
