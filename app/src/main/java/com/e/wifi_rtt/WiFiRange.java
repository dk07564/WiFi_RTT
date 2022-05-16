package com.e.wifi_rtt;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.rtt.RangingRequest;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class WiFiRange {
    WifiManager wifiManager;
    Context context;
    List<ScanResult> wifiList = new ArrayList<>();
    public List<ScanResult> wifiScan(){
        wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiList = wifiManager.getScanResults();

        return wifiList;
    }

//    @RequiresApi(api = Build.VERSION_CODES.P)
//    public void getRange(){
//        RangingRequest.Builder builder = new RangingRequest.Builder();
//        builder.addAccessPoint(wifiScan());
//
//        RangingRequest request = builder.build();
//    }
}
