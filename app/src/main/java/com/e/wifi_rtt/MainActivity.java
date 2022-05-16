package com.e.wifi_rtt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        ActivityCompat.requestPermissions(this, permissions, 0);

//        Toast.makeText(MainActivity.this, String.valueOf(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_WIFI_RTT)), Toast.LENGTH_SHORT).show();

        RTTCheck rttCheck = new RTTCheck();
        if (rttCheck.isSupport(getApplicationContext())) {
            Log.d("Support", "TRUE");
            if (rttCheck.isAvailable(getApplicationContext())) {
                Log.d("Available", "TRUE");
            } else {
                Log.d("Available", "FALSE");
            }
        } else {
            Log.d("Support", "FALSE");
        }
    }
}