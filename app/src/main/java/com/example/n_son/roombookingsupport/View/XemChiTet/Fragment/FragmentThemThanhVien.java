package com.example.n_son.roombookingsupport.View.XemChiTet.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.TrangChu.TrangChuActivity;

/**
 * Created by N-SON on 06/10/2017.
 */

public class FragmentThemThanhVien extends Fragment {
    EditText edtTo, edtSubject, edtcontent;
    Button btnSend, btnHuy;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_fragment_themthanhvien, container, false);
        edtTo= (EditText) view.findViewById(R.id.edtTo);
        edtSubject= (EditText) view.findViewById(R.id.edtSubjectt);
        edtcontent= (EditText) view.findViewById(R.id.edtContent);
        btnSend = (Button) view.findViewById(R.id.btnThongBao);
        btnHuy = (Button) view.findViewById(R.id.btnHuy);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to= edtTo.getText().toString();
                String subject= edtSubject.getText().toString();
                String content= edtcontent.getText().toString();

                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, content);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Chọn Email app..."));
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getActivity(), TrangChuActivity.class);
                startActivity(it);
            }
        });
        return view;
    }
}
