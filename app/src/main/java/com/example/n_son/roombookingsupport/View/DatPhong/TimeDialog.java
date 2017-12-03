package com.example.n_son.roombookingsupport.View.DatPhong;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.icu.text.DateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by N-SON on 27/10/2017.
 */

@SuppressLint("ValidFragment")
public class TimeDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    EditText editTime;
    public TimeDialog(View view){
        this.editTime= (EditText) view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar C = Calendar.getInstance();
        int hour= C.HOUR_OF_DAY;
        int minute= C.MINUTE;
        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        String time= hour +":"+ minute;
        editTime.setText(time);
    }
}
