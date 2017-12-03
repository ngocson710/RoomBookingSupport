package com.example.n_son.roombookingsupport.View.YeuCauDatPhong;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n_son.roombookingsupport.Adapter.YeuCauDatPhong.YeuCauAdapter;
import com.example.n_son.roombookingsupport.Model.OjectClass.DatPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.ItemYeuCau;
import com.example.n_son.roombookingsupport.Model.OjectClass.ThietBi;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresentLogicDatPhong;
import com.example.n_son.roombookingsupport.Presenter.YeuCau.PresentLogicYeuCau;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DatPhong.DatPhongActivity;
import com.example.n_son.roombookingsupport.View.ShowPhongTimKiem.ShowPhongTKMainActivity;
import com.example.n_son.roombookingsupport.View.ShowPhongTimKiem.ViewShowPhong;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;

import java.util.ArrayList;
import java.util.Collections;

public class YeuCauDatPhongActivity extends AppCompatActivity implements ViewYeuCau, View.OnClickListener, ViewShowPhong {
    Spinner spinner;
    int position=0;

    PresentLogicYeuCau presentLogicYeuCau;
    ArrayList<String> listTenThietBi_Root;
    ArrayList<Integer> listIdThietBi_Root;
    ArrayList<Integer> thietBiId_adapter;
    ArrayList<ItemYeuCau> thietbilist_adapter = new ArrayList<>();

    YeuCauAdapter yeuCauAdapter;
    Button btnThem, btnXoa, btnhoanthanh, btntrolai;
    EditText edtghichu, edtyeucaukhac;
    ListView listView;
    PresentLogicDatPhong presentLogicDatPhong;
    private  static int dem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_yeucauthem);
        spinner = (Spinner) findViewById(R.id.spThietBi);
        btnThem= (Button) findViewById(R.id.btnThem);
        btnXoa= (Button) findViewById(R.id.btnXoa);
        listView= (ListView) findViewById(R.id.txtDsThem);
        edtghichu= (EditText) findViewById(R.id.edtghichu);
        edtyeucaukhac= (EditText) findViewById(R.id.edtyeucaukhac);
        btnhoanthanh= (Button) findViewById(R.id.btnHoanThanh);
        btntrolai= (Button) findViewById(R.id.btntrolai);

        presentLogicYeuCau= new PresentLogicYeuCau(this);
        presentLogicYeuCau.xuLyDSThietBi();

        btnThem.setOnClickListener(this);
        btnXoa.setOnClickListener(this);
        btnhoanthanh.setOnClickListener(this);
        btntrolai.setOnClickListener(this);
        thietBiId_adapter = new ArrayList<>();

        presentLogicDatPhong= new PresentLogicDatPhong(this);
    }

    // ViewShowPhong///////////////////////////////////////////////////////////////////////////////////
    @Override
    public void datPhongThanhCong() {
        alertDialogThanhCong();
    }

    @Override
    public void datPhongThatBai() {
        Toast.makeText(this, "Đặt phòng thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoiKetNoiInternet() {
        Toast.makeText(this, "Vui lòng kiểm tra kết nối Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void khongCoThietBi() {
        Toast.makeText(this, "Không có thiết bị nào", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadThietBi(ArrayList<ThietBi> arrayList) {
        listTenThietBi_Root = new ArrayList<>();
        listIdThietBi_Root= new ArrayList<>();
        for(int i=0; i<arrayList.size(); i++){
            listTenThietBi_Root.add(arrayList.get(i).getTen());
            listIdThietBi_Root.add(arrayList.get(i).getIdThietBi());
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, R.layout.custom_spinner_item, listTenThietBi_Root);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnThem:
                xulyThem();
                yeuCauAdapter.notifyDataSetChanged();
                break;
            case R.id.btnXoa:
                Xoa();
                break;
            case R.id.btnHoanThanh:
                presentLogicDatPhong.xuLyDatPhong(datPhong());
                break;
        }
    }

    private DatPhong datPhong(){
        DatPhong d = new DatPhongActivity().datPhong();
        switch (thietBiId_adapter.size()){
            case 1:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                break;
            case 2:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                break;
            case 3:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                break;
            case 4:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                d.setFACILITY_COMPONENT_ID_4(thietBiId_adapter.get(3));
                break;
            case 5:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                d.setFACILITY_COMPONENT_ID_4(thietBiId_adapter.get(3));
                d.setFACILITY_COMPONENT_ID_5(thietBiId_adapter.get(4));
                break;
            case 6:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                d.setFACILITY_COMPONENT_ID_4(thietBiId_adapter.get(3));
                d.setFACILITY_COMPONENT_ID_5(thietBiId_adapter.get(4));
                d.setFACILITY_COMPONENT_ID_6(thietBiId_adapter.get(5));
                break;
            case 7:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                d.setFACILITY_COMPONENT_ID_4(thietBiId_adapter.get(3));
                d.setFACILITY_COMPONENT_ID_5(thietBiId_adapter.get(4));
                d.setFACILITY_COMPONENT_ID_6(thietBiId_adapter.get(5));
                d.setFACILITY_COMPONENT_ID_7(thietBiId_adapter.get(6));
                break;
            case 8:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                d.setFACILITY_COMPONENT_ID_4(thietBiId_adapter.get(3));
                d.setFACILITY_COMPONENT_ID_5(thietBiId_adapter.get(4));
                d.setFACILITY_COMPONENT_ID_6(thietBiId_adapter.get(5));
                d.setFACILITY_COMPONENT_ID_7(thietBiId_adapter.get(6));
                d.setFACILITY_COMPONENT_ID_8(thietBiId_adapter.get(7));
                break;
            case 9:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                d.setFACILITY_COMPONENT_ID_4(thietBiId_adapter.get(3));
                d.setFACILITY_COMPONENT_ID_5(thietBiId_adapter.get(4));
                d.setFACILITY_COMPONENT_ID_6(thietBiId_adapter.get(5));
                d.setFACILITY_COMPONENT_ID_7(thietBiId_adapter.get(6));
                d.setFACILITY_COMPONENT_ID_8(thietBiId_adapter.get(7));
                d.setFACILITY_COMPONENT_ID_9(thietBiId_adapter.get(8));
                break;
            case 10:
                d.setFACILITY_COMPONENT_ID_1(thietBiId_adapter.get(0));
                d.setFACILITY_COMPONENT_ID_2(thietBiId_adapter.get(1));
                d.setFACILITY_COMPONENT_ID_3(thietBiId_adapter.get(2));
                d.setFACILITY_COMPONENT_ID_4(thietBiId_adapter.get(3));
                d.setFACILITY_COMPONENT_ID_5(thietBiId_adapter.get(4));
                d.setFACILITY_COMPONENT_ID_6(thietBiId_adapter.get(5));
                d.setFACILITY_COMPONENT_ID_7(thietBiId_adapter.get(6));
                d.setFACILITY_COMPONENT_ID_8(thietBiId_adapter.get(7));
                d.setFACILITY_COMPONENT_ID_9(thietBiId_adapter.get(8));
                d.setFACILITY_COMPONENT_ID_10(thietBiId_adapter.get(9));
                break;
        }
        String yeucau="";
        for(int i=0; i<thietbilist_adapter.size(); i++){
            yeucau= "Tên thiết bị: "+ thietbilist_adapter.get(i).getTenThietBi()+"\n Ghi Chú: "+ thietbilist_adapter.get(i).getTenThietBi();
        }
        d.setCONTENT_REQUEST(yeucau+"\nYêu cầu khác: "+edtyeucaukhac.getText().toString());
        return  d;
    }

    private void xulyThem(){
        if(dem <=10){
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    position= i;
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            String tenThietBi = listTenThietBi_Root.get(position);
            String ghichu = edtghichu.getText().toString();

            thietbilist_adapter.add(new ItemYeuCau(tenThietBi, ghichu));
            thietBiId_adapter.add(listIdThietBi_Root.get(position));

            yeuCauAdapter = new YeuCauAdapter(this, R.layout.custom_yeucau, thietbilist_adapter);
            listView.setAdapter(yeuCauAdapter);
            edtghichu.setText("");
            yeuCauAdapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(this, "không được thêm quá 10 yêu cầu", Toast.LENGTH_SHORT).show();
        }

    }

    private void Xoa(){
            Collections.reverse(thietbilist_adapter);
            Collections.reverse(thietBiId_adapter);
            if(thietbilist_adapter.size()<1){
                Toast.makeText(this, "Chưa có yêu cầu nào!", Toast.LENGTH_SHORT).show();
            }
            else{
                dem--;
                thietbilist_adapter.remove(thietbilist_adapter.size()-1);
                thietBiId_adapter.remove(thietBiId_adapter.size()-1);
//                thietBiArrayList.get(thietBiArrayList.size()+1).setIdThietBi(0);
                yeuCauAdapter.notifyDataSetChanged();
            }
    }

    private void alertDialogThanhCong(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thành Công");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_informationbutton_blue);
        builder.setMessage("Phòng của bạn đã được thêm vào danh sách duyệt phòng. Xin vui lòng chờ Admin phê duyệt!");
        builder.setPositiveButton("Xong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(YeuCauDatPhongActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
