package com.example.n_son.roombookingsupport.Model.DatPhong;

import android.util.Log;

import com.example.n_son.roombookingsupport.ConnectInternet.DownloadJSon;
import com.example.n_son.roombookingsupport.Model.OjectClass.DatPhong;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by NSON on 11/8/2017.
 */

public class modelDatPhongMoi {

    public boolean datphong(DatPhong datPhong){
        Log.i("datPhong_getUSER",datPhong.getUSER_REGISTER_ID()+"");
        Log.i("datPhong_getUSER",datPhong.getUSER_NAME()+"");
        Log.i("datPhong_getUSER",datPhong.getDATE_REGISTER()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_ID()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_1()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_2()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_3()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_4()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_5()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_6()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_7()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_8()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_9()+"");
        Log.i("datPhong_getUSER",datPhong.getFACILITY_COMPONENT_ID_10()+"");
        Log.i("datPhong_getUSER",datPhong.getHOUR_SUGGEST_START()+"");
        Log.i("datPhong_getUSER",datPhong.getHOUR_SUGGEST_END()+"");
        Log.i("datPhong_getUSER",datPhong.getCONTENT_REQUEST()+"");
        String dulieu="";

        String duongdan= DangNhapActivity.SERVERNAME+ "api/Booking";
        List<HashMap<String, String>> hashMapArrayList= new ArrayList<>();

        HashMap<String, String> hsUSER_REGISTER_ID= new HashMap<>();
        hsUSER_REGISTER_ID.put("USER_REGISTER_ID", String.valueOf(datPhong.getUSER_REGISTER_ID()));

        HashMap<String, String> USER_NAME= new HashMap<>();
        USER_NAME.put("USER_NAME",datPhong.getUSER_NAME());

        HashMap<String, String> DATE_REGISTER= new HashMap<>();
        DATE_REGISTER.put("DATE_REGISTER",datPhong.getDATE_REGISTER());

        HashMap<String, String> FACILITY_ID= new HashMap<>();
        FACILITY_ID.put("FACILITY_ID", String.valueOf(datPhong.getFACILITY_ID()));

        HashMap<String, String> DATE_SUGGEST_ROOM= new HashMap<>();
        DATE_SUGGEST_ROOM.put("DATE_SUGGEST_ROOM",datPhong.getDATE_SUGGEST_ROOM());

        HashMap<String, String> HOUR_SUGGEST_START= new HashMap<>();
        HOUR_SUGGEST_START.put("HOUR_SUGGEST_START",datPhong.getHOUR_SUGGEST_START());

        HashMap<String, String> HOUR_SUGGEST_END= new HashMap<>();
        HOUR_SUGGEST_END.put("HOUR_SUGGEST_END",datPhong.getHOUR_SUGGEST_END());

        HashMap<String, String> FACILITY_COMPONENT_ID_1= new HashMap<>();
        FACILITY_COMPONENT_ID_1.put("FACILITY_COMPONENT_ID_1", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_1()));

        HashMap<String, String> FACILITY_COMPONENT_ID_2= new HashMap<>();
        FACILITY_COMPONENT_ID_2.put("FACILITY_COMPONENT_ID_2", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_2()));

        HashMap<String, String> FACILITY_COMPONENT_ID_3= new HashMap<>();
        FACILITY_COMPONENT_ID_3.put("FACILITY_COMPONENT_ID_3", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_3()));

        HashMap<String, String> FACILITY_COMPONENT_ID_4= new HashMap<>();
        FACILITY_COMPONENT_ID_4.put("FACILITY_COMPONENT_ID_4", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_4()));

        HashMap<String, String> FACILITY_COMPONENT_ID_5= new HashMap<>();
        FACILITY_COMPONENT_ID_5.put("FACILITY_COMPONENT_ID_5", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_5()));

        HashMap<String, String> FACILITY_COMPONENT_ID_6= new HashMap<>();
        FACILITY_COMPONENT_ID_6.put("FACILITY_COMPONENT_ID_6", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_6()));

        HashMap<String, String> FACILITY_COMPONENT_ID_7= new HashMap<>();
        FACILITY_COMPONENT_ID_7.put("FACILITY_COMPONENT_ID_7", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_7()));

        HashMap<String, String> FACILITY_COMPONENT_ID_8= new HashMap<>();
        FACILITY_COMPONENT_ID_8.put("FACILITY_COMPONENT_ID_8", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_8()));

        HashMap<String, String> FACILITY_COMPONENT_ID_9= new HashMap<>();
        FACILITY_COMPONENT_ID_9.put("FACILITY_COMPONENT_ID_9", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_9()));

        HashMap<String, String> FACILITY_COMPONENT_ID_10= new HashMap<>();
        FACILITY_COMPONENT_ID_10.put("FACILITY_COMPONENT_ID_10", String.valueOf(datPhong.getFACILITY_COMPONENT_ID_10()));

        HashMap<String, String> CONTENT_REQUEST= new HashMap<>();
        CONTENT_REQUEST.put("CONTENT_REQUEST",datPhong.getCONTENT_REQUEST());

        HashMap<String, String> STATUS_APPROVE= new HashMap<>();
        STATUS_APPROVE.put("STATUS_APPROVE","");

        HashMap<String, String> USER_ID_APPROVE= new HashMap<>();
        USER_ID_APPROVE.put("USER_ID_APPROVE","");

        hashMapArrayList.add(hsUSER_REGISTER_ID);
        hashMapArrayList.add(USER_NAME);
        hashMapArrayList.add(DATE_REGISTER);
        hashMapArrayList.add(FACILITY_ID);
        hashMapArrayList.add(DATE_SUGGEST_ROOM);
        hashMapArrayList.add(HOUR_SUGGEST_START);
        hashMapArrayList.add(HOUR_SUGGEST_END);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_1);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_2);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_3);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_4);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_5);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_6);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_7);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_8);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_9);
        hashMapArrayList.add(FACILITY_COMPONENT_ID_10);
        hashMapArrayList.add(CONTENT_REQUEST);
        hashMapArrayList.add(STATUS_APPROVE );
        hashMapArrayList.add(USER_ID_APPROVE);

        Log.i("duongdbanDatPhong", duongdan);

        boolean ketqua = false;
        DownloadJSon downloadJSon= new DownloadJSon(duongdan, hashMapArrayList);
        downloadJSon.execute();

        try {
            dulieu = downloadJSon.get();
            Log.i("KiemtraDatPhong", dulieu);

            if(dulieu.equalsIgnoreCase("true")){
                ketqua= true;
            }
            else{
                ketqua= false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return ketqua;
    }
}
