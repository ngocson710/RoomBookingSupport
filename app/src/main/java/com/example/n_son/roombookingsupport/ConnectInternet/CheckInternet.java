package com.example.n_son.roombookingsupport.ConnectInternet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by NSON on 11/25/2017.
 */

public class CheckInternet {
    public Boolean checknetwork(Context mContext) {
        NetworkInfo info = ((ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo();
        if (info == null || !info.isConnected())
        {
            return false;
        }
        if (info.isRoaming()) {
            // here is the roaming option you can change it if you want to
            // disable internet while roaming, just return false
            return true;
        }

        return true;

    }
}
