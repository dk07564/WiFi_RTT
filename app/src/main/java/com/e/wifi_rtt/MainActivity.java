package com.e.wifi_rtt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.rtt.WifiRttManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    WifiRttManager wifiRttManager;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        ActivityCompat.requestPermissions(this, permissions, 0);

        IntentFilter intentFilter = new IntentFilter(WifiRttManager.ACTION_WIFI_RTT_STATE_CHANGED);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(wifiRttManager.isAvailable()){
//                    Log.e("RTT", "TRUE");
                    Toast.makeText(MainActivity.this, "TRUE", Toast.LENGTH_SHORT).show();
                }else{
//                    Log.e("RTT", "FALSE");
                    Toast.makeText(MainActivity.this, "FALSE", Toast.LENGTH_SHORT).show();
                }
            }
        };
        getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);


//        Toast.makeText(MainActivity.this, String.valueOf(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_WIFI_RTT)), Toast.LENGTH_SHORT).show();

//        RTTCheck rttCheck = new RTTCheck();
//        if (rttCheck.isSupport(getApplicationContext())) {
//            Log.d("Support", "TRUE");
//            if (rttCheck.isAvailable(getApplicationContext())) {
//                Log.d("Available", "TRUE");
//            } else {
//                Log.d("Available", "FALSE");
//            }
//        } else {
//            Log.d("Support", "FALSE");
//        }

        
    }
}