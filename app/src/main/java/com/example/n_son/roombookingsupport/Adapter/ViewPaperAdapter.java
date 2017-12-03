package com.example.n_son.roombookingsupport.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.n_son.roombookingsupport.View.XemChiTet.Fragment.FragmentDanhGia;
import com.example.n_son.roombookingsupport.View.XemChiTet.Fragment.FragmentThemThanhVien;
import com.example.n_son.roombookingsupport.View.XemChiTet.Fragment.FragmentThongTinPhong;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by N-SON on 06/10/2017.
 */

public class ViewPaperAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragment = new ArrayList<Fragment>();
    List<String> titleFragment =new ArrayList<String>();

    public ViewPaperAdapter(FragmentManager fm) {
        super(fm);

        listFragment.add(new FragmentThongTinPhong());
        listFragment.add(new FragmentThemThanhVien());
        listFragment.add(new FragmentDanhGia());

        titleFragment.add("Thông Tin");
        titleFragment.add("Thêm");
        titleFragment.add("Đánh Giá");
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
