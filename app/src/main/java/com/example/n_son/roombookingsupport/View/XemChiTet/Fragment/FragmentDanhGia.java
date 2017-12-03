package com.example.n_son.roombookingsupport.View.XemChiTet.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.n_son.roombookingsupport.R;

/**
 * Created by N-SON on 06/10/2017.
 */

public class FragmentDanhGia extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.layout_fragment_danhgia, container, false);
        return view;
    }
}