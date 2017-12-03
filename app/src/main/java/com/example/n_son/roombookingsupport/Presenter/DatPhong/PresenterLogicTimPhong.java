package com.example.n_son.roombookingsupport.Presenter.DatPhong;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.ConnectInternet.CheckInternet;
import com.example.n_son.roombookingsupport.Model.DatPhong.modelTimKiemPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.Facility;
import com.example.n_son.roombookingsupport.Model.OjectClass.TimKiemPhong;
import com.example.n_son.roombookingsupport.View.DatPhong.ViewTimPhong;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by NSON on 11/17/2017.
 */

public class PresenterLogicTimPhong implements presenterImpTimPhong {
    ViewTimPhong viewTimPhong;
    private static ArrayList<Facility> listPhong;

    public static ArrayList<Facility> getListPhong() {
        return listPhong;
    }

    public PresenterLogicTimPhong(ViewTimPhong viewTimPhong){
        this.viewTimPhong= viewTimPhong;
    }
    @Override
    public void hienThiPhong(TimKiemPhong timKiemPhong) {
        modelTimKiemPhong modelTimKiemPhong = new modelTimKiemPhong();
        String data = modelTimKiemPhong.LayDSPhong(timKiemPhong);
        listPhong = parseJsonTimKiemPhong(data);
        Log.i("LoiData", listPhong.toString());

        if(new CheckInternet().checknetwork((Context) viewTimPhong)){
            // nếu người dùng không nhập tên phòng
            if(timKiemPhong.getMaPhong().trim().equalsIgnoreCase("")){
                // nếu có nhập ngày giờ
                if(!timKiemPhong.getNgayMuon().equalsIgnoreCase("") && !timKiemPhong.getGioMuon().equalsIgnoreCase("")
                        && !timKiemPhong.getGioTra().equalsIgnoreCase("")){
                    // nếu có dữ liệu
                    if(!listPhong.toString().equalsIgnoreCase("[]")) {
                        viewTimPhong.goiYPhongTrucTiep();
                        Log.i("kiemtraPhong", listPhong.get(0).getFACILITY_NAME() + "==" + timKiemPhong.getMaPhong() + " và " + listPhong.get(0).getFACILITY_ID_ROOT() + "==" + timKiemPhong.getIdCoso());
                    }
                    // nếu không có dữ liệu trả ra
                    else{
                        viewTimPhong.khongCoPhongGoiY();
                    }
                }
                // nếu không nhập ngày giờ
                else{
                    viewTimPhong.loiNhapNgayGio();
                }
            }
            // nếu người dùng nhập tên phòng
            else{
                // nếu có dữ liệu
                if(!listPhong.toString().equalsIgnoreCase("[]")){
                    // và nếu dữ liệu trùng với thông tin người dùng đã nhập vào
                    if ((listPhong.get(0).getFACILITY_NAME().equalsIgnoreCase(timKiemPhong.getMaPhong())) && (listPhong.get(0).getFACILITY_ID_ROOT()==timKiemPhong.getIdCoso())){
                        viewTimPhong.hienThiPhongYeuCau();
                    }
                    else{
                        viewTimPhong.goiyDanhSachPhong();
                    }
                }
                // nếu không có dữ liệu
                else{
                    viewTimPhong.khongTimThayPhong();
                }
            }
        }
        else {
            viewTimPhong.LoiKetNoiInternet();
        }

    }

    public ArrayList<Facility> parseJsonTimKiemPhong(String dulieu){
        ArrayList<Facility> arrayList=  new ArrayList<>();
        try {
            JSONArray jsonRoot = new JSONArray(dulieu);
            for(int i=0; i<jsonRoot.length(); i++){
                JSONObject jsonObject= jsonRoot.getJSONObject(i);
                int FACILITY_ID= jsonObject.getInt("FACILITY_ID");
                String FACILITY_NAME= jsonObject.getString("FACILITY_NAME");
                int FACILITY_TYPE_ID= jsonObject.getInt("FACILITY_TYPE_ID");
                int FACILITY_ID_ROOT= jsonObject.getInt("FACILITY_ID_ROOT");
                String FACILITY_ADDRESS= jsonObject.getString("FACILITY_ADDRESS");
                int MAX_NUMBER_OF_PEOPLE= jsonObject.getInt("MAX_NUMBER_OF_PEOPLE");
                int SQUALL= jsonObject.getInt("SQUALL");
                String NOTE= jsonObject.getString("NOTE");
                Facility facility= new Facility(FACILITY_ID, FACILITY_NAME, FACILITY_TYPE_ID, FACILITY_ID_ROOT, FACILITY_ADDRESS, MAX_NUMBER_OF_PEOPLE, SQUALL, NOTE);
                arrayList.add(facility);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("Loi", "Lỗi parseJson Tìm kiếm phòng: "+e.toString());
        }
        return arrayList;
    }

}
