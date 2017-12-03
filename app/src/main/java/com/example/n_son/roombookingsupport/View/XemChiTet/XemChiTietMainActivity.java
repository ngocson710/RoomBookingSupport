package com.example.n_son.roombookingsupport.View.XemChiTet;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.n_son.roombookingsupport.Adapter.PhongDatAdapter;
import com.example.n_son.roombookingsupport.Adapter.ViewPaperAdapter;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThongTinPhong;
import com.example.n_son.roombookingsupport.Presenter.PhongDaDat.PresentLogicPhongDaDat;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDaDat.PhongDaDatActivity;
import com.example.n_son.roombookingsupport.View.DanhSachDatPhong.PhongDaDat.ViewPhongDaDat;

import java.util.ArrayList;

public class XemChiTietMainActivity extends AppCompatActivity {
    private ArrayList<ThongTinPhong> thongTinPhong;
    public ArrayList<ThongTinPhong> getThongTinPhong() {
        return thongTinPhong;
    }
    PhongDaDatActivity phongDaDatActivity;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_view_white,
            R.drawable.ic_add_white,
            R.drawable.ic_star_white
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xem_chi_tiet);
        phongDaDatActivity= new PhongDaDatActivity();
        thongTinPhong = phongDaDatActivity.thongTinPhongs;
        Log.i("thongTin", thongTinPhong.get(0).getGioMuon());
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        tabLayout= (TabLayout) findViewById(R.id.tabs);
        viewPager= (ViewPager) findViewById(R.id.viewpaper);

//        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ViewPaperAdapter viewPaperAdapter = new ViewPaperAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPaperAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }
}
