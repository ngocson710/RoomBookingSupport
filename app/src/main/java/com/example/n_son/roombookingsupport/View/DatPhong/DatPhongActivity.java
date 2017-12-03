package com.example.n_son.roombookingsupport.View.DatPhong;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.n_son.roombookingsupport.Model.OjectClass.CoSo;
import com.example.n_son.roombookingsupport.Model.OjectClass.DatPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.Facility;
import com.example.n_son.roombookingsupport.Model.OjectClass.LoaiPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.TimKiemPhong;
import com.example.n_son.roombookingsupport.Model.OjectClass.User;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresenterLogicLoadCoSo;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresenterLogicTimPhong;
import com.example.n_son.roombookingsupport.Presenter.DatPhong.PresenterLoginLoadLoaiPhong;
import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;
import com.example.n_son.roombookingsupport.View.GoiYPhong.PhongGoiYMainActivity;
import com.example.n_son.roombookingsupport.View.ShowPhongTimKiem.ShowPhongTKMainActivity;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.sql.Types.NULL;

/**
 * Created by N-SON on 04/10/2017.
 */
public class DatPhongActivity extends AppCompatActivity implements ViewLoadSpinerCoSo, ViewLoadSpinerLoaiPhong, ViewTimPhong {
    Toolbar toolbar;
    EditText edtNgayMuon;
    EditText edtGioMuon;
    EditText edtGioTra;
    EditText edtMaPhong;
    Button btnTimKiemNgay;
    Spinner spinnerCoSo, spinerLoaiPhong;
    ArrayList<CoSo> coSoArrayList;
    ArrayList<LoaiPhong> loaiPhongArrayList;
    PresenterLogicLoadCoSo presenterLogicLoadCoSo;
    PresenterLoginLoadLoaiPhong presenterLoginLoadLoaiPhong;
    PresenterLogicTimPhong presenterLogicTimPhong;
    int IDCoSo;
    static String TenCoSo="";
    String SucChua;
    int IdLoaiPhong;
    static String tenphong= "";
    static String TenLoaiPhong= "";
    static String ngayMuon= "";
    static String gioMuon="";
    static String gioTra="";
    public static ArrayList<Facility> arrayListPhong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dat_phong_moi);
        anhXa();
        //khỏi gán giá trị rỗng cho edt
        edtMaPhong.setText("");
        edtNgayMuon.setText("");
        edtGioMuon.setText("");
        edtGioTra.setText("");

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        else{
            Toast.makeText(this, "Null Actionbar", Toast.LENGTH_SHORT).show();
        }

        //load dữ liệu cơ sở lên spinner
        presenterLogicLoadCoSo= new PresenterLogicLoadCoSo(this);
        presenterLogicLoadCoSo.KiemTraDuLieuCoSo();
        //load dữ liệu loại phòng lên spinner
        presenterLoginLoadLoaiPhong= new PresenterLoginLoadLoaiPhong(this);
        presenterLoginLoadLoaiPhong.KiemTraDuLieuLoaiPhong();

        //lấy vài dữ liệu trong spiner cơ sở : tên cơ sở, Id cở sở, sức chứa
        spinnerCoSo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TenCoSo= coSoArrayList.get(i).getTenCoSo();
                IDCoSo= coSoArrayList.get(i).getIdCoSo();
                SucChua= coSoArrayList.get(i).getSucChua();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //lấy vài dữ liệu trong spiner loại phòng: tên loại phòng, Id loại phòng
        spinerLoaiPhong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                IdLoaiPhong= loaiPhongArrayList.get(i).getIDLoaiPhong();
                TenLoaiPhong= loaiPhongArrayList.get(i).getTenLoaiPhong();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //khởi tạo đối tượng presenterLogicTimPhong
        presenterLogicTimPhong = new PresenterLogicTimPhong(this);

        // đăng ký sự kiện click
        btnTimKiemNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenphong = edtMaPhong.getText().toString();
                ngayMuon= edtNgayMuon.getText().toString();
                gioMuon= edtGioMuon.getText().toString();
                gioTra= edtGioTra.getText().toString();
                presenterLogicTimPhong.hienThiPhong(timKiemPhong());
            }
        });

    }

    private void anhXa(){
        btnTimKiemNgay= (Button) findViewById(R.id.btnTimKiemNgay);
        edtMaPhong = (EditText) findViewById(R.id.edt_maPhong);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        spinnerCoSo= (Spinner) findViewById(R.id.sp_coso);
        spinerLoaiPhong= (Spinner) findViewById(R.id.sp_loaiphong);
        edtNgayMuon = (EditText) findViewById(R.id.edit_ngaymuon);
        edtGioMuon= (EditText) findViewById(R.id.edt_gioMuon);
        edtGioTra= (EditText) findViewById(R.id.edt_giotra);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //sự kiện click edt ngày và giờ
    @Override
    protected void onStart() {
        super.onStart();
        edtNgayMuon.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    DateDialog date= new DateDialog(view);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    date.show(ft, "DatePicker");
                }
            }
        });

        edtGioMuon.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    TimeDialog time= new TimeDialog(view);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    time.show(ft, "TimePicker");
                }
            }
        });

        edtGioTra.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    TimeDialog time= new TimeDialog(view);
                    FragmentTransaction ft= getFragmentManager().beginTransaction();
                    time.show(ft, "TimePicker");
                }
            }
        });
    }

    @Override
    public void HienThiDuLieu_CoSo(ArrayList<CoSo> ListCoSo) {
        coSoArrayList = ListCoSo;
        ArrayList<String> arrayListCoSo= new ArrayList<>();
        for(int i=0; i<ListCoSo.size(); i++){
            String tenCoSo= ListCoSo.get(i).getTenCoSo();
            arrayListCoSo.add(tenCoSo);
        }
        ArrayAdapter<String> arrayAdapterCoSo = new ArrayAdapter<String>(this, R.layout.custom_spinner_item, arrayListCoSo);
        arrayAdapterCoSo.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinnerCoSo.setAdapter(arrayAdapterCoSo);
    }
    @Override
    public void LoiHienThi_CoSo() {
        Toast.makeText(this, "Lỗi Load dữ liệu Cơ sở", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoiKetNoiInternet() {
        Toast.makeText(this, "Vui lòng kiểm tra kết nối Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void HienThiDuLieu_LoaiPhong(ArrayList<LoaiPhong> listLoaiPhong) {
        loaiPhongArrayList= listLoaiPhong;
        ArrayList<String> arrayList= new ArrayList<>();
        for(int i= 0; i<listLoaiPhong.size(); i++){
            String tenLoaiPhong= listLoaiPhong.get(i).getTenLoaiPhong();
            arrayList.add(tenLoaiPhong);
        }

        ArrayAdapter<String> arrayAdapterLoaiPhong= new ArrayAdapter<String>(this, R.layout.custom_spinner_item, arrayList);
        arrayAdapterLoaiPhong.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinerLoaiPhong.setAdapter(arrayAdapterLoaiPhong);
    }
    @Override
    public void LoiHienThi_LoaiPhong() {
        Toast.makeText(this, "Lỗi Load dữ liệu Loại Phòng", Toast.LENGTH_SHORT).show();
    }



    //////////////////////////
    // xử lý chức năng Kiểm tra ngay
    @Override
    public void khongCoPhongGoiY() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.stat_sys_warning);
        builder.setTitle("Gợi ý phòng");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setMessage("Hiện tại đã hết "+TenLoaiPhong+" tại cơ sở "+ TenCoSo);
        builder.setPositiveButton("Tìm Lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                edtMaPhong.setText("");
                edtNgayMuon.setText("");
                edtGioMuon.setText("");
                edtGioTra.setText("");
                edtMaPhong.requestFocus();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intentt= new Intent(DatPhongActivity.this, TrangChuActivity.class);
                startActivity(intentt);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void loiNhapNgayGio() {
        Toast.makeText(this, "Vui lòng nhập Ngày và Thời gian", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hienThiPhongYeuCau() {
        //chuyển sang trang showphong đã tìm được
        Intent intentPhong = new Intent(DatPhongActivity.this, ShowPhongTKMainActivity.class);
        startActivity(intentPhong);
    }

    @Override
    public void goiyDanhSachPhong() {
        Toast.makeText(DatPhongActivity.this, "Không tìm thấy phòng!", Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Gợi ý phòng");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setMessage("Bạn có muốn gợi ý phòng không?");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayListPhong = PresenterLogicTimPhong.getListPhong();
                Intent intent =new Intent(DatPhongActivity.this, PhongGoiYMainActivity.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void goiYPhongTrucTiep() {
        arrayListPhong = PresenterLogicTimPhong.getListPhong();
        Intent intent =new Intent(DatPhongActivity.this, PhongGoiYMainActivity.class);
        startActivity(intent);
    }

    @Override
    public void khongTimThayPhong() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Tìm phòng!");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setMessage("Không tìm thấy kết quả gợi ý nào phù hợp");
        builder.setPositiveButton("Tìm lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                edtMaPhong.setText("");
                edtNgayMuon.setText("");
                edtGioMuon.setText("");
                edtGioTra.setText("");
                edtMaPhong.requestFocus();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent =new Intent(DatPhongActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    TimKiemPhong timKiemPhong(){
        String MaPhong= edtMaPhong.getText().toString();
        String NgayMuon= edtNgayMuon.getText().toString();
        String GioMuon= edtGioTra.getText().toString();
        String GioTra= edtGioTra.getText().toString();
        TimKiemPhong timKiemPhong = new TimKiemPhong(IDCoSo, IdLoaiPhong, MaPhong, NgayMuon, GioMuon, GioTra);
        return timKiemPhong;
    }

    public DatPhong datPhong(){
        User user= DangNhapActivity.thongTinUser();
        int USER_REGISTER_ID = user.getUserId();
        String USER_NAME = user.getUserName();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String DATE_REGISTER = dateFormat.format(date);

        arrayListPhong = PresenterLogicTimPhong.getListPhong();
        int FACILITY_ID = arrayListPhong.get(0).getFACILITY_ID();
        Log.i("TenPhongLa",USER_REGISTER_ID+"--"+USER_NAME+"--"+DATE_REGISTER+"--"
                +FACILITY_ID+"--"+ngayMuon+"--"+gioMuon+"--"+ gioTra);
        DatPhong datPhong = new DatPhong(USER_REGISTER_ID, USER_NAME, DATE_REGISTER, FACILITY_ID, ngayMuon, gioMuon, gioTra
                , 0, 0, 0, 0
                , 0, 0, 0, 0
                , 0, 0, "");

        return datPhong;
    }

    public CoSo coSo(){
        CoSo coSo= new CoSo(IDCoSo, TenLoaiPhong,  tenphong, TenCoSo, SucChua);
        return coSo;
    }

}
