package com.example.n_son.roombookingsupport.View.XemChiTet.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.n_son.roombookingsupport.Adapter.PhongDatAdapter;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDaDat.PhongDaDatActivity;
import com.example.n_son.roombookingsupport.View.XemChiTet.XemChiTietMainActivity;

import java.util.ArrayList;

/**
 * Created by N-SON on 06/10/2017.
 */

public class FragmentThongTinPhong extends Fragment {
    ThongTinPhong phong;
    XemChiTietMainActivity xemChiTietMainActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dialog= inflater.inflate(R.layout.layout_fragment_thongtinphong, container, false);
        TextView TenCoSo = dialog.findViewById(R.id.textViewCoSo);
        TextView tenphong = dialog.findViewById(R.id.textViewphong);
        TextView ngayDK = dialog.findViewById(R.id.textViewngayDK);
        TextView ngayMon = dialog.findViewById(R.id.textViewngaymuon);
        TextView giomuon = dialog.findViewById(R.id.textViewgiomuon);
        TextView gioTra = dialog.findViewById(R.id.textViewgiotra);
        TextView loaiphong = dialog.findViewById(R.id.textViewloaiphong);
        TextView succhua = dialog.findViewById(R.id.textViewsucchua);
        TextView thietbi = dialog.findViewById(R.id.textViewthietbi);
        TextView yeucauthem = dialog.findViewById(R.id.textViewyeucau);

        int i= new PhongDatAdapter((XemChiTietMainActivity) getActivity()).vitri;
        xemChiTietMainActivity = (XemChiTietMainActivity) getActivity();
        phong = xemChiTietMainActivity.getThongTinPhong().get(i);
        Log.i("kiemtrafrg", phong.getTenPhong());
        TenCoSo.setText(phong.getTenCoSo());
        tenphong.setText(phong.getTenPhong());
        ngayDK.setText(phong.getNgayDk().substring(0,9));
        ngayMon.setText(phong.getNgayMuon().substring(0,9));
        giomuon.setText(phong.getGioMuon().substring(0,5));
        gioTra.setText(phong.getGioTra().substring(0,5));
        loaiphong.setText(phong.getTenLoaiPhong());
        succhua.setText(phong.getSucChua());
        thietbi.setText(phong.getThietBi());
        yeucauthem.setText(phong.getYeuCau());
        return dialog;
    }

}
