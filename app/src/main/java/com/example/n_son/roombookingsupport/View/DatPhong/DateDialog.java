package com.example.n_son.roombookingsupport.View.DatPhong;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by N-SON on 27/10/2017.
 */

@SuppressLint("ValidFragment")
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    EditText txtdate;
    public DateDialog(View view){
        this.txtdate= (EditText) view;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//        String date = day+ "/" +(month+1)+ "/" +year;
        String date1 = (month+1)+"/" +day+ "/"+year;
        txtdate.setText(date1);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar C = Calendar.getInstance();
        int sYearIni = C.get(Calendar.YEAR);
        int sMonthIni = C.get(Calendar.MONTH);
        int sDayIni = C.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, sYearIni, sMonthIni, sDayIni);
//        return new TimePickerDialog()
    }

}
