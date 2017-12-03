package com.example.n_son.roombookingsupport.View.YeuCauDatPhong;

import com.example.n_son.roombookingsupport.Model.OjectClass.ThietBi;

import java.util.ArrayList;

/**
 * Created by NSON on 11/25/2017.
 */

public interface ViewYeuCau {

    void LoiKetNoiInternet();

    void khongCoThietBi();

    void loadThietBi(ArrayList<ThietBi> arrayList);
}
