package com.e.wifi_rtt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.rtt.WifiRttManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public class RTTCheck {
    WifiRttManager wifiRttManager;
    boolean isSupport;
    boolean isAvailable;

    //기기에서 WiFi-RTT 지원 확인
    @RequiresApi(api = Build.VERSION_CODES.P)
    public boolean isSupport(final Context context) {
        isSupport = context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_WIFI_RTT);
        return isSupport;
    }

    //WiFi-RTT 사용 가능 여부 확인
//    @RequiresApi(api = Build.VERSION_CODES.P)
//    public boolean isAvailable() {
//        IntentFilter intentFilter = new IntentFilter(WifiRttManager.ACTION_WIFI_RTT_STATE_CHANGED);
//        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//            @RequiresApi(api = Build.VERSION_CODES.P)
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                isAvailable = wifiRttManager.isAvailable();
//            }
//        };
//
//        return isAvailable;
//    }
}