package com.example.n_son.roombookingsupport.Model.OjectClass;

/**
 * Created by NSON on 11/25/2017.
 */

public class ThietBi {
    int IdThietBi;
    String Ten;

    public ThietBi(int idThietBi, String ten) {
        IdThietBi = idThietBi;
        Ten = ten;
    }

    public int getIdThietBi() {
        return IdThietBi;
    }

    public void setIdThietBi(int idThietBi) {
        IdThietBi = idThietBi;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }
}
