package com.example.n_son.roombookingsupport.Adapter.YeuCauDatPhong;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.n_son.roombookingsupport.Model.OjectClass.ItemYeuCau;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThietBi;
import com.example.n_son.roombookingsupport.R;

import java.util.List;
import java.util.logging.LogRecord;

/**
 * Created by NSON on 11/25/2017.
 */

public class YeuCauAdapter extends BaseAdapter{
    Context context;
    int resource;
    List<ItemYeuCau> list;

    public YeuCauAdapter(Context context, int resource, List<ItemYeuCau> list) {
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.custom_yeucau, viewGroup, false);
        TextView txtTen, txtGhiChu;
        txtTen= view.findViewById(R.id.txttenthietbi);
        txtGhiChu= view.findViewById(R.id.txtChuThich);
        txtTen.setText(list.get(i).getTenThietBi());
        txtGhiChu.setText(list.get(i).getGhiChu());

        for(int j=0; j<list.size(); j++){
            Log.i("Kiemtrayeucau1", list.get(j).getTenThietBi()+"--"+ list.get(j).getGhiChu());
        }
        return view;
    }
}
